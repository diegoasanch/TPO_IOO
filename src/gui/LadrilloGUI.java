package gui;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;

import view.LadrilloView;

public class LadrilloGUI extends JPanel{

    private Color fill, border, transparente, bg, line;
    private LadrilloView posicion;

    public LadrilloGUI(LadrilloView posicionInicial) {
        super();
        bg = new Color(89, 192, 255); // rgb(89, 192, 255)
        border = new Color(35, 39, 44);// rgb(35, 39, 44)
        transparente = new Color(0, 0, 0, 0);
        this.setBounds(
            posicionInicial.getX(),
            posicionInicial.getY(),
            posicionInicial.getAncho()+1,
            posicionInicial.getAlto()+1
        );
        setPosicion(posicionInicial);
        this.setVisible(true);
    }

    public void setPosicion(LadrilloView posicion) {
        this.posicion = posicion;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (!posicion.getEstaRoto()) {
            line = border;
            fill = bg;
        }
        else {
            line = transparente;
            fill = transparente;
        }
        g.setColor(line);
        g.drawRect(0, 0, posicion.getAncho(), posicion.getAlto());
        g.setColor(fill);
        g.fillRect(0, 0, posicion.getAncho(), posicion.getAlto());
    }
}
