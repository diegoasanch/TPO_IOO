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
        this.dimension_y = 50; //TODO: ver tamaño

        agregarLadrillos();
    }

    public void agregarLadrillos() {
        this.ladrillos = new ArrayList<Ladrillo>(5);

        final int anchoLadrillo = 60;
        final int margen = 15;
        final int MOV_X_Y = 0;

        for (int indiceCol = 0; indiceCol < 5; indiceCol++) {
            ladrillos.add(new Ladrillo(
                (DimensionesLadrillo.TAMANIO_X * indiceCol) + DimensionesLadrillo.MARGEN,
                (DimensionesLadrillo.TAMANIO_Y * indice) + DimensionesLadrillo.MARGEN,
                DimensionesLadrillo.TAMANIO_X,
                DimensionesLadrillo.TAMANIO_Y,
                MOV_X_Y,
                MOV_X_Y,
                indice
            ));
        }
    }

    public void romperLadrillo(int posicion) {
        Ladrillo aRomper = buscarLadrillo(posicion);
        if (aRomper != null) {
            aRomper.destruccionLadrillo();
        }
    }

    public boolean soyLaFila(int posY) {
        return posY >= indice && posY <= indice + dimension_y;
    }

    private Ladrillo buscarLadrillo(int posX) {
        Ladrillo resultado = null;
        for (Ladrillo lad : ladrillos) {
            if (lad.soyElLadrillo(posX)) {
                resultado = lad;
                break;
            }
        }
        return resultado;
    }

    public boolean detectarLadrilloRoto(int posX, int posY, int tamanio) {
        Ladrillo ladrilloActual = buscarLadrillo(posX);
        if (ladrilloActual != null) {
            if (!ladrilloActual.estaRoto())
                return ladrilloActual.detectarColision(posX, posY, tamanio);
        }
        return false;
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
}
