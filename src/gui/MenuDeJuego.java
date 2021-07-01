package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import constantes.DimensionTablero;
import negocio.Controlador;
import view.RegistroView;

public class MenuDeJuego extends JPanel {
    private JLabel valPuntos, valVidas, valNivel;
    private JPanel datos, ranking;
    private JScrollPane rankingContainer;
    private Font h1, h2, h3, value;
    private static final float CENTER = 0.5f;

    public MenuDeJuego() {
        super();
        configurar();
    }

    private void configurar() {

        configurarFuentes();
        configurarDatos();
        configurarRanking();

        this.setSize(new Dimension(
            DimensionTablero.WINDOW_X - DimensionTablero.TAMANIO_X,
            500
        ));
        rankingContainer = new JScrollPane(ranking);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(datos);
        this.add(rankingContainer);

        this.setVisible(true);
        setearValores();
    }

    private void configurarFuentes() {
        String fontType = "Arial";
        h1 = new Font(fontType, Font.BOLD, 40);
        h2 = new Font(fontType, Font.BOLD, 23);
        h3 = new Font(fontType, Font.BOLD, 20);
        value = new Font(fontType, Font.BOLD, 30);
    }

    private void configurarDatos() {
        datos = new JPanel();
        datos.setLayout(new BoxLayout(datos, BoxLayout.Y_AXIS));

        JLabel lblMenu = new JLabel("Arkanoid");
        lblMenu.setFont(h1);

        JLabel lblPuntaje = new JLabel("Puntaje");
        lblPuntaje.setFont(h3);
        JLabel lblVidas = new JLabel("Vidas");
        lblVidas.setFont(h3);
        JLabel lblNivel = new JLabel ("Nivel");
        lblNivel.setFont(h3);

        valPuntos = new JLabel(" ");
        valPuntos.setFont(value);
        valVidas = new JLabel(" ");
        valVidas.setFont(value);
        valNivel = new JLabel (" ");
        valNivel.setFont(value);

        lblMenu.setAlignmentX(CENTER);
        lblPuntaje.setAlignmentX(CENTER);
        lblVidas.setAlignmentX(CENTER);
        valPuntos.setAlignmentX(CENTER);
        valVidas.setAlignmentX(CENTER);
        lblNivel.setAlignmentX(CENTER);
        valNivel.setAlignmentX(CENTER);

        datos.add(lblMenu);
        datos.add(lblNivel);
        datos.add(valNivel);
        datos.add(lblVidas);
        datos.add(valVidas);
        datos.add(lblPuntaje);
        datos.add(valPuntos);
    }

    private void configurarRanking() {
        ranking = new JPanel();
        ranking.setLayout(new BoxLayout(ranking, BoxLayout.Y_AXIS));


        JLabel lblMejores = new JLabel("Mejores puntajes");
        lblMejores.setBorder(new EmptyBorder(15, 0, 0, 0));
        lblMejores.setFont(h2);
        lblMejores.setAlignmentX(CENTER);

        JLabel lblLeyenda = new JLabel("Nombre - Puntaje");
        lblLeyenda.setFont(h3);
        lblLeyenda.setAlignmentX(CENTER);
        lblLeyenda.setForeground(new Color(80, 80, 80));
        lblLeyenda.setBorder(new EmptyBorder(0, 0, 15, 0));

        ranking.add(lblMejores);
        ranking.add(lblLeyenda);
    }

    public void mostrarMejores(List<RegistroView> registros) {
        this.remove(rankingContainer);
        configurarRanking();
        JLabel actual;
        int i = 1;
        for (RegistroView reg : registros) {
            actual = new JLabel(i++ + ". " + reg.getNombre() + "  -  " + reg.getPuntaje());
            actual.setFont(h3);
            actual.setAlignmentX(CENTER);
            ranking.add(actual);
        }
        rankingContainer = new JScrollPane(ranking);
        this.add(rankingContainer);
    }

    public void setearValores() {
        this.valVidas.setText(String.valueOf(Controlador.getInstance().getVidas()));
        this.valPuntos.setText(String.valueOf(Controlador.getInstance().getPuntaje()));
        this.valNivel.setText(String.valueOf(Controlador.getInstance().getNivel()));
    }
}
