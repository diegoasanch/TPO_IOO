package gui;

import javax.swing.JPanel;

import view.BolaView;

import java.awt.Color;
import java.awt.Graphics;

public class BolaGUI extends JPanel {

    private int posX, posY, diametro;

    public BolaGUI(int tableroTamanioX, int tableroTamanioY, int ancho_borde, BolaView posicionInicial) {
        this.setBounds(ancho_borde, ancho_borde, tableroTamanioX - (2*ancho_borde), tableroTamanioY);
        this.setBackground(new Color(0, 0, 0, 0)); // Transparente
        setPosicion(posicionInicial);
    }


    public void setPosicion(BolaView posicion) {
        posX = posicion.getX();
        posY = posicion.getY();
        diametro = posicion.getDiametro();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.red); // TODO darle un color sexy
        g.fillOval(posX, posY, diametro, diametro);
    }


}
