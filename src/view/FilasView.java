package view;

import java.util.List;

public class FilasView {
    private List<List<LadrilloView>> filas;

    public FilasView(List<List<LadrilloView>> filas) {
        this.filas = filas;
    }

    public List<List<LadrilloView>> getFilas() {
        return filas;
    }
}
