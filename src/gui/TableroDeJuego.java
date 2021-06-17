package gui;

import java.util.Timer;
import java.util.ArrayList;
import java.util.List;
import java.awt.Dimension;
import java.awt.Color;

import javax.swing.JPanel;

import view.BarraView;
import view.BolaView;
import view.FilasView;
import view.LadrilloView;

import javax.swing.JLabel;
import javax.swing.BorderFactory;

public class TableroDeJuego extends JPanel {
    private JLabel lblLadrillo, lblBarra, lblBola, lblBordeLat, lblBordeSup;
    private Timer timer;
    private final int WIDHT = 560;
    private final int HEIGHT = 740;
    private Color borderColor, ladrilloColor;
    private BarraGUI barra;
    private BolaGUI bola;
    private LadrilloGUI ladrillo;
    private FilasGUI filas;
    private int ancho_borde = 10;

    public TableroDeJuego(){
        super();
        borderColor = new Color(87, 181, 253); // rgb(87, 181, 253)
        configurar();
    }

    private void configurar() {
        this.setPreferredSize(new Dimension(WIDHT, HEIGHT));
        this.setBackground(Color.gray);
        this.setBorder(BorderFactory.createMatteBorder(ancho_borde, ancho_borde, 0, ancho_borde, borderColor));
        this.setLayout(null);

        // ! Quitar esto
        int ALTO_LADRILLO = 40;

        BarraView posBarra = new BarraView(300, 700, 85, 20);
        BolaView posBola = new BolaView(40, 70, 30);
        // LadrilloView posLadrillo = new LadrilloView(50, 50, 50, 20, false);

        // ! fin Quitar esto
        barra = new BarraGUI(posBarra);
        bola = new BolaGUI(WIDHT, HEIGHT, ancho_borde, posBola);
        // ladrillo = new LadrilloGUI(posLadrillo);
        filas = new FilasGUI(WIDHT, ALTO_LADRILLO, 5, ancho_borde, 45);

        filas.dibujarLadrillos(testFilas());

        this.add(barra);
        this.add(bola);
        this.add(filas);

        // this.add(ladrillo);
    }

    //! Quitar esto despues
    private FilasView testFilas() {

        int margen = 45;
        int ancho = 90;
        int alto = 40;

        List<List<LadrilloView>> filas = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            List<LadrilloView> filaActual = new ArrayList<>();

            for (int j = 0; j < 5; j++) {
                LadrilloView ladrilloActual = new LadrilloView(margen + ancho*j, margen + alto*i, ancho, alto, false);
                filaActual.add(ladrilloActual);
            }
            filas.add(filaActual);
        }
        return new FilasView(filas);
    }
}
