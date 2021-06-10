package negocio;

import java.util.*;
import java.text.SimpleDateFormat;

public class Registro {

    private String nombre;
    private int puntos;
    private int duracionPartida;
    private Date fecha;


    public Registro(String nombre, int puntos, int duracionPartida) {
        this.nombre = nombre;
        this.puntos = puntos;
        this.duracionPartida = duracionPartida;
        this.fecha = new Date();
    }

    public String getNombre() {
        return this.nombre;
    }

    public int getPuntos() {
        return this.puntos;
    }

    public int getDuracionPartida() {
        return this.duracionPartida;
    }

    public Date getFecha() {
        return this.fecha;
    }

    public String getFechaFormateada() {
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        return formato.format(this.fecha);
    }

    @Override
    public String toString() {
        return nombre+" "+puntos+" "+duracionPartida+" "+getFechaFormateada();
    }

}

