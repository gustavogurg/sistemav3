import Core.Controller;
import Core.Financeiro;
import Core.Reserva;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaFinanceiro extends JFrame {

    private JTextArea textAreaRelatorio;

    public TelaFinanceiro() {
        setTitle("Financeiro do Motel Joias");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Painel principal
        JPanel panelPrincipal = new JPanel(new BorderLayout());

        // Área de texto para o relatório
        textAreaRelatorio = new JTextArea();
        textAreaRelatorio.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textAreaRelatorio);
        panelPrincipal.add(scrollPane, BorderLayout.CENTER);

        // Botão para gerar o relatório
        JButton btnGerarRelatorio = new JButton("Gerar Relatório");
        btnGerarRelatorio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gerarRelatorio();
            }
        });
        panelPrincipal.add(btnGerarRelatorio, BorderLayout.SOUTH);

        add(panelPrincipal);
    }

    private void gerarRelatorio() {
        Financeiro financeiro = new Financeiro();
        financeiro.setReservas(Controller.getReservas()); // Obtém as reservas do Controller
        String relatorio = financeiro.gerarRelatorioFinanceiro();
        textAreaRelatorio.setText(relatorio);
    }

    public static void mostrar() {
        SwingUtilities.invokeLater(() -> {
            TelaFinanceiro telaFinanceiro = new TelaFinanceiro();
            telaFinanceiro.setVisible(true);
        });
    }
}
