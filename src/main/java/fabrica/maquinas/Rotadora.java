package fabrica.maquinas;

import fabrica.*;
import fabrica.posiciones.Posicion;
import fabrica.marcas.Sentido;

/**
 * @author Nicolás Pietrocola
 * @author Andrés Amo Caballero
 * @author Álvaro Cabello Martín
 * @author Javier Osuna Titos
 * @version 1.0
 */

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

    /// Devuelve el sentido de rotación que tiene asignado la rotadora.
    public Sentido getSentido() { return sentido; }
}
