package fabrica.maquinas;

import fabrica.*;
import fabrica.marcas.Posicion;
import fabrica.marcas.Sentido;

public class Rotadora implements Maquina {

    private Sentido sentido;

    /// Crea una rotadora.
    /// @param sentido Sentido de la rotación de la máquina.
    public Rotadora(Sentido sentido) {
        this.sentido = sentido;
    }

    /// Permite aplicar una rotadora a una pieza.
    /// @param pieza Pieza sobre la que se quiere actuar.
    @Override
    public void actua(Pieza pieza) {
        for (Posicion pos : Posicion.values()) {
            Cuadro c = pieza.getCuadro(pos);
            c.rotar(sentido);
        }
    }
}
