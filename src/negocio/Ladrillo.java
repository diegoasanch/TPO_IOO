package negocio;

import constantes.DimensionesLadrillo;
import view.LadrilloView;

public class Ladrillo extends ObjetoPosicionado {

    private boolean estoyRoto;
    private int indice;

    public Ladrillo(int posicionX, int posicionY, int tamanioX, int tamanioY, int maxX, int maxY, int indice) {
        super(posicionX, posicionY, tamanioX, tamanioY, maxX, maxY);
        this.estoyRoto = false;
        this.indice = indice;
    }

    public void destruccionLadrillo() {
        this.estoyRoto = true;
    }

    public boolean soyElLadrillo(int posX, int tamanio) {
        int radioBola = tamanio / 2;
        int minX = (indice * tamanioX) + DimensionesLadrillo.MARGEN - radioBola;
        int maxX = ((indice + 1)* tamanioX) + DimensionesLadrillo.MARGEN - tamanio + radioBola;
        return posX >= minX && posX < maxX;
    }

    public boolean estaRoto() {
        return estoyRoto;
    }

    public int getIndice() {
        return indice;
    }

    public LadrilloView toView() {
        return new LadrilloView(posicionX, posicionY, tamanioX, tamanioY, estoyRoto);
    }
}
