package UI;

import javax.swing.*;
import javax.swing.plaf.BorderUIResource;
import javax.swing.plaf.IconUIResource;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.awt.*;
import java.awt.event.ActionListener;

public class Componentes {
    public static JButton criarBotao(String titulo, ActionListener acao) {
        JButton botao = new JButton(titulo);
        botao.setFont(new Font("Arial", Font.ITALIC, 16));
        botao.addActionListener(acao);
        botao.setBorder(BorderUIResource.getBlackLineBorderUIResource());

        return botao;
    }
}
