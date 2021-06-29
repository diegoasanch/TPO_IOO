package gui;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import view.BolaView;

import java.awt.Color;
import java.awt.Graphics;

public class BolaGUI extends JPanel {

    private int posX, posY, diametro;
    private JLabel bola;

    public BolaGUI(int tableroTamanioX, int tableroTamanioY, int ancho_borde, BolaView posicionInicial) {
        this.setBounds(ancho_borde, ancho_borde, tableroTamanioX, tableroTamanioY);
        this.setBackground(new Color(0, 0, 0, 0)); // Transparente
        // this.setBackground(new Color(255, 255, 0, 100)); // Rojo trnaslucido
        // bola = new JLabel(new ImageIcon(getClass().getResource("Assets/bola.png")));
        this.add(bola);
        setPosicion(posicionInicial);
    }

    public void setPosicion(BolaView posicion) {
        posX = posicion.getX();
        posY = posicion.getY();
        diametro = posicion.getDiametro();
        bola.setBounds(posX, posY, diametro, diametro);
        this.repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.red); // TODO darle un color sexy
        g.fillOval(posX, posY, diametro, diametro);
    }


}
