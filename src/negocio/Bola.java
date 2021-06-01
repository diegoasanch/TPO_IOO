package negocio;
import java.util.*;

public class Bola extends ObjetoPosicionado {

    private int velocidad;
    private int sentido;

    public Bola(int velocidadInicial) {
        this.velocidad = velocidadInicial;
    }
    
    public void cambiarVelocidad(int velocidad) {
    }

    public void mover() {
    }

    public void rebotarPared() {
    }

    public void rebotar(String objetoDeRebote, String posicionImpacto) {
    }

    public boolean detectarColision(int posX, int posY, int tamanio) {
        return false;
    }

}