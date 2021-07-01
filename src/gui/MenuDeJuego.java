package gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import negocio.Controlador;

public class MenuDeJuego extends JPanel {
    private JLabel lblMenu, lblPuntaje, lblVidas, lblNivel, valPuntos, valVidas, valNivel;
    private JButton btnPlayPause;

    public MenuDeJuego() {
        super();
        configurar();
    }

    private void configurar() {
        String fontType = "Arial";
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        Font h1 = new Font(fontType, Font.BOLD, 40);
        Font h2 = new Font(fontType, Font.BOLD, 20);
        Font value = new Font(fontType, Font.BOLD, 30);

        lblMenu = new JLabel("Arkanoid");
        lblMenu.setFont(h1);

        lblPuntaje = new JLabel("Puntaje");
        lblPuntaje.setFont(h2);
        lblVidas = new JLabel("Vidas");
        lblVidas.setFont(h2);
        lblNivel = new JLabel ("Nivel");
        lblNivel.setFont(h2);

        valPuntos = new JLabel("xxxx");
        valPuntos.setFont(value);
        valVidas = new JLabel("xxxx");
        valVidas.setFont(value);
        valNivel = new JLabel ("xxxx");
        valNivel.setFont(value);

        //btnPlayPause = new JButton("Play/Pausa");

        float center = 0.5f;
        lblMenu.setAlignmentX(center);
        lblPuntaje.setAlignmentX(center);
        lblVidas.setAlignmentX(center);
        valPuntos.setAlignmentX(center);
        valVidas.setAlignmentX(center);
        // btnPlayPause.setAlignmentX(center);
        lblNivel.setAlignmentX(center);
        valNivel.setAlignmentX(center);

        this.add(lblMenu);
        this.add(lblVidas);
        this.add(valVidas);
        this.add(lblPuntaje);
        this.add(valPuntos);
        this.add(lblVidas);
        this.add(valVidas);
        // this.add(btnPlayPause);
        this.setBackground(Color.white);
    }

    public void setearValores(int vidas, int puntaje) {
        this.valVidas.setText(String.valueOf(Controlador.getInstance().getVidas()));
        this.valPuntos.setText(String.valueOf(Controlador.getInstance().getPuntaje()));
    }
}
