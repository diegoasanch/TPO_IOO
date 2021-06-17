package gui;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import java.awt.Color;
import view.LadrilloView;


public class LadrilloGUI extends JPanel{

    public LadrilloGUI(LadrilloView posicionInicial) {
        super();
        this.setBackground(Color.black);
        setPosicion(posicionInicial);
        this.setVisible(true);
        this.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
    }

    public void setPosicion(LadrilloView posicion) {
        this.setBounds(posicion.getX(), posicion.getY(), posicion.getAncho(), posicion.getAlto());
        if (posicion.getEstaRoto())
            this.setBackground(new Color(0, 0, 0, 0));
        else
            this.setBackground(Color.blue);
    }
}
