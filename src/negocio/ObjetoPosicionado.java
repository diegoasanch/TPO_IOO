package negocio;

public class ObjetoPosicionado {

    protected int posicionX;
    protected int posicionY;
    protected int tamanioX;
    protected int tamanioY;

    protected int minX;
    protected int maxX;
    protected int minY;
    protected int maxY;

    protected ObjetoPosicionado(int posicionX, int posicionY, int tamanioX, int tamanioY, int maxX, int maxY) {
        this.posicionX = posicionX;
        this.posicionY = posicionY;
        this.tamanioX = tamanioX;
        this.tamanioY = tamanioY;
        this.minX = 0;
        this.maxX = maxX - tamanioX;
        this.minY = 0;
        this.maxY = maxY - tamanioY;
    }

    protected boolean seSobrePonen(int min_a, int max_a, int min_b, int max_b) {
        return min_a <= max_b && max_a >= min_b;
    }

    public boolean detectarColision(int posX, int posY, int tamanioX, int tamanioY) {
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

    public boolean detectarColision(int posX, int posY, int tamanio) {
        return detectarColision(posX, posY, tamanio, tamanio);
    }

    public int getPosicionX() {
        return posicionX;
    }

    public int getPosicionY() {
        return posicionY;
    }

    public int getTamanioX() {
        return tamanioX;
    }

    public int getTamanioY() {
        return tamanioY;
    }

    public int getMinX() {
        return minX;
    }

    public int getMaxX() {
        return maxX;
    }

    public int getMinY() {
        return minY;
    }

    public int getMaxY() {
        return maxY;
    }
}
