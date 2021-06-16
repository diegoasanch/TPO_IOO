package negocio;

import java.util.*;

public class TopTwenty {

    private ArrayList<Registro> mejoresVeinte;
    private Partida partidaActual;
    private static TopTwenty instancia;

    private TopTwenty() {
        mejoresVeinte = new ArrayList<Registro>();
    }

    public static TopTwenty getInstance() {
        if (instancia == null)
            instancia = new TopTwenty();
        return instancia;
    }

    public void setPartidaActual(Partida partidaActual) {
        this.partidaActual = partidaActual;
    }

    private void agregarRecord(String nombre, int puntajeTotal, int duracionPartida) {
        Registro nuevoRegistro = new Registro(nombre, puntajeTotal, duracionPartida);
        insertarOrdenado(nuevoRegistro);
        mantenerTamanio();
    }

    public boolean mereceEntrar(int puntaje) {
        boolean puntajeEntra = false;
        for (Registro entrada : mejoresVeinte) {
            if (puntaje > entrada.getPuntos()) {
                puntajeEntra = true;
                break;
            }
        }
        return puntajeEntra;
    }

    private void mantenerTamanio() {
        if(mejoresVeinte.size()>20){
            mejoresVeinte.remove(20);
        }
    }

    public void ingresarNombre(String nombre) {
        if (!partidaActual.estaJugando()) {
            int puntaje = partidaActual.obtienePuntajeTotal();
            int duracion = partidaActual.calcularDuracionPartida();
            agregarRecord(nombre, puntaje, duracion);
        }
    }

    private void insertarOrdenado(Registro nuevoRegistro) {
        int posicionAInsertar = buscaPosicionNuevoRegistro(nuevoRegistro.getPuntos());
        mejoresVeinte.add(posicionAInsertar, nuevoRegistro);
    }

    private int buscaPosicionNuevoRegistro(int puntaje) {
        int posicion = 0;
        for (Registro entrada : mejoresVeinte) {
            if (puntaje > entrada.getPuntos())
                break;
            posicion++;
        }
        return posicion;
    }

}
