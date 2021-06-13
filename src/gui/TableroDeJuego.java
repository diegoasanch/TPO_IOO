package gui;

import java.util.Timer;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;

public class TableroDeJuego extends JInternalFrame{
    private JLabel lblLadrillo, lblBarra, lblBola, lblBordeLat, lblBordeSup;
    private Timer timer;


    public TableroDeJuego(){
        configurar();
        this.setSize(600, 400);
        
    }
}