package UI;

import Core.Controller;
import Core.Hospede;
import Core.Reserva;
import Quartos.Quarto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class TelaRegistrarEntrada {
    public static void mostrar() {
        // Cria a frame
        JFrame frame = new JFrame("Formulário de Hotel");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500, 600);

        // Define o layout do frame
        frame.setLayout(new BorderLayout(10, 10));

        // Painel principal com borda
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new GridBagLayout());
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.WEST;


        // Campo de Nome
        JTextField txtNome = new JTextField(20);
        adicionarCampoNome(panelPrincipal, gbc, txtNome, "Nome:");

        // Campo de CPF
        JTextField txtCpf = new JTextField(20);
        adicionarCampoCpf(panelPrincipal, gbc, txtCpf, "CPF:");

        // Campo de Ano de Nascimento
        JSpinner spinnerAnoNascimento = new JSpinner(new SpinnerNumberModel(1990, 1900, 2024, 1));
        adicionarSpinnerCampoAnoDeNascimento(panelPrincipal, gbc, "Ano de Nascimento:",spinnerAnoNascimento );

        // Modalidade de Estadia
        ButtonGroup grupoEstadia = new ButtonGroup();
        String[] modalidades = {"1hr", "3hr", "Per noite"};
         adicionarCampoModalidade(panelPrincipal, gbc, "Modalidade", modalidades, grupoEstadia);

        // Tipo de Quarto
        String[] tiposQuarto = {"Safira", "Jade", "Diamante", "Esmeralda"};
        JComboBox<String> comboBox = new JComboBox<String>(tiposQuarto);
        adicionarCampoSelecionarQuarto(panelPrincipal, gbc, "Tipo de Quarto:", comboBox);

        // Adicionais de Pessoas
        JSpinner spinnerAdicionalPessoa = new JSpinner(new SpinnerNumberModel(1, 1, 9, 1));
        adicionarSpinnerAdicionaisDePessoas(panelPrincipal, gbc, "Adicional de Pessoas:", spinnerAdicionalPessoa);


        // Botão de Confirmação
        ActionListener acaoBotaoConfirmar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    // Pegando os dados dos campos de input do usuario
                    String nome = txtNome.getText();
                    String cpf = txtCpf.getText();
                    int anoNascimento = (int) spinnerAnoNascimento.getValue();
                    String modalidade = verificarBotaoModalidadeSelecionada(grupoEstadia);
                    String quarto = comboBox.getSelectedItem().toString();
                    int adicionalPessoas = (int) spinnerAdicionalPessoa.getValue();

                    Hospede novoHospede = new Hospede(nome, anoNascimento, cpf);
                    boolean jaPossuiHospede = Controller.jaPossuiHospede(novoHospede);

                    if (jaPossuiHospede) {
                        throw new IllegalArgumentException("Ja possui um hospede com esse cpf!");
                    }

                    Quarto quartoSelecionado = Controller.ocuparQuarto(quarto);
                    Reserva novaReserva = new Reserva(novoHospede, quartoSelecionado, adicionalPessoas, modalidade);
                    Controller.adicionarReserva(novaReserva);



                    JOptionPane.showMessageDialog(frame, "Informações confirmadas!");

                } catch (ArrayStoreException | IllegalArgumentException err) {
                    JOptionPane.showMessageDialog(frame, err.getMessage());
                }


            }
        };

        adicionarBotaConfirmacao(panelPrincipal, gbc, "Confirmar", acaoBotaoConfirmar);


        // Mensagem de Verificação
        adicionarMensagemDeVerificacao(panelPrincipal, gbc, "Verifique todas as informações antes de confirmar.");


        // Adiciona o painel principal ao frame
        frame.add(panelPrincipal, BorderLayout.CENTER);

        // Torna a frame visível
        frame.setVisible(true);
    }

    public static void adicionarCampoNome(JPanel panelPrincipal, GridBagConstraints gbc, JTextField textField, String titulo) {
        gbc.gridx = 0;
        gbc.gridy = 0;
        panelPrincipal.add(new JLabel(titulo), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panelPrincipal.add(textField, gbc);

    }

    public static void adicionarCampoCpf(JPanel panelPrincipal, GridBagConstraints gbc, JTextField textField, String titulo) {
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        panelPrincipal.add(new JLabel(titulo), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        panelPrincipal.add(textField, gbc);
    }

    public static void adicionarSpinnerCampoAnoDeNascimento(JPanel panelPrincipal, GridBagConstraints gbc,  String titulo, JSpinner spinnerAnoNascimento) {
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        panelPrincipal.add(new JLabel(titulo), gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        panelPrincipal.add(spinnerAnoNascimento, gbc);
    }

    public static void adicionarCampoModalidade(JPanel panelPrincipal, GridBagConstraints gbc, String titulo, String[] modalidades, ButtonGroup grupoEstadia) {
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        panelPrincipal.add(new JLabel(titulo), gbc);

        JRadioButton[] botoes = new JRadioButton[modalidades.length];
        JPanel panelEstadia = new JPanel(new FlowLayout(FlowLayout.LEFT));

        for (int i = 0; i < modalidades.length; i++) {
            String modalidade = modalidades[i];
            JRadioButton botao = new JRadioButton(modalidade);
            botao.setActionCommand(modalidade);
            grupoEstadia.add(botao);
            botao.setSelected(i == 0);
            botoes[i] = botao;
            panelEstadia.add(botao);
        }

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        panelPrincipal.add(panelEstadia, gbc);


    }

    public static void adicionarCampoSelecionarQuarto(JPanel panelPrincipal, GridBagConstraints gbc, String titulo, JComboBox<String> comboBox) {
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        panelPrincipal.add(new JLabel(titulo), gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 2;

        panelPrincipal.add(comboBox, gbc);
    }

    public static void adicionarSpinnerAdicionaisDePessoas(JPanel panelPrincipal, GridBagConstraints gbc, String titulo, JSpinner spinnerAdicionalPessoa) {
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        panelPrincipal.add(new JLabel(titulo), gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        panelPrincipal.add(spinnerAdicionalPessoa, gbc);
    }

    public static void adicionarBotaConfirmacao(JPanel panelPrincipal, GridBagConstraints gbc, String titulo, ActionListener acao) {
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 4;
        gbc.anchor = GridBagConstraints.CENTER;
        JButton botaoConfirmar = new JButton(titulo);
        botaoConfirmar.addActionListener(acao);
        panelPrincipal.add(botaoConfirmar, gbc);
    }

    public static void adicionarMensagemDeVerificacao(JPanel panelPrincipal, GridBagConstraints gbc, String titulo) {
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 3;
        gbc.anchor = GridBagConstraints.CENTER;
        JLabel labelMensagem = new JLabel(titulo, SwingConstants.CENTER);
        labelMensagem.setFont(new Font("Arial", Font.ITALIC, 12));
        panelPrincipal.add(labelMensagem, gbc);
    }

    public static String verificarBotaoModalidadeSelecionada( ButtonGroup grupoEstadia) {
        return (grupoEstadia.getSelection() != null)  ? grupoEstadia.getSelection().getActionCommand() : null;
    }

}




