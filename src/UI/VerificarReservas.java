package UI;

import Core.Controller;
import Core.Reserva;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class VerificarReservas {
    public static void mostrar() {
        JFrame frame = new JFrame("Exemplo de Tabela");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null); // Centraliza a janela na tela

        ArrayList<Reserva> reservas = Controller.getReservas();

        // Dados para a tabela
        Object[][] data = new Object[reservas.size()][4];
        for (int i = 0; i < reservas.size(); i++) {
            Reserva reserva = reservas.get(i);
            data[i][0] = reserva.getId();
            data[i][1] = reserva.getQuarto().getNome();
            data[i][2] = reserva.getModalidade();
            data[i][3] = reserva.getAdicionalDePessoas() + 1;
        }

        // Colunas da tabela
        String[] columnNames = {"ID", "Quarto", "Modalidade", "Pessoas"};

        // Modelo de tabela padrão
        DefaultTableModel model = new DefaultTableModel(data, columnNames) {
            // Sobrescreve o método isCellEditable para tornar as células não editáveis
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        // Criação da JTable
        JTable table = new JTable(model);

        // Configuração da tabela (opcional)
        table.setFillsViewportHeight(true); // Preenche a altura do viewport
        table.setPreferredScrollableViewportSize(new Dimension(500, 300)); // Tamanho preferido da tabela

        // Coloca a tabela em um JScrollPane para adicionar rolagem
        JScrollPane scrollPane = new JScrollPane(table);

        // Adiciona o JScrollPane ao frame
        frame.add(scrollPane, BorderLayout.CENTER);

        // Torna a janela visível
        frame.setVisible(true);
    }
}
