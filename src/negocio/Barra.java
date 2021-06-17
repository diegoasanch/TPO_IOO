package negocio;

import view.BarraView;
/**
 *
 */
public class Barra extends ObjetoPosicionado {

    public Barra(int posicionX, int posicionY, int tamanioX, int tamanioY,  int maxX) {
        // Maxima posicion de barra es su posicion inicial
        super(posicionX, posicionY, tamanioX, tamanioY, maxX, posicionY);
        asignarDimensiones(minX, maxX);
    }

    /**
     * @param direccion debe ser "izquierda" o "derecha"
     */
    public void moverBarra(String direccion) {
        if (mePuedoMover(direccion)) {
            int mov;
            int distancia = 7;
            if (direccion.equals("izquierda"))
                mov = Math.max(-distancia, -posicionX); // Para prevenir que salga de los limites
            else
                mov = Math.min(distancia, maxX-(posicionX+tamanioX));  // Para prevenir que salga de los limites
            this.posicionX += mov;
        }
    }

    private boolean mePuedoMover(String direccion) {
        if (direccion.equals("izquierda"))
            return posicionX > minX;
        return (posicionX+tamanioX) <= maxX;
    }

    private void asignarDimensiones(int minX, int maxX) {
        this.minX = minX;
        this.maxX = maxX;
    }

    public boolean mitadDerecha(int posXCentro) {
        return posXCentro >= this.posicionX + (this.tamanioX / 2);
    }

    public BarraView toView(){
        return new BarraView(posicionX, posicionY, tamanioX, tamanioY);
    }
}
