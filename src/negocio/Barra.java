package negocio;
/**
 *
 */
public class Barra extends ObjetoPosicionado {

    public Barra(int posicionX, int posicionY, int tamanioX, int tamanioY,  int maxX) {
        // Maxima posicion de barra es su posicion inicial
        super(posicionX, posicionY, tamanioX, tamanioY, maxX, posicionY);
        asignarDimensiones(minX, maxX);
    }

    public void moverBarra(String direccion) {
        if (mePuedoMover(direccion)) {
            int movimiento_x;
            if (direccion.equals("izquierda"))
                movimiento_x = -1;
            else
                movimiento_x = +1;

            this.posicionX += movimiento_x;
        }
    }

    private boolean mePuedoMover(String direccion) {
        if (direccion.equals("izquierda"))
            return this.posicionX > minX;
        return this.posicionX < maxX;
    }

    private void asignarDimensiones(int minX, int maxX) {
        this.minX = minX;
        this.maxX = maxX;
    }

    public boolean mitadDerecha(int posXCentro) {
        return posXCentro >= this.posicionX + (this.tamanioX / 2);
    }
}
