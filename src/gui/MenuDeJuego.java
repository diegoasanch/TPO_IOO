package gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import negocio.Controlador;

public class MenuDeJuego extends JPanel {
    private JLabel lblMenu, lblPuntaje, lblVidas, lblNivel, lblTitulo, valPuntos, valVidas, valNivel;
    private JButton btnPlayPause;
    private JPanel datos, ranking;

    public MenuDeJuego() {
        super();
        configurar();
    }

    private void configurar() {
        configurarDatos();
        configurarRankings();

        JSplitPane menus = new JSplitPane(SwingConstants.HORIZONTAL, datos, ranking);
        this.add(menus);
    }

    private void configurarDatos() {
        datos = new JPanel();

        String fontType = "Arial";
        datos.setLayout(new BoxLayout(datos, BoxLayout.Y_AXIS));
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

        datos.add(lblMenu);
        datos.add(lblNivel);
        datos.add(valNivel);
        datos.add(lblVidas);
        datos.add(valVidas);
        datos.add(lblPuntaje);
        datos.add(valPuntos);
        // datos.add(btnPlayPause);
        datos.setBackground(Color.white);
    }

    public void configurarRankings(){
        ranking = new JPanel();

        String fontType = "Arial";
        ranking.setLayout(new BoxLayout(ranking, BoxLayout.Y_AXIS));
        Font h1 = new Font(fontType, Font.BOLD, 40);
        Font h2 = new Font(fontType, Font.BOLD, 20);
        Font value = new Font(fontType, Font.BOLD, 30);

        lblTitulo = new JLabel("Mejores puntajes");
        lblTitulo.setFont(h1);

    }

    public void setearValores(int vidas, int puntaje) {
        this.valVidas.setText(String.valueOf(Controlador.getInstance().getVidas()));
        this.valPuntos.setText(String.valueOf(Controlador.getInstance().getPuntaje()));
    }

    public void terminoElJuego (boolean gameOver) {
        if (gameOver)
            JOptionPane.showInputDialog("Se quedo sin vidas, ingrese su nombre:");

    }
}