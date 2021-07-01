package gui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import constantes.DimensionTablero;

import view.BarraView;
import view.BolaView;
import view.FilasView;

public class TableroDeJuego extends JPanel {
    private int tableroWidth;
    private int tableroHeight;
    private int borde;
    private Color borderColor, bgColor;
    private BarraGUI barra;
    private BolaGUI bola;
    private FilasGUI filas;

    public TableroDeJuego(BarraView posBarraInicial, BolaView posBolaInicial, FilasView posFilasInicial) {
        super();
        this.tableroWidth = DimensionTablero.TAMANIO_X;
        this.tableroHeight = DimensionTablero.TAMANIO_Y;
        this.borde = DimensionTablero.BORDE;
        borderColor = new Color(87, 181, 253); // rgb(87, 181, 253)
        bgColor = new Color(235, 235, 235);  // rgb(235, 235, 235)
        // bgColor = new Color(0, 0, 0, 100);  // rgba(235, 0, 0, 100)

        this.setPreferredSize(new Dimension(tableroWidth+(2*borde), tableroHeight));
        this.setBackground(bgColor);
        this.setBorder(BorderFactory.createMatteBorder(borde, borde, 0, borde, borderColor));
        this.setLayout(null);

        configurar(posBarraInicial, posBolaInicial, posFilasInicial);
    }

    private void configurar(BarraView posBarraInicial, BolaView posBolaInicial, FilasView posFilasInicial) {

        barra = new BarraGUI(this.tableroWidth, this.tableroHeight, borde, posBarraInicial);
        filas = new FilasGUI(tableroWidth, 5, borde, posFilasInicial);
        bola = new BolaGUI(tableroWidth, tableroHeight, borde, posBolaInicial);

        setearPosicionBola(posBolaInicial);

        this.add(bola);
        this.add(filas);
        this.add(barra);
    }

    public void setearPosicionBarra(BarraView posicion) {
        barra.setPosicion(posicion);
    }

    public void setearPosicionBola(BolaView posicion) {
        bola.setPosicion(posicion);
    }

    public void setearEstadoLadrillos(FilasView posicion) {
        filas.dibujarLadrillos(posicion);
    }
}
