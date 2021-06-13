package gui;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Container;
import java.awt.Color;

public class VentanaPrincipal extends JFrame{

    private static final long serialVersionUID = 45L;
    JLabel helloLbl;

    public VentanaPrincipal() {
        configurar();
        this.setSize(1000, 1000);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void configurar() {
        Container c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.WHITE);
        helloLbl = new JLabel("Hello world");
        c.setVisible(true);
        c.add(helloLbl);
    }

}
