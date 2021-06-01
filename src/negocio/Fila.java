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

        for (int i = 0; i < 5; i++) 
            ladrillos.add(new Ladrillo(i));
    }

    public int romperLadrillo(int posicion) {
        return 0;
    }

    public boolean soyLaFila(int posY) {
        return false;
    }

    public Ladrillo buscarLadrillo(int posX) {
        return null;
    }
}