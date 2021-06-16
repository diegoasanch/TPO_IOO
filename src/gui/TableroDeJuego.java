package gui;

import java.awt.Container;
import java.util.Timer;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;

public class TableroDeJuego extends JPanel {
    private JLabel lblLadrillo, lblBarra, lblBola, lblBordeLat, lblBordeSup;
    private Timer timer;


    public TableroDeJuego(){
        super();
        configurar();
        // this.setSize(600, 400);
    }


    private void configurar() {
        this.setBounds(10, 10, 60, 60);
        this.setBackground(Color.gray);
        // Container c = this.getContentPane();
    }
}