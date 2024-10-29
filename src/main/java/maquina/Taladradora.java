package maquina;

import fabrica.Grosor;
import fabrica.Pieza;
import fabrica.Posicion;

public class Taladradora implements Maquina {

    public Taladradora(Posicion pos, Grosor gr) {

    }

    @Override
    public boolean casillaValida(Posicion posicion) {
        return false;
    }

    @Override
    public void actua(Pieza pieza) {

    }
}
