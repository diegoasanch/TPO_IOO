package gui;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Container;
import java.awt.Color;

public class VentanaPrincipal extends JFrame{

    private static final long serialVersionUID = 45L;

    public VentanaPrincipal() {
        configurar();
        this.setSize(1000, 1000);
        this.setVisible(true);
        this.setTitle("Arkanoid");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void configurar() {
        Container c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.WHITE);
        c.add(new TableroDeJuego());
        c.setVisible(true);
       
    }

}
