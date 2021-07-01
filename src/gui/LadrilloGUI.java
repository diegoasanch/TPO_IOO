package gui;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import java.awt.Color;
import view.LadrilloView;
import java.awt.Graphics;


public class LadrilloGUI extends JPanel{

    private Color fill, border, black;
    private LadrilloView posicion;

    public LadrilloGUI(LadrilloView posicionInicial) {
        super();
        fill = new Color(89, 192, 255); // rgb(89, 192, 255)
        border = new Color(35, 39, 44);// rgb(35, 39, 44)
        black = new Color(0, 0, 0);
        this.setBounds(
            posicionInicial.getX(),
            posicionInicial.getY(),
            posicionInicial.getAncho()+1,
            posicionInicial.getAlto()+1
        );
        setPosicion(posicionInicial);
        this.setVisible(true);
    }

    public void setPosicion(LadrilloView posicion) {
        this.posicion = posicion;
        this.repaint();
        // this.setBounds(posicion.getX(), posicion.getY(), posicion.getAncho(), posicion.getAlto());
        // if (posicion.getEstaRoto()) {
        //     System.out.println("Rendering broken brick");
        //     this.setBackground(black);
        //     this.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, black));
        // }
        // else {
        //     this.setBackground(fill);
        //     this.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, border));
        // }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(border);
        g.drawRect(0, 0, posicion.getAncho(), posicion.getAlto());
        g.setColor(fill);
        g.fillRect(0, 0, posicion.getAncho(), posicion.getAlto());

        this.setVisible(!posicion.getEstaRoto());

        // }
        // else{
        //     g.setColor(black);
        //     g.drawRect(0, 0, posicion.getAncho(), posicion.getAlto());
        //     g.setColor(black);
        //     g.fillRect(0, 0, posicion.getAncho(), posicion.getAlto());
        // }
    }
}
