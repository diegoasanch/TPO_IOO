package gui;

import javax.swing.JPanel;

import view.FilasView;
import view.LadrilloView;

import java.awt.Color;
import java.util.List;

import constantes.DimensionesLadrillo;
public class FilasGUI extends JPanel{
    public FilasGUI(int anchoTablero, int cantFilas, int ancho_borde, FilasView posLadrillosInicial) {
        int altoCadaLadrillo = DimensionesLadrillo.TAMANIO_Y;
        int margenLadrillo = DimensionesLadrillo.MARGEN;

        this.setBounds(ancho_borde, ancho_borde, anchoTablero, altoCadaLadrillo*cantFilas + (margenLadrillo*2));
        // this.setBackground(Color.white);
        this.setBackground(new Color(0, 0, 0, 0));
        this.setLayout(null);
        this.setVisible(true);

        dibujarLadrillos(posLadrillosInicial);
    }

    public void dibujarLadrillos(FilasView filas) {
        for (List<LadrilloView> fila : filas.getFilas()) {
            for (LadrilloView ladrillo : fila) {
                this.add(new LadrilloGUI(ladrillo));
            }
        }
    }

}
