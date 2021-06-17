package gui;

import javax.swing.JPanel;

import view.FilasView;
import view.LadrilloView;

import java.awt.Color;
import java.util.List;

public class FilasGUI extends JPanel{
    public FilasGUI(int anchoTablero, int altoCadaLadrillo, int cantFilas, int ancho_borde, int margenLadrillo) {

        this.setBounds(ancho_borde, ancho_borde, anchoTablero - (2*ancho_borde), altoCadaLadrillo*cantFilas + (margenLadrillo*2));
        this.setBackground(new Color(0, 0, 0, 0));
        // this.setBackground(Color.white);
        this.setLayout(null);
        this.setVisible(true);
    }

    public void dibujarLadrillos(FilasView filas) {
        for (List<LadrilloView> fila : filas.getFilas()) {
            for (LadrilloView ladrillo : fila) {
                this.add(new LadrilloGUI(ladrillo));
            }
        }
    }

}
