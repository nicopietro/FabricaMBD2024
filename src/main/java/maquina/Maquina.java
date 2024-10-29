package maquina;

import fabrica.Pieza;
import fabrica.Posicion;

public interface Maquina {

    boolean casillaValida(Posicion posicion);

    //boolean orientacionValida(Orientacion orientacion);

    void actua(Pieza pieza);
}
