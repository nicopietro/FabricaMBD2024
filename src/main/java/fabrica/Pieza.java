package fabrica;

import maquina.Maquina;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Pieza {

    private List<Cuadro> pieza;

    public Pieza() {
        for (Posicion pos : Posicion.values()) {
            pieza = new ArrayList<>();
            pieza.add(new Cuadro(pos));
        }
    }

    public Cuadro getCuadro(Posicion pos) {
        Iterator<Cuadro> iterator = pieza.iterator();
        while (iterator.hasNext()) {
            Cuadro c = iterator.next();
            if (c.getPosicion().equals(pos)) return c;
        }
        throw new RuntimeException("No se encontró ningún cuadro");
    }
}
