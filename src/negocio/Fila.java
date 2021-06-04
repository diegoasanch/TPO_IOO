package negocio;

import java.util.*;

public class Fila {

    private int puntaje;
    private int posicion; // De arriba a abajo
    private int dimension_y;
    private ArrayList<Ladrillo> ladrillos;

    public Fila(int puntaje, int posicion) {
        this.puntaje = puntaje;
        this.posicion = posicion;
        this.dimension_y = 50; //TODO: ver tamaño

        agregarLadrillos();
    }

    public void agregarLadrillos() {
        this.ladrillos = new ArrayList<Ladrillo>(5);
        int anchoLadrillo = 60;
        int margen = 15;

        for (int i = 0; i < 5; i++)
            ladrillos.add(new Ladrillo(
                (anchoLadrillo * i) + margen,
                this.posicion,
                anchoLadrillo,
                this.dimension_y,
                0,
                0
            ));
    }

    public void romperLadrillo(int posicion) {
        Ladrillo aRomper = buscarLadrillo(posicion);
        if (aRomper != null) {
            aRomper.destruccionLadrillo();
        }
    }

    public boolean soyLaFila(int posY) {
        return posY >= posicion && posY <= posicion + dimension_y;
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
            return ladrilloActual.detectarColision(posX, posY, tamanio);
        }
        return false;
    }

    public int getPuntaje() {
        return puntaje;
    }
}
