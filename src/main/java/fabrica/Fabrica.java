package fabrica;

import maquina.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Fabrica {
    // Random para el metodo Fabrica aleatoria()
    private List<Maquina> maquinas;
    private Pieza pieza;
    private static Random alea = new Random();

    public Fabrica(List<Maquina> maquinas) {
        pieza = new Pieza();
        this.maquinas = maquinas;
    }

    public List<Maquina> maquinas() {
        return maquinas;
    }

    public Fabrica aleatoria(int n) {
        return null;
    }

    /// Cada maquina actua en el orden de la lista en la pieza
    public void ejecutar() {
        for (Maquina m : maquinas) {
            m.actua(pieza);
        }
    }
    @Override
    public String toString(){
        return pieza.toString();
    }

}
