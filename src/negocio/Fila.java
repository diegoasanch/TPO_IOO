package negocio;

import java.util.*;

import constantes.DimensionesLadrillo;
import view.LadrilloView;

public class Fila {

    private int puntaje;
    private int indice; // De arriba a abajo
    private int dimension_y;
    private ArrayList<Ladrillo> ladrillos;


    public Fila(int puntaje, int indice) {
        this.puntaje = puntaje;
        this.indice = indice;
        this.dimension_y = DimensionesLadrillo.TAMANIO_Y;

        agregarLadrillos();
    }

    public void agregarLadrillos() {
        this.ladrillos = new ArrayList<Ladrillo>(5);

        final int MOV_X_Y = 0;

        for (int indiceCol = 0; indiceCol < 5; indiceCol++) {
            ladrillos.add(new Ladrillo(
                (DimensionesLadrillo.TAMANIO_X * indiceCol) + DimensionesLadrillo.MARGEN,
                (DimensionesLadrillo.TAMANIO_Y * indice) + DimensionesLadrillo.MARGEN,
                DimensionesLadrillo.TAMANIO_X,
                DimensionesLadrillo.TAMANIO_Y,
                MOV_X_Y,
                MOV_X_Y,
                indiceCol
            ));
        }
    }

    /**
     * Retorna el lado por el cual choco la bola
     */
    public int romperLadrillo(int indice, int posicionX, int posicionY, int tamanio) {
        Ladrillo aRomper = ladrillos.get(indice);
        if (indice != -1) {
            System.out.println("Rompiendo ladrillo: " + indice + ' ' + aRomper.getIndice());
            aRomper.destruccionLadrillo();
            int ladoChoque = determinaLadoChoque(posicionX, posicionY, tamanio, aRomper);
            System.out.println("Lado de choque: " + ladoChoque);
            return ladoChoque;
        }
        return -1;
    }

    public boolean soyLaFila(int posY, int tamanio) {
        int minY = (indice * dimension_y) + DimensionesLadrillo.MARGEN;
        int maxY = ((indice + 1) * dimension_y) + DimensionesLadrillo.MARGEN;
        int bolaSuperior = posY;
        int bolaInferior = posY + tamanio;
        return (
            bolaSuperior >= minY && bolaSuperior <= maxY ||
            bolaInferior >= minY && bolaInferior <= minY
        );
    }

    private Ladrillo buscarLadrillo(int posX, int tamanio) {
        Ladrillo resultado = null;
        for (Ladrillo lad : ladrillos) {
            if (lad.soyElLadrillo(posX, tamanio)) {
                resultado = lad;
                break;
            }
        }
        return resultado;
    }

    public int detectarLadrilloRoto(int posX, int posY, int tamanio) {
        Ladrillo ladrilloActual = buscarLadrillo(posX, tamanio);
        if (ladrilloActual != null && !ladrilloActual.estaRoto() && ladrilloActual.detectarColision(posX, posY, tamanio)) {
            return ladrilloActual.getIndice();
        }
        return -1;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public boolean quedanLadrillos() {
        int rotos = 0;
        for (Ladrillo lad : ladrillos) {
            if (lad.estaRoto())
                rotos++;
        }
        return rotos != ladrillos.size();
    }

    public List<LadrilloView> toView() {
        List<LadrilloView> fila = new ArrayList<>();
        for (Ladrillo ladrillo : ladrillos)
            fila.add(ladrillo.toView());
        return fila;
    }

    private int determinaLadoChoque(int posX, int posY, int diametro, Ladrillo aRomper) {
        int ladCentroY = (dimension_y * 2 * ((indice) + 1)) / 2 + DimensionesLadrillo.MARGEN;
        int ladLadoIzq = aRomper.getPosicionX();
        int ladLadoDer = aRomper.getPosicionX() + aRomper.getTamanioX();

        int bolaCentroX = posX + (diametro/2);
        int bolaCentroY = posY + (diametro/2);
        int lado = 0; // default

        if (bolaCentroY <= ladCentroY) { // Lado arriba
            if (bolaCentroX >= ladLadoIzq && bolaCentroX <= ladLadoDer)
                lado = 0;
            else if (bolaCentroX < ladLadoIzq)
                lado = 1;
            else
                lado = 3;
        }
        else {
            if (bolaCentroX >= ladLadoIzq && bolaCentroX <= ladLadoDer)
                lado = 2;
            else if (bolaCentroX < ladLadoIzq)
                lado = 1;
            else
                lado = 3;
        }
        return lado;
    }

    public int getIndice() {
        return indice;
    }
}
