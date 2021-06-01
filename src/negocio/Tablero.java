package negocio;

import java.util.*;

public class Tablero {

    private int dimension_x;
    private int dimension_y;

    private Partida partida;
    private Barra barra;
    private Bola bola;
    private ArrayList<Fila> filas; // 5 filas

    public Tablero() {
        this.dimension_x = 400;
        this.dimension_y = 400;

        agregarFilas();
        crearBarra();
        crearBola();
    }
    
    public void agregarFilas() {
        this.filas = new ArrayList<Fila>(5);
        int puntajes[] = new int[]{ 50, 40, 30, 20, 10 };

        for (int i = 0; i < 5; i++)
            filas.add(new Fila(puntajes[i], i));
    }

    public void crearBola() {
        int VEL_INICIAL = 1;
        this.bola = new Bola(VEL_INICIAL);
    }
    
    public void crearBarra() {
        this.barra = new Barra();
    }

    public void calcularPos() {
        
    }
    
    public boolean detectarLadrilloRoto() {
        
        return false;
    }

    public Fila buscarFila(int posY) {
        return null;
    }

    private boolean detectarSaleDeTablero() {

        return false;
    }

}