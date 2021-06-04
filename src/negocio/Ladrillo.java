package negocio;

public class Ladrillo extends ObjetoPosicionado {

    private boolean estoyRoto;

    public Ladrillo(int posicionX, int posicionY, int tamanioX, int tamanioY, int maxX, int maxY) {
        super(posicionX, posicionY, tamanioX, tamanioY, maxX, maxY);
        this.estoyRoto = false;
    }

    public void destruccionLadrillo() {
        this.estoyRoto = true;
    }

    public boolean soyElLadrillo(int posX) {
        return this.posicionX == posX;
    }

    @Override
    public boolean detectarColision(int posX, int posY, int tamanio) {
        return detectarColision(posX, posY, tamanio, tamanio);
    }

    @Override
    public boolean detectarColision(int posX, int posY, int tamanio_x, int tamanio_y) {
        boolean colisionX = seSobrePonen(
            this.posicionX,
            this.posicionX + this.tamanioX,
            posX,
            posX + tamanioX
        );
        boolean colisionY = seSobrePonen(
            this.posicionY,
            this.posicionY + this.tamanioY,
            posY,
            posY + tamanioY
        );
        return colisionX && colisionY;
    }
}
