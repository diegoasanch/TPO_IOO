package view;

public class BarraView {
    private int posX, posY, ancho, alto;

    public BarraView(int posX, int posY, int ancho, int alto){
        this.posX = posX;
        this.posY = posY;
        this.ancho = ancho;
        this.alto = alto;
    }

    public int getX(){
        return posX;
    }

    public int getY(){
        return posY;
    }

    public int getAncho(){
        return ancho;
    }

    public int getAlto(){
        return alto;
    }
}
