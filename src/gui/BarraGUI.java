package gui;

import javax.swing.JPanel;
import java.awt.Color;
import view.BarraView;
import java.awt.Graphics;

public class BarraGUI extends JPanel {

    private int posX, posY, ancho, alto;
    private Color background, foreground;

    public BarraGUI(int anchoTablero, int altoBarra, int posY, int borde, BarraView posicionInicial) {
        super();
        this.setBounds(borde, posY, anchoTablero, altoBarra);
        setPosicion(posicionInicial);
        background = new Color(235, 235, 235);  // rgb(235, 235, 235)
        foreground = new Color(27, 34, 42);     // rgb(27, 34, 42)

        this.setVisible(true);
    }

    public void setPosicion(BarraView posicion) {
        posX = posicion.getX();
        posY = 0;
        ancho = posicion.getAncho();
        alto = posicion.getAlto();
        this.repaint();
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(background);
        g.setColor(foreground);

        g.drawRect(posX, posY, ancho, alto);
        g.fillRect(posX, posY, ancho, alto);
    }
}
