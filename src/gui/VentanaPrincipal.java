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
import negocio.Bola;
import negocio.Controlador;

import view.BolaView;
import view.BarraView;
import view.FilasView;

public class VentanaPrincipal extends JFrame {

    private static final long serialVersionUID = 45L;
    private static final int COD_P = 80;
    private static final int COD_IZQUIERDA = 37;
    private static final int COD_DERECHA = 39;
    private static final int COD_ESPACIO = 32;
    private static final int GAME_LOOP_DELAY = 50;

    private TableroDeJuego tablero;
    private MenuDeJuego menu;
    private JSplitPane paneles;
    private Timer timer;

    // private Barra testBarra; // TODO: QUITAR BARRA DE PRUEBA
    // private Bola testBola; // TODO: QUITAR BOLA DE PRUEBA

    // private Controlador controlador;

    public VentanaPrincipal() {
        this.setTitle("Arkanoid");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        // Controlador.getInstance();
        configurar();

    }

    public void configurar() {
        // TODO: Inicializar el juego (inciarJuego() o jugar() o play())
        Controlador.getInstance().iniciarJuego();
        BolaView posBolaInicial = Controlador.getInstance().getBola();
        BarraView posBarraInicial = Controlador.getInstance().getBarra();
        FilasView posFilasInicial = Controlador.getInstance().getFilas();
        tablero = new TableroDeJuego(posBarraInicial, posBolaInicial, posFilasInicial); // TODO: Pedir filas a controlador

        // testBarra = new Barra(240, 700, 85, 20, 540);  // TODO: Reemplazar por controlador
        // testBola = new Bola(200, 300,30, 30, 2, 540, 590);

        menu = new MenuDeJuego();

        paneles = new JSplitPane(SwingConstants.VERTICAL, tablero, menu);
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
                // testBola.mover(); // TODO: Mover en el controlador
                // tablero.setearPosicionBola(testBola.toView());  // TODO: Pedirle el view al controlador

                // Movemos los elementos de juego
                Controlador.getInstance().jugar(); Controlador.getInstance();

                // Renderizamos los elementos con las nuevas posiciones
                tablero.setearPosicionBola(Controlador.getInstance().getBola());



                // TODO: Llamar la el metodo de jugar para mover el tablero
                // TODO: Buscar una instancia de BolaView y LadrillosView para renderizarlos
                tablero.repaint();
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
        Controlador.getInstance().moverBarra(direccion);
        tablero.setearPosicionBarra(Controlador.getInstance().getBarra()); // TODO: Pedirle el view al controlador
        System.out.println("Pos Barra : " + Controlador.getInstance().getBarra().getX());

        // testBarra.moverBarra(direccion); // TODO: Mover en el controlador
        // tablero.setearPosicionBarra(testBarra.toView()); // TODO: Pedirle el view al controlador
    }

    private void iniciarJuego() {
        //TODO: Llamar el incio del juego
    }
}
