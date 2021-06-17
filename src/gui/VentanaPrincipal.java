package gui;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JSplitPane;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import negocio.Barra;

public class VentanaPrincipal extends JFrame {

    private static final long serialVersionUID = 45L;
    private static final int COD_P = 80;
    private static final int COD_IZQUIERDA = 37;
    private static final int COD_DERECHA = 39;
    private static final int COD_ESPACIO = 32;
    private static final int FPS = 30;

    private TableroDeJuego tablero;
    private MenuDeJuego menu;
    private JSplitPane paneles;
    private Timer timer;

    private Barra testBarra; // TODO: QUITAR BARRA DE PRUEBA

    public VentanaPrincipal() {
        configurar();
        this.setTitle("Arkanoid");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void configurar() {
        testBarra = new Barra(240, 700, 85, 20, 540);
        tablero = new TableroDeJuego(testBarra.toView());
        menu = new MenuDeJuego();

        paneles = new JSplitPane(SwingConstants.VERTICAL, tablero, menu);
        paneles.setOrientation(SwingConstants.VERTICAL);
        paneles.setEnabled(false); // Para que no se pueda modificar el tamanio

        this.add(paneles);
        this.setSize(800, 800);
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

        timer = new Timer(1/FPS, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: Llamar la el metodo de jugar para mover el tablero
                // TODO: Buscar una instancia de BolaView y LadrillosView para renderizarlos
            }
        });
    }

    private void playPause() {
        if (timer.isRunning())
            timer.stop();
        else
            timer.start();
    }

    private void moverBarra(int codigo) {
        String direccion = (codigo == COD_DERECHA) ? "derecha" : "izquierda";
        testBarra.moverBarra(direccion);
        tablero.setearPosicionBarra(testBarra.toView());
    }

    private void iniciarJuego() {
        // Llamar el incio del juego
    }
}
