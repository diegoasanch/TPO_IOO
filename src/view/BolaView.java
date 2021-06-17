package view;

public class BolaView {
    private int posX, posY, diametro;

    public BolaView(int posX, int posY, int diametro) {
        this.posX = posX;
        this.posY = posY;
        this.diametro = diametro;
    }

    public int getX() {
        return posX;
    }

    public int getY() {
        return posY;
    }

    public int getDiametro() {
        return diametro;
    }
}
