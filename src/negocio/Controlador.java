package negocio;

import java.util.*;

public class Controlador {

    private TopTwenty leaderboard;
    // private ArrayList<Partida> partidas;
    private Partida partida;
    private ArrayList<Barra> barras;
    private static Controlador instancia;

    private Controlador() {
        // this.partidas = new ArrayList<Partida>();
        // this.partidas.add(new Partida());
        this.partida = new Partida();
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

    public void play() {|
        partida.play();
    }

    public void pausar() {
        partida.pausar();
    }

    public void moverBarra(String direccion) {
    }

    public void ingresarNombre(String nombre) {
    }

    public void renaudarJuego(){
        partida.play();
        partida.jugar();
    }
}
