package maquina;

import fabrica.Pieza;
import fabrica.Posicion;
import fabrica.Sentido;

public class Rotadora implements Maquina {

    public Rotadora(Sentido sentido) {

    }

    // Esto habria que ver la manera de que no afecte ¿?¿?¿
     // o siempre true, nose
    @Override
    public boolean casillaValida(Posicion posicion) {
        return false;
    }

    @Override
    public void actua(Pieza pieza) {

    }
}
