package negocio;

import java.util.Date;

import view.BarraView;
import view.BolaView;
import view.FilasView;

public class Partida {

    private int nivel;
    private int vida;
    private int puntos;
    private boolean estadoJugando;
    private long inicio;

    private Tablero tablero;

    public Partida() {
        this.nivel = 1;
        this.vida = 3;
        this.puntos = 0;
        this.estadoJugando = false;
    }

    public void iniciarJuego() {
        tablero = new Tablero(nivel, this);
        inicio = getCurrentTime();
    }

    public void jugar() {
        tablero.moverElementos();

        if (tablero.seRompieronTodosLosLadrillos())
            subirNivel();
    }

    public void subirNivel() {
        nivel++;
        modificarVidas(1);
        iniciarJuego();
    }

    public void sumarPuntos(int puntos) {
        if (debeSumarVida(this.puntos, puntos))
            vida++;
        this.puntos += puntos;
    }

    private boolean debeSumarVida(int puntajeActual, int puntosASumar) {
        int valorAntes = puntajeActual / 1000;
        int valorDespues = (puntajeActual + puntosASumar) / 1000;
        return valorAntes != valorDespues;
    }

    public boolean estaJugando() {
        return estadoJugando;
    }

    public void pausar() {
        estadoJugando = false;
    }

    public void play() {
        estadoJugando = true;
    }

    public int obtienePuntajeTotal() {
        return puntos;
    }

    public int calcularDuracionPartida() {
        long ahora = getCurrentTime();
        long nanoSegundos = ahora - inicio;
        return (int) nanoSegundos / 1_000_000_000;
    }

    private long getCurrentTime() {
        Date fecha = new Date();
        return fecha.getTime();
    }

    private void modificarVidas(int nuevasVidas) {
        this.vida += nuevasVidas;
    }

    public void pierdeVida() {
        System.out.println("Pierde vida");
        modificarVidas(-1);
    }

    public int getVida() {
        return vida;
    }

    public BolaView getBola() {
        return tablero.getBola();
    }

    public FilasView getFilas() {
        return tablero.getFilas();
    }

    public BarraView getBarra() {
        return tablero.getBarra();
    }

    public void moverBarra(String direccion) {
        tablero.moverBarra(direccion);
    }
}
