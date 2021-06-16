package gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

// import jdk.internal.platform.Container;

public class MenuDeJuego extends JPanel {
    private JLabel lblMenu, lblPuntaje, lblVidas, valPuntos, valVidas;
    private JButton btnPlayPause;

    public MenuDeJuego() {
        super();
        configurar();
    }

    private void configurar() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        Font h1 = new Font("Arial", Font.BOLD, 40);
        Font h2 = new Font("Arial", Font.BOLD, 20);
        Font value = new Font("Arial", Font.BOLD, 30);

        lblMenu = new JLabel("Arkanoid");
        lblMenu.setFont(h1);

        lblPuntaje = new JLabel("Puntaje");
        lblPuntaje.setFont(h2);
        lblVidas = new JLabel("Vidas");
        lblVidas.setFont(h2);

        valPuntos = new JLabel("xxxx");
        valPuntos.setFont(value);
        valVidas = new JLabel("xxxx");
        valVidas.setFont(value);

        btnPlayPause = new JButton("Play/Pausa");

        this.add(lblMenu);
        this.add(lblPuntaje);
        this.add(valPuntos);
        this.add(lblVidas);
        this.add(valVidas);
        this.add(btnPlayPause);
        this.setBackground(Color.white);
    }

    public void setearValores(int vidas, int puntaje) {
        this.valVidas.setText(String.valueOf(vidas));
        this.valPuntos.setText(String.valueOf(puntaje));
    }
}
