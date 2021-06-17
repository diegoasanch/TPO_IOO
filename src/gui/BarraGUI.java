package gui;

import javax.swing.JPanel;
import java.awt.Color;
import view.BarraView;

public class BarraGUI extends JPanel{

    public BarraGUI(BarraView posicionInicial) {
        super();
        this.setBackground(Color.black);
        setPosicion(posicionInicial);
        this.setVisible(true);
    }

    public void setPosicion(BarraView posicion) {
        this.setBounds(posicion.getX(), posicion.getY(), posicion.getAncho(), posicion.getAlto());
    }
}
