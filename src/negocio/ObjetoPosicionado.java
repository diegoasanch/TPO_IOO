package negocio;

import java.util.*;

public abstract class ObjetoPosicionado {


    protected int posicion_x;
    protected int posicion_y;
    protected int tamanio;

    public ObjetoPosicionado() {
    }

    protected void cambiarPosicion(int increX, int increY) {
        
        return null;
    }

    
    protected int[] obtenerPosicion() {
        
        return null;
    }

    
    public abstract boolean detectarColision(int posX, int posY, int tamanio);

}