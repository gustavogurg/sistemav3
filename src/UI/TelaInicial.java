package UI;

import javax.swing.*;
import Core.Financeiro;
import javax.swing.plaf.BorderUIResource;

import Core.Financeiro;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class TelaInicial {
    public static void mostrar() {

        // Configurar frame da tela inicial
        JFrame frame = new JFrame("Tela Inicial");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 800);
        frame.setLayout(new BorderLayout());



        // Criar seção para titulo e subtitulo
        JPanel panelSuperior = new JPanel();
        panelSuperior.setLayout(new GridLayout(2, 1));
        
        JLabel titulo = new JLabel("Motel Joias", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        panelSuperior.add(titulo);

        JLabel subtitulo = new JLabel("Seu buraco em boas mãos", SwingConstants.CENTER);
        subtitulo.setFont(new Font("Arial", Font.PLAIN, 18));
        panelSuperior.add(subtitulo);

        frame.add(panelSuperior, BorderLayout.NORTH);


        // Criar seção para botões
        JPanel panelBotoes = new JPanel();
        panelBotoes.setLayout(new GridLayout(2, 5));



        // Criar botão de registrar entrada
        String tituloRegistrarEntrada = "Registrar Entrada";
        ActionListener acaoRegistrarEntrada = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(((JButton) e.getSource()).getText() + " clicado");
                TelaRegistrarEntrada.mostrar();
            }
        };

        JButton botaoRegistrarEntrada = Componentes.criarBotao(tituloRegistrarEntrada, acaoRegistrarEntrada);
        panelBotoes.add(botaoRegistrarEntrada);






        // Criar botão de registrar saída
        String tituloRegistrarSaida = "Registrar Saida";
        ActionListener acaoRegistrarSaida = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(((JButton) e.getSource()).getText() + " clicado");
                RegistrarSaida.mostrar();
            }
        };

        JButton botaoRegistrarSaida = Componentes.criarBotao(tituloRegistrarSaida, acaoRegistrarSaida);
        panelBotoes.add(botaoRegistrarSaida);





        // Criar botão de verificar reserva
        String tituloVerificarReserva = "Verificar Reserva";
        ActionListener acaoVerificarReserva = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(((JButton) e.getSource()).getText() + " clicado");
                VerificarReservas.mostrar();
            }
        };

        JButton botaoVerificarReserva = Componentes.criarBotao(tituloVerificarReserva, acaoVerificarReserva);
        panelBotoes.add(botaoVerificarReserva);





        // Criar botão de ver quartos
        String tituloVerQuartos = "Verificar Quartos";
        ActionListener acaoVerQuartos = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(((JButton) e.getSource()).getText() + " clicado");
                VerificarQuartos.mostrar();
            }
        };

        JButton botaoVerQuartos = Componentes.criarBotao(tituloVerQuartos, acaoVerQuartos);
        panelBotoes.add(botaoVerQuartos);





        // Criar botão de financeiro
        String tituloFinanceiro = "Financeiro";
        ActionListener acaoFinanceiro = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(((JButton) e.getSource()).getText() + " clicado");
                Financeiro.mostrar();
            }
        };

        JButton botaoFinanceiro = Componentes.criarBotao(tituloFinanceiro, acaoFinanceiro);
        panelBotoes.add(botaoFinanceiro);



        frame.add(panelBotoes, BorderLayout.CENTER);
        frame.setVisible(true);
    }

}
