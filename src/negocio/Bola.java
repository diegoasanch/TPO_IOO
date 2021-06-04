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
        this.cambiarPosicion(calcMovimientoX(), calcMovimientoY());
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

    public void rebotar(String objetoDeRebote, String posicionImpacto) {

    }

    public boolean detectarLimiteInferiorTablero() {
        return this.posicionY >= this.maxY;
    }

    private void rebotarLadrillo() {

    }

    private void rebotarBarra(boolean mitadDerecha) {
        if (mitadDerecha) {

        }
        else { // Mitad Izquierda

        }
    }

    public boolean detectarColision(int posX, int posY, int tamanio_x, int tamanio_y) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean detectarColision(int posX, int posY, int tamanio) {
        return detectarColision(posX, posY, tamanio, tamanio);
    }

    public boolean detectarChoquePared() {
        return (
            this.posicionX >= this.minX
            || this.posicionX >= this.maxX
            || this.posicionY >= this.minY
        );
    }
}
