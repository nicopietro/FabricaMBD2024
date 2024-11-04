package fabrica.maquinas;

import fabrica.*;
import fabrica.posiciones.Posicion;
import fabrica.marcas.Sentido;

public class Rotadora implements Maquina {

    private Sentido sentido;

    /// Crea un objeto de la clase Rotadora.
    /// @param sentido Sentido de la rotación de la máquina.
    public Rotadora(Sentido sentido) {
        this.sentido = sentido;
    }

    /// Permite actuar con la rotadora en la pieza que se quiera.
    /// @param pieza Pieza sobre la que se quiere actuar.
    @Override
    public void actua(Pieza pieza) {
        for (Cuadro c : pieza.getPieza()) {
            c.rotar(sentido);
        }
    }
}
