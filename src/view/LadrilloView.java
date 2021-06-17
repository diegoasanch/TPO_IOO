package view;

public class LadrilloView {
    private int x, y, tX, tY;
    private boolean estaRoto;

    public LadrilloView(int x, int y, int tX, int tY, boolean estaRoto){
        this.x = x;
        this.y = y;
        this.tX = tX;
        this.tY = tY;
        this.estaRoto = estaRoto;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public int getAncho(){
        return tX;
    }

    public int getAlto(){
        return tY;
    }

    public boolean getEstaRoto() {
        return estaRoto;
    }
}
