package gui;

import javax.swing.JPanel;

import view.FilasView;
import view.LadrilloView;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import constantes.DimensionesLadrillo;
public class FilasGUI extends JPanel{
    List<List<LadrilloGUI>> ladrillos;
    int filas;
    int columnas;

    public FilasGUI(int anchoTablero, int cantFilas, int ancho_borde, FilasView posLadrillosInicial) {
        int altoCadaLadrillo = DimensionesLadrillo.TAMANIO_Y;
        int margenLadrillo = DimensionesLadrillo.MARGEN;

        this.setBounds(ancho_borde, ancho_borde, anchoTablero, altoCadaLadrillo*cantFilas + (margenLadrillo*2));
        // this.setBackground(Color.white);
        // this.setBackground(new Color(255, 0, 0, 180));
        this.setBackground(new Color(0, 0, 0, 0));
        this.setLayout(null);

        this.filas = posLadrillosInicial.getFilas().size();
        this.columnas = posLadrillosInicial.getFilas().get(0).size();
        crearLadrillo(posLadrillosInicial);

        this.setVisible(true);
    }

    private void crearLadrillo(FilasView filas) {
        ladrillos = new ArrayList<>();
        List<LadrilloGUI> filaGUI;

        for (List<LadrilloView> fila : filas.getFilas()) {
            filaGUI = new ArrayList<>();

            for (LadrilloView ladrillo : fila) {
                LadrilloGUI actual = new LadrilloGUI(ladrillo);
                filaGUI.add(actual);
                this.add(actual);
            }
            ladrillos.add(filaGUI);
        }
    }

    public void dibujarLadrillos(FilasView filasToDraw) {
        LadrilloGUI actual;
        LadrilloView actualToDraw;
        List<List<LadrilloView>> toDraw = filasToDraw.getFilas();

        for (int fila = 0; fila < filas; fila++) {
            for (int col = 0; col < columnas; col++) {
                actualToDraw = toDraw.get(fila).get(col);
                actual = ladrillos.get(fila).get(col);
                actual.setPosicion(actualToDraw);
                // System.out.print((actualToDraw.getEstaRoto() ? " " : 'x') + " ");
            }
            // System.out.println();
        }
        // System.out.println("\n\n\n\n");
    }

}
