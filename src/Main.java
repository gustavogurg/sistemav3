import Core.Controller;
import Quartos.Diamante;
import Quartos.Esmeralda;
import Quartos.Jade;
import Quartos.Safira;
import UI.TelaInicial;

import javax.swing.*;
import javax.swing.plaf.BorderUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Main {
    public static void main(String[] args) {

        Controller.adicionarQuarto(new Safira(1, true));
        Controller.adicionarQuarto(new Safira(2, true));
        Controller.adicionarQuarto(new Safira(3, true));
        Controller.adicionarQuarto(new Safira(4, true));
        Controller.adicionarQuarto(new Safira(5, true));

        Controller.adicionarQuarto(new Jade(6, true));
        Controller.adicionarQuarto(new Jade(7, true));
        Controller.adicionarQuarto(new Jade(8, true));

        Controller.adicionarQuarto(new Esmeralda(9, true));
        Controller.adicionarQuarto(new Esmeralda(10, true));

        Controller.adicionarQuarto(new Diamante(9, true));
        Controller.adicionarQuarto(new Diamante(10, true));

        TelaInicial.mostrar();
    }
}

