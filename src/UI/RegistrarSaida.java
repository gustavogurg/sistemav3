package UI;


import Core.Controller;
import Core.Reserva;
import Core.Validacao;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class RegistrarSaida {

    public static void mostrar() {
        JFrame frame = new JFrame("Registrar Saída");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        JLabel tituloLabel = new JLabel("Registrar Saída");
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 20));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.CENTER;
        frame.add(tituloLabel, gbc);

        JLabel instrucaoLabel = new JLabel("Qual reserva você deseja finalizar?");
        instrucaoLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        gbc.gridy = 1;
        frame.add(instrucaoLabel, gbc);

        JLabel idLabel = new JLabel("ID Reserva");
        idLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.EAST;
        frame.add(idLabel, gbc);

        JTextField idTextField = new JTextField(15);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        frame.add(idTextField, gbc);

        JButton confirmarButton = new JButton("Confirmar Saída");
        confirmarButton.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(20, 0, 0, 0);
        frame.add(confirmarButton, gbc);

        confirmarButton.addActionListener(new ActionListener()  {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    if (idTextField.getText().isEmpty()) {
                        throw new IllegalArgumentException("Digite um ID");
                    }

                    if (Validacao.temLetras(idTextField.getText())) {
                        throw new IllegalArgumentException("ID Inválido! Digite apenas numeros");
                    }

                    int id = Integer.parseInt(idTextField.getText());
                    Controller.removerReserva(id);

                    Controller.removerReserva(id);
                    JOptionPane.showMessageDialog(frame, "Ação concluída, verifique suas reservas!");

                } catch (NumberFormatException numErr) {
                    JOptionPane.showMessageDialog(frame, "ID Inválido! Digite novamente!");
                } catch (IllegalArgumentException argErr) {
                    JOptionPane.showMessageDialog(frame, argErr.getMessage());
                }

            }
        });

        frame.setVisible(true);

    }

}
