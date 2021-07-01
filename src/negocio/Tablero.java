package negocio;

import java.util.*;

import view.BarraView;
import view.BolaView;
import view.FilasView;
import view.LadrilloView;

import constantes.DimensionTablero;
import constantes.DimensionesBarra;
import constantes.DimensionesBola;

public class Tablero {

    private int dimensionX;
    private int dimensionY;

    private Partida partida;
    private Barra barra;
    private Bola bola;
    private ArrayList<Fila> filas; // 5 filas
    private int aRomperFila;
    private int aRomperCol;

    public Tablero(int nivel, Partida partida) {
        this.dimensionX = DimensionTablero.TAMANIO_X;
        this.dimensionY = DimensionTablero.TAMANIO_Y;
        this.partida = partida;

        agregarFilas();
        crearBarra();
        crearBola(nivel);
    }

    public void agregarFilas() {
        this.filas = new ArrayList<>(5);
        int[] puntajes = new int[]{ 50, 40, 30, 20, 10 };

        for (int i = 0; i < 5; i++)
            filas.add(new Fila(puntajes[i], i));
    }

    public void crearBola(int velocidad) {
        this.bola = new Bola(
            DimensionesBola.POS_INI_X,
            DimensionesBola.POS_INI_Y,
            DimensionesBola.DIAMETRO,
            DimensionesBola.DIAMETRO,
            velocidad,
            this.dimensionX,
            (this.dimensionY - DimensionTablero.BORDE)
        );
    }

    public void crearBarra() {
        int medioTablero = (this.dimensionX / 2) - (DimensionesBarra.TAMANIO_X / 2);
        this.barra = new Barra(
            medioTablero,
            this.dimensionY - DimensionTablero.BORDE,
            DimensionesBarra.TAMANIO_X,
            DimensionesBarra.TAMANIO_Y,
            this.dimensionX
        );
    }

    public void moverElementos() {
        if (bola.detectarChoquePared())
            bola.rebotarPared();

        else if (bola.detectarLimiteInferiorTablero() && bola.estaBajando()) {
            System.out.println("La barra esta en x: " + barra.getPosicionX() + " y: " + barra.getPosicionY());
            if (barra.detectarColision( // Rebota la bola con la barra
                bola.getPosicionX(),
                bola.getPosicionY(),
                bola.getTamanioX(),
                bola.getTamanioY()
            )) {
                boolean esMitadDerecha = barra.mitadDerecha(bola.getPosicionX());
                bola.rebotarBarra(esMitadDerecha);
            }
            else { // La bola se sale del tablero
                partida.pierdeVida();
                resetearBola();
            }
        }
        else if (detectarLadrilloRoto()) { // La bola esta en algun punto central del tablero
            System.out.println("Se rompio un ladrillo");
            int lado = romperLadrillo();
            bola.rebotarLadrillo(lado);
        }
        bola.mover();
    }

    public boolean detectarLadrilloRoto() {
        List<Fila> filasPosibles = buscarFila(bola.getPosicionY(), bola.getTamanioX()); // Si colisiona con alguno
        for (Fila filaActual : filasPosibles) {
            int col = filaActual.detectarLadrilloRoto(bola.getPosicionX(), bola.getPosicionY(), bola.getTamanioX());
            if (col != -1) {
                aRomperFila = filaActual.getIndice();
                aRomperCol = col;
                return true;
            }
        }
        aRomperFila = -1;
        aRomperCol = -1;
        return false;
    }

    /**
     * Retorna array porque puede detectar por romper la fila anterior (ya rota si aun no salio
     * de la misma)
     */
    public List<Fila> buscarFila(int posY, int tamanio) {
        List<Fila> resultado = new ArrayList<>();
        for (Fila fila : this.filas) {
            if (fila.soyLaFila(posY, tamanio)) {
                resultado.add(fila);
            }
        }
        return resultado;
    }

    /**
     * Cambia el estado del ladrillo a roto y suma los puntos correspondientes
     * a la partida.
     * Retorna el lado por el cual choco la bola (0, 1, 2, 3)
     */
    private int romperLadrillo() {
        Fila aRomper = filas.get(aRomperFila);
        int lado = aRomper.romperLadrillo(aRomperCol, bola.getPosicionX(), bola.getPosicionY(),  bola.getTamanioX());
        partida.sumarPuntos(aRomper.getPuntaje());

        return lado;
    }

    public boolean seRompieronTodosLosLadrillos() {
        int filasRotas = 0;
        for (Fila fila : filas) {
            if (!fila.quedanLadrillos())
                filasRotas++;
        }
        return filasRotas == filas.size();
    }

    public FilasView getFilas() {
        List<List<LadrilloView>> resultado = new ArrayList<>();
        for (Fila fila : filas)
            resultado.add(fila.toView());
        return new FilasView(resultado);
    }

    public BolaView getBola() {
        return bola.toView();
    }

    public BarraView getBarra() {
        return barra.toView();
    }

    public void moverBarra(String direccion) {
        barra.moverBarra(direccion);
    }

    private void resetearBola() {
        crearBarra();
        crearBola(partida.getNivel());
    }
}
