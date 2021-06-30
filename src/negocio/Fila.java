package negocio;

import java.util.*;

import constantes.DimensionesLadrillo;
import view.LadrilloView;

public class Fila {

    private int puntaje;
    private int indice; // De arriba a abajo
    private int dimension_y;
    private ArrayList<Ladrillo> ladrillos;


    public Fila(int puntaje, int indice) {
        this.puntaje = puntaje;
        this.indice = indice;
        this.dimension_y = DimensionesLadrillo.TAMANIO_Y;

        agregarLadrillos();
    }

    public void agregarLadrillos() {
        this.ladrillos = new ArrayList<Ladrillo>(5);

        final int MOV_X_Y = 0;

        for (int indiceCol = 0; indiceCol < 5; indiceCol++) {
            ladrillos.add(new Ladrillo(
                (DimensionesLadrillo.TAMANIO_X * indiceCol) + DimensionesLadrillo.MARGEN,
                (DimensionesLadrillo.TAMANIO_Y * indice) + DimensionesLadrillo.MARGEN,
                DimensionesLadrillo.TAMANIO_X,
                DimensionesLadrillo.TAMANIO_Y,
                MOV_X_Y,
                MOV_X_Y,
                indiceCol
            ));
        }
    }

    public void romperLadrillo(int posicion, int tamanio) {
        Ladrillo aRomper = buscarLadrillo(posicion, tamanio);
        if (aRomper != null) {
            System.out.println("Rompiendo ladrillo: " + indice + ' ' + aRomper.getIndice());
            aRomper.destruccionLadrillo();
        }
    }

    public boolean soyLaFila(int posY, int tamanio) {
        int minY = (indice * dimension_y) + DimensionesLadrillo.MARGEN;
        int maxY = ((indice + 1) * dimension_y) + DimensionesLadrillo.MARGEN;
        int bolaSuperior = posY;
        int bolaInferior = posY + tamanio;
        return (
            bolaSuperior >= minY && bolaSuperior <= maxY ||
            bolaInferior >= minY && bolaInferior <= minY
        );
    }

    private Ladrillo buscarLadrillo(int posX, int tamanio) {
        Ladrillo resultado = null;
        for (Ladrillo lad : ladrillos) {
            if (lad.soyElLadrillo(posX, tamanio)) {
                resultado = lad;
                break;
            }
        }
        return resultado;
    }

    public boolean detectarLadrilloRoto(int posX, int posY, int tamanio) {
        Ladrillo ladrilloActual = buscarLadrillo(posX, tamanio);
        if (ladrilloActual != null && !ladrilloActual.estaRoto())
            return ladrilloActual.detectarColision(posX, posY, tamanio);
        return false;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public boolean quedanLadrillos() {
        int rotos = 0;
        for (Ladrillo lad : ladrillos) {
            if (lad.estaRoto())
                rotos++;
        }
        return rotos != ladrillos.size();
    }

    public List<LadrilloView> toView() {
        List<LadrilloView> fila = new ArrayList<>();
        for (Ladrillo ladrillo : ladrillos)
            fila.add(ladrillo.toView());
        return fila;
    }
}
