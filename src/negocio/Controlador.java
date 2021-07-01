package negocio;

import view.BarraView;
import view.BolaView;
import view.FilasView;

public class Controlador {

    private Partida partida;
    private static Controlador instancia;

    private Controlador() {
        this.partida = new Partida();
        partida.iniciarJuego();
    }

    public static Controlador getInstance() {
        if (instancia == null)
            instancia = new Controlador();
        return instancia;
    }

    public void iniciarJuego() {
        partida.iniciarJuego();
    }

    public void jugar() {
        if (!partida.estaJugando())
            partida.jugar();
    }

    public void play() {
        partida.play();
    }

    public void pausar() {
        partida.pausar();
    }

    /**
     * A pasarle a la instancia de barra de la partida actual
     * @param direccion Tiene que ser "izquierda" o "derecha"
     */
    public void moverBarra(String direccion) {
        partida.moverBarra(direccion);
    }

    public void ingresarNombre(String nombre) {
        //if vidas = 0 caja de texto para poner nombre
        TopTwenty.getInstance().setPartidaActual(partida);
        TopTwenty.getInstance().ingresarNombre(nombre);
    }

    public void renaudarJuego(){
        partida.play();
        partida.jugar();
    }

    public BarraView getBarra() {
        return partida.getBarra();
    }

    public BolaView getBola() {
        return partida.getBola();
    }

    public FilasView getFilas() {
        return partida.getFilas();
    }

    public int getVidas(){
        return partida.getVida();
    }

    public int getPuntaje(){
        return partida.obtienePuntajeTotal();
    }

    public boolean estaJugando() {
        return partida.estaJugando();
    }

    public boolean perdioVida() {
        return partida.perdioVida();
    }

    public void deshaceFlagVida() {
        partida.deshaceFlagVida();
    }

    public boolean gameOver() {
        return partida.gameOver();
    }
}
