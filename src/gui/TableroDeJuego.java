package gui;

import java.util.ArrayList;
import java.util.List;
import java.awt.Dimension;
import java.awt.Color;

import javax.swing.JPanel;

import constantes.DimensionTablero;
import negocio.Controlador;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import view.BarraView;
import view.BolaView;
import view.FilasView;
import view.LadrilloView;

public class TableroDeJuego extends JPanel {
    private int WIDTH;
    private int HEIGHT;
    private int BORDE;
    private Color borderColor, background;
    private BarraGUI barra;
    private BolaGUI bola;
    // private JLabel bola;
    private FilasGUI filas;

    private int posX, posY, diametro;

    public TableroDeJuego(BarraView posBarraInicial, BolaView posBolaInicial, FilasView posFilasInicial) {
        super();
        this.WIDTH = DimensionTablero.TAMANIO_X;
        this.HEIGHT = DimensionTablero.TAMANIO_Y;
        this.BORDE = DimensionTablero.BORDE;
        borderColor = new Color(87, 181, 253); // rgb(87, 181, 253)
        background = new Color(235, 235, 235);  // rgb(235, 235, 235)
        // background = new Color(0, 0, 0, 100);  // rgba(235, 0, 0, 100)

        this.setPreferredSize(new Dimension(WIDTH+(2*BORDE), HEIGHT));
        this.setBackground(background);
        this.setBorder(BorderFactory.createMatteBorder(BORDE, BORDE, 0, BORDE, borderColor));
        this.setLayout(null);

        configurar(posBarraInicial, posBolaInicial, posFilasInicial);
    }

    private void configurar(BarraView posBarraInicial, BolaView posBolaInicial, FilasView posFilasInicial) {

        barra = new BarraGUI(this.WIDTH, this.HEIGHT, BORDE, posBarraInicial);
        filas = new FilasGUI(WIDTH, 5, BORDE, posFilasInicial);
        bola = new BolaGUI(WIDTH, HEIGHT, BORDE, posBolaInicial);

        // bola = new JLabel(new ImageIcon(getClass().getResource("Assets/bola.png")));
        setearPosicionBola(posBolaInicial);
        // bola = new BolaGUI(WIDTH, HEIGHT, BORDE, posBolaInicial);


        this.add(bola);
        this.add(filas);
        this.add(barra);
    }

    public void setearPosicionBarra(BarraView posicion) {
        barra.setPosicion(posicion);
    }

    public void setearPosicionBola(BolaView posicion) {
        posX = posicion.getX();
        posY = posicion.getY();
        diametro = posicion.getDiametro();
        // bola.setBounds(posX, posY, diametro, diametro);

        bola.setPosicion(posicion);
    }

    public void setearEstadoLadrillos(FilasView posicion) {
        filas.dibujarLadrillos(posicion);
    }
}
