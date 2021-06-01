package negocio;

import java.util.*;

public class Ladrillo extends ObjetoPosicionado {

    private boolean estoyRoto;
    private int posicion; // De izquierda a derecha
    
    public Ladrillo(int posicion) {
        this.posicion = posicion;
        this.estoyRoto = false;
    }

    public void destruccionLadrillo() {
    }

    public boolean soyElLadrillo(int posX) {
        return false;
    }

    public boolean detectarColision(int posX, int posY, int tamanio) {
        return false;
    }

}