package gui;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JSplitPane;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class VentanaPrincipal extends JFrame {

    private static final long serialVersionUID = 45L;
    private TableroDeJuego tablero;
    private MenuDeJuego menu;
    private JSplitPane paneles;
    private Timer timer;

    private int testVida, testPuntaje; // TODO: quitar estos valores de prueba

    public VentanaPrincipal() {
        configurar();
        this.setTitle("Arkanoid");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void configurar() {
        tablero = new TableroDeJuego();
        menu = new MenuDeJuego();

        paneles = new JSplitPane(SwingConstants.VERTICAL, tablero, menu);
        paneles.setOrientation(SwingConstants.VERTICAL);
        paneles.setEnabled(false); // Para que no se pueda modificar el tamanio

        this.add(paneles);
        this.setSize(800, 800);
        this.setResizable(false);
        this.setVisible(true);

        testVida = testPuntaje = 1;

        this.setFocusable(true);
        this.requestFocus();
        this.addKeyListener( new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {/** */}

            @Override
            public void keyReleased(KeyEvent e) {/** */}

            @Override
            public void keyPressed(KeyEvent key) {
                if (key.getKeyCode() == 80) { // p
                    if (timer.isRunning())
                        timer.stop();
                    else
                        timer.start();
                }
            }
        });

        timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                testVida++;
                testPuntaje += 100;
                menu.setearValores(testVida, testPuntaje);
            }
        });
    }

}
