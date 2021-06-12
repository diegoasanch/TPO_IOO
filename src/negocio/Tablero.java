package negocio;

import java.util.*;

public class Tablero {

    private int dimension_x;
    private int dimension_y;

    private Partida partida;
    private Barra barra;
    private Bola bola;
    private ArrayList<Fila> filas; /|/ 5 filas

    public Tablero(int nivel) {
        this.dimension_x = 400;
        this.dimension_y = 400;

        agregarFilas();
        crearBarra();
        crearBola(nivel);
    }

    public void agregarFilas() {
        this.filas = new ArrayList<Fila>(5);
        int puntajes[] = new int[]{ 50, 40, 30, 20, 10 };

        for (int i = 0; i < 5; i++)
            filas.add(new Fila(puntajes[i], i));
    }

    public void crearBola(int velocidad) {
        int medioTablero = this.dimension_x / 2;

        this.bola = new Bola(
            medioTablero,
            this.dimension_y,
            15,
            15,
            velocidad,
            this.dimension_x,
            this.dimension_y
        );
    }

    public void crearBarra() {
        int medioTablero = this.dimension_x / 2;
        this.barra = new Barra(
            medioTablero,
            this.dimension_y,
            100,
            20,
            this.dimension_x
        );
    }

    public void moverElementos() {
        if (bola.detectarChoquePared())
            bola.rebotarPared();

        else if (bola.detectarLimiteInferiorTablero()) {
            if (barra.detectarColision( // Rebota la bola con la barra
                bola.getPosicionX(),
                bola.getPosicionY(),
                bola.getTamanioX(),
                bola.getTamanioY()
                )
            ) {
                boolean esMitadDerecha = barra.mitadDerecha(bola.getPosicionX());
                bola.rebotarBarra(esMitadDerecha);
            }
            else { // La bola se sale del tablero
                partida.pierdeVida();
            }
        }
        else if (detectarLadrilloRoto()) { // La bola esta en algun punto central del tablero
            bola.rebotarLadrillo();
            romperLadrillo();
        }
        bola.mover();
    }


    public void calcularPos() {

    }

    public boolean detectarLadrilloRoto() {
        Fila filaActual = buscarFila(bola.getPosicionY()); // Si colisiona con alguno
        if (filaActual != null) {
            return filaActual.detectarLadrilloRoto(bola.getPosicionX(), bola.getPosicionY(), bola.getTamanioX());
        }
        return false;
    }

    public Fila buscarFila(int posY) {
        Fila resultado = null;
        for (Fila fila : this.filas) {
            if (fila.soyLaFila(posY)) {
                resultado = fila;
                break;
            }
        }
        return resultado;
    }

    /**
     * Cambia el estado del ladrillo a roto y suma los puntos correspondientes
     * a la partida
     */
    private void romperLadrillo() {
        Fila aRomper = buscarFila(bola.getPosicionY());
        if (aRomper != null) {
            aRomper.romperLadrillo(bola.getPosicionX());
            partida.sumarPuntos(aRomper.getPuntaje());
        }
    }

    public boolean seRompieronTodosLosLadrillos() {
        int filasRotas = 0;
        for (Fila fila : filas) {
            if (!fila.quedanLadrillos())
                filasRotas++;
        }
        return filasRotas == filas.size();
    }
}
