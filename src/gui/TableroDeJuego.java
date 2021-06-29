package gui;

import java.util.ArrayList;
import java.util.List;
import java.awt.Dimension;
import java.awt.Color;

import javax.swing.JPanel;

import negocio.Controlador;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import view.BarraView;
import view.BolaView;
import view.FilasView;
import view.LadrilloView;

public class TableroDeJuego extends JPanel {
    private final int WIDTH = 540;
    private final int HEIGHT = 590;
    private final int BORDE = 10;
    private Color borderColor, background;
    private BarraGUI barra;
    // private BolaGUI bola;
    private FilasGUI filas;

    private JLabel bola;
    private int posX, posY, diametro;

    public TableroDeJuego(BarraView posBarraInicial, BolaView posBolaInicial) {
        super();
        borderColor = new Color(87, 181, 253); // rgb(87, 181, 253)
        background = new Color(235, 235, 235);  // rgb(235, 235, 235)

        this.setPreferredSize(new Dimension(WIDTH+(2*BORDE), HEIGHT));
        this.setBackground(background);
        this.setBorder(BorderFactory.createMatteBorder(BORDE, BORDE, 0, BORDE, borderColor));
        this.setLayout(null);

        configurar(posBarraInicial, posBolaInicial);
    }

    private void configurar(BarraView posBarraInicial, BolaView posBolaInicial) {

        // TODO Pedir los views del controlador
        //Controlador ANCHO_BARRA = new Controlador.getBarra(); //ME PIDE QUE SEA ESTATICO???
        int ANCHO_BARRA = 85;
        int ALTO_BARRA = 20;
        int ALTO_LADRILLO = 40;
        int ANCHO_LADRILLO = 90;
        int DIAMETRO_BOLA = 30;

        BolaView posBola = new BolaView(40, 70, DIAMETRO_BOLA);
        // fin TODO

        barra = new BarraGUI(WIDTH, ALTO_BARRA, HEIGHT, BORDE, posBarraInicial);
        bola = new JLabel(new ImageIcon(getClass().getResource("Assets/bola.png")));

        // bola = new BolaGUI(WIDTH, HEIGHT, BORDE, posBolaInicial);
        // bola = new BolaGUI(WIDTH, HEIGHT, BORDE, posBola);
        filas = new FilasGUI(WIDTH, ALTO_LADRILLO, 5, BORDE, ANCHO_LADRILLO/2);

        filas.dibujarLadrillos(testFilas(ANCHO_LADRILLO, ALTO_LADRILLO)); // TODO: Pedir al controlador

        this.add(bola);
        this.add(filas);
        this.add(barra);
    }

    //! Quitar esto despues
    private FilasView testFilas(int ancho, int alto) {

        int margen = ancho/2;

        List<List<LadrilloView>> resultado = new ArrayList<>();

        for (int i=0; i<5; i++) {
            List<LadrilloView> filaActual = new ArrayList<>();

            for (int j=0; j<5; j++) {
                LadrilloView ladrilloActual = new LadrilloView(margen + ancho*j, margen + alto*i, ancho, alto, false);
                filaActual.add(ladrilloActual);
            }
            resultado.add(filaActual);
        }
        return new FilasView(resultado);
    }

    public void setearPosicionBarra(BarraView posicion) {
        barra.setPosicion(posicion);
    }

    public void setearPosicionBola(BolaView posicion) {
        posX = posicion.getX();
        posY = posicion.getY();
        diametro = posicion.getDiametro();
        bola.setBounds(posX, posY, diametro, diametro);

        // bola.setPosicion(posicion);
    }
}
