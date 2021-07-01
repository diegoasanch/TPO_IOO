package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import negocio.Controlador;

import view.BarraView;
import view.BolaView;
import view.FilasView;

public class VentanaPrincipal extends JFrame {

    private static final long serialVersionUID = 45L;
    private static final int COD_P = 80;
    private static final int COD_IZQUIERDA = 37;
    private static final int COD_DERECHA = 39;
    private static final int COD_ESPACIO = 32;
    private static final int GAME_LOOP_DELAY = 30;

    private TableroDeJuego tablero;
    private Timer timer;

    public VentanaPrincipal() {
        this.setTitle("Arkanoid");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        configurar();

    }

    public void configurar() {
        Controlador.getInstance().iniciarJuego();
        BolaView posBolaInicial = Controlador.getInstance().getBola();
        BarraView posBarraInicial = Controlador.getInstance().getBarra();
        FilasView posFilasInicial = Controlador.getInstance().getFilas();
        tablero = new TableroDeJuego(posBarraInicial, posBolaInicial, posFilasInicial);

        MenuDeJuego menu = new MenuDeJuego();

        JSplitPane paneles = new JSplitPane(SwingConstants.VERTICAL, tablero, menu);
        paneles.setOrientation(SwingConstants.VERTICAL);
        paneles.setEnabled(false); // Para que no se pueda modificar el tamanio

        this.add(paneles);
        this.setSize(800, 650);
        this.setResizable(false);
        this.setVisible(true);

        this.setFocusable(true);
        this.requestFocus();
        this.addKeyListener( new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {/** */}

            @Override
            public void keyReleased(KeyEvent e) {/** */}

            @Override
            public void keyPressed(KeyEvent key) {
                int codigo = key.getKeyCode();
                System.out.println("Pressed: " + '"' + codigo + "'");

                switch (codigo) {
                    case COD_P:
                        playPause();
                        break;
                    case COD_IZQUIERDA:
                    case COD_DERECHA:
                        moverBarra(codigo);
                        break;
                    case COD_ESPACIO:
                        iniciarJuego();
                        break;
                    default:
                        System.out.println("Tecla sin accion");
                }
            }
        });

        timer = new Timer(GAME_LOOP_DELAY, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Movemos los elementos de juego
                Controlador.getInstance().jugar();

                if (Controlador.getInstance().perdioVida() && timer != null) {
                    // Detener el loop cuando se pierde una vida
                    timer.stop();
                    actualizarBarraGUI();
                }
                if (Controlador.getInstance().gameOver()) {
                    terminoElJuego();
                    // abrir al popup
                    //  - Al apretar el boton enviar el texto a controlador
                    // Frenar el timer

                }

                // Renderizamos los elementos con las nuevas posiciones
                tablero.setearPosicionBola(Controlador.getInstance().getBola());
                tablero.setearEstadoLadrillos(Controlador.getInstance().getFilas());

                menu.setearValores();

                tablero.repaint();
            }
        });
    }

    private void playPause() {
        if (timer.isRunning())
            pausar();
        else
            play();
    }

    private void pausar() {
        timer.stop();
    }

    private void play() {
        Controlador.getInstance().deshaceFlagVida();
        timer.start();
    }

    private void moverBarra(int codigo) {
        String direccion = (codigo == COD_DERECHA) ? "derecha" : "izquierda";
        Controlador.getInstance().moverBarra(direccion);
        actualizarBarraGUI();
    }

    private void actualizarBarraGUI() {
        tablero.setearPosicionBarra(Controlador.getInstance().getBarra());
    }

    private void iniciarJuego() {
        //TODO: Llamar el incio del juego
    }

    public void terminoElJuego () {
        JOptionPane.showInputDialog("Se quedo sin vidas, ingrese su nombre:");
    }
}
