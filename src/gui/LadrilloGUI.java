package gui;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import java.awt.Color;
import view.LadrilloView;


public class LadrilloGUI extends JPanel{

    private Color fill, border, transparent;

    public LadrilloGUI(LadrilloView posicionInicial) {
        super();
        fill = new Color(89, 192, 255); // rgb(89, 192, 255)
        border = new Color(35, 39, 44);// rgb(35, 39, 44)
        transparent = new Color(0, 0, 0, 0);
        setPosicion(posicionInicial);
        this.setVisible(true);
    }

    public void setPosicion(LadrilloView posicion) {
        this.setBounds(posicion.getX(), posicion.getY(), posicion.getAncho(), posicion.getAlto());
        if (posicion.getEstaRoto()) {
            this.setBackground(transparent);
            this.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, transparent));
        }
        else {
            this.setBackground(fill);
            this.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, border));
        }
    }
}
