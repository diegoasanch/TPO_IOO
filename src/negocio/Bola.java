package negocio;

import constantes.DimensionesBola;

import java.util.Random;

import view.BolaView;

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
    private Random random;

    public Bola(int posicionX, int posicionY, int tamanioX, int tamanioY, int velocidadInicial, int maxX, int maxY) {
        super(posicionX, posicionY, tamanioX, tamanioY, maxX, maxY);
        this.velocidad = velocidadInicial * DimensionesBola.MULTIPLO_VELOCIDAD;
        this.sentido = DimensionesBola.SENTIDO_INICIAL;
        random = new Random();
    }

    public void cambiarVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public void mover() {
        this.posicionX += calcMovimientoX();
        this.posicionY += calcMovimientoY();
    }

    private int calcMovimientoX() {
        double cosAngulo = Math.cos(Math.toRadians(sentido));
        return (int) Math.round((double)velocidad * cosAngulo);
    }

    private int calcMovimientoY() {
        double sinAngulo = Math.sin(Math.toRadians(sentido));
        int movY = (int) Math.round((double)velocidad * sinAngulo);
        return -movY; // Negativo porque Y=0 es el tope del tablero
    }

    // En base al angulo con el que rebota, Lateral = 90, Superior = 360
    public void rebotarPared() {
        int anguloPared = anguloRebote();
        int nuevoAngulo = anguloPared - (this.sentido - anguloPared);
        this.sentido = normalizarAngulo(nuevoAngulo);
    }

    private int anguloRebote() {
        int angulo = 0;
        if (this.posicionX <= this.minX || this.posicionX >= maxX) // Rebota con laterales
            angulo = 90;
        else if (this.posicionY <= this.minY)
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

    /**
     * Lados disponibles [0, 1, 2, 3] = [arriba, izquierda, debajo, derecha]
     * @param lado
     */
    public void rebotarLadrillo(int lado) {
        int anguloBase = lado * 90;
        int anguloRandom = numeroRandom(80, 100);
        this.sentido = anguloBase + anguloRandom;
        System.out.println("nuevoAngulo: " + this.sentido);
    }

    public void rebotarBarra(boolean mitadDerecha) {
        int anguloEntrada = anguloDeEntradaBarra();
        int nuevoAngulo;
        System.out.println("Angulo de entrada: " + anguloEntrada + " Lado de rebote: " + (mitadDerecha ? "Derecha" : "Izquierda"));
        if (mitadDerecha) {
            nuevoAngulo = 60 + anguloEntrada;
        }
        else { // Mitad Izquierda
            nuevoAngulo = 100 + anguloEntrada;
        }
        this.sentido = normalizarAngulo(nuevoAngulo);
        System.out.println("Nuevo angulo " + this.sentido);
    }

    public boolean estaBajando() {
        return 180 < sentido && sentido < 360;
    }

    public boolean detectarChoquePared() {
        boolean chocaIzq = this.posicionX <= this.minX;
        boolean chocaDer = this.posicionX >= this.maxX;
        boolean chocaArriba = this.posicionY <= this.minY;

        return chocaIzq || chocaDer || chocaArriba;
    }

    private int numeroRandom(int desde, int hasta) {
        return desde + random.nextInt(hasta - desde + 1);
    }

    /**
     * Angulo de entrada a la barra en relacion al eje -Y (270°)
     * @return Entero entre -90 y 90 si la bola se desplaza hacia abajo, sino
     * el rango es -180 y 180
     */
    private int anguloDeEntradaBarra() {
        return sentido - 270;
    }

    public BolaView toView() {
        return new BolaView(posicionX, posicionY, tamanioX);
    }
}
