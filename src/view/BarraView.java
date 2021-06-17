package view;

public class BarraView {
    private int x, y, tX, tY;

    public BarraView(int x, int y, int tX, int tY){
        this.x = x;
        this.y = y;
        this.tX = tX;
        this.tY = tY;
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
}
