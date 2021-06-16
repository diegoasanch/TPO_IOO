package gui;

import java.awt.Container;
import java.awt.Dimension;
import java.util.Timer;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.BorderFactory;

public class TableroDeJuego extends JPanel {
    private JLabel lblLadrillo, lblBarra, lblBola, lblBordeLat, lblBordeSup;
    private Timer timer;
    private final int WIDHT = 560;
    private final int HEIGHT = 740;
    private Color borderColor;

    public TableroDeJuego(){
        super();
        borderColor = new Color(87, 181, 253); // rgb(87, 181, 253)
        configurar();
    }

    private void configurar() {
        this.setPreferredSize(new Dimension(WIDHT, HEIGHT));
        this.setBackground(Color.gray);
        this.setBorder(BorderFactory.createMatteBorder(10, 10, 0, 10, borderColor));
    }
}
