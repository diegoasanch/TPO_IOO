package negocio;
import java.util.*;
import java.lang.Math;

public class Bola extends ObjetoPosicionado {

    private int velocidad; // Pixeles por ciclo de juego
    /**
     * Grados 0 <= sentido < 360
     * Derecha = 0
     * Arriba = 90
     * Izquierda = 180
     * Abajo = 270
     */
    private int sentido;

    public Bola(int posicionX, int posicionY, int tamanioX, int tamanioY, int velocidadInicial, int maxX, int maxY) {
        super(posicionX, posicionY, tamanioX, tamanioY, maxX, maxY);
        this.velocidad = velocidadInicial;
        this.sentido = 90;
    }

    public void cambiarVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public void mover() {
        this.posicionX += calcMovimientoX();
        this.posicionY += calcMovimientoY();
    }

    private int calcMovimientoX() {
        return (int) (velocidad * Math.cos(sentido));
    }

    private int calcMovimientoY() {
        return (int) (velocidad * Math.sin(sentido));
    }

    // En base al angulo con el que rebota, Lateral = 90, Superior = 360
    public void rebotarPared() {
        int anguloPared = anguloRebote();
        int nuevoAngulo = anguloPared - (this.sentido - anguloPared);
        this.sentido = normalizarAngulo(nuevoAngulo);
    }

    private int anguloRebote() {
        int angulo = 0;
        if (this.posicionX == this.minX || this.posicionX == maxX) // Rebota con laterales
            angulo = 90;
        else if (this.posicionY == this.minY)
            angulo = 360;
        return angulo;
    }

    private int normalizarAngulo(int angulo) {
        int resultado;
        if (angulo >= 360)
            resultado = angulo - 360;
        else if (angulo < 0)
            resultado = 360 + angulo;
        else
            resultado = angulo;
        return resultado;
    }

    public boolean detectarLimiteInferiorTablero() {
        return this.posicionY >= this.maxY;
    }

    public void rebotarLadrillo() {
        int nuevoAngulo = numeroRandom(180+85, 180+95);
        this.sentido = nuevoAngulo;
    }

    public void rebotarBarra(boolean mitadDerecha) {
        int anguloEntrada = anguloDeEntradaBarra();
        int nuevoAngulo;
        if (mitadDerecha) {
            nuevoAngulo = 60 + anguloEntrada;
        }
        else { // Mitad Izquierda
            nuevoAngulo = 90 + anguloEntrada;
        }
        this.sentido = nuevoAngulo;
    }

    public boolean detectarChoquePared() {
        return (
            this.posicionX >= this.minX
            || this.posicionX >= this.maxX
            || this.posicionY >= this.minY
        );
    }

    private int numeroRandom(int desde, int hasta) {
        return (int) Math.round(Math.random() * (hasta-desde+1) + desde);
    }

    /**
     * Angulo de entrada a la barra en relacion al eje -Y (270°)
     * @return Entero entre -90 y 90 si la bola se desplaza hacia abajo, sino
     * el rango es -180 y 180
     */
    private int anguloDeEntradaBarra() {
        return sentido - 270;
    }
}
