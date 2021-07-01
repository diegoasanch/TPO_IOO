package view;

public class RegistroView {
    private String nombre;
    private int puntaje;
    private int duracion;
    private String fecha;

    public RegistroView(String nombre, int puntaje, int duracion, String fecha) {
        this.nombre = nombre;
        this.puntaje = puntaje;
        this.duracion = duracion;
        this.fecha = fecha;
    }

    public String getNombre() {
        return this.nombre;
    }

    public int getPuntaje() {
        return this.puntaje;
    }

    public int getDuracion() {
        return this.duracion;
    }

    public String getFecha() {
        return this.fecha;
    }

}
