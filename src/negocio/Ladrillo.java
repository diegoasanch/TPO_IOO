package negocio;

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

    public boolean soyElLadrillo(int posX) {
        return this.posicionX == posX;
    }

    public boolean estaRoto() {
        return estoyRoto;
    }

    public int getIndice() {
        return indice;
    }
}
