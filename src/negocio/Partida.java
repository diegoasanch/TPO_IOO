package negocio;

import java.util.*;
import java.util.Date;

public class Partida {

    private int nivel;
    private int vida;
    private int puntos;
    private int duracion;
    private boolean estadoJugando;
    private long inicio;

    private Tablero tablero;
    private TopTwenty leaderboard;

    public Partida() {
        this.nivel = 1;
        this.vida = 3;
        this.puntos = 0;
        this.duracion = 0;
        this.estadoJugando = false;

        this.leaderboard = new TopTwenty(); // TODO: Implementar TopTwenty con modelo de estado global "Singleton"
    }

    public void iniciarJuego() {
        tablero = new Tablero();
        inicio = getCurrentTime();
    }

    public void jugar() {
    }

    public void sumarPuntos(int puntos) {
        this.puntos += puntos;
    }

    public boolean estaJugando() {
        return estadoJugando;
    }

    public void pausar() { // TODO: VER esto que esta medio redundante
        cambiarEstado();
    }

    public void play() {
        cambiarEstado();
    }

    private void cambiarEstado() {
        estadoJugando = !estadoJugando;
    }

    public int obtienePuntajeTotal() {
        return puntos;
    }

    public int obtieneDuracionPartida() {
        long ahora = getCurrentTime();
        long nanoSegundos = ahora - inicio;
        int segundos = (int) nanoSegundos / 1_000_000_000;
        return segundos;
    }

    private long getCurrentTime() {
        Date fecha = new Date();
        return fecha.getTime();
    }
}