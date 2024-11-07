package fabrica.maquinas;

import fabrica.*;
import fabrica.posiciones.Posicion;

import java.util.List;

import static fabrica.posiciones.Posicion.*;

/**
 * @author Nicolás Pietrocola
 * @author Andrés Amo Caballero
 * @author Álvaro Cabello Martín
 * @author Javier Osuna Titos
 * @version 1.0
 */

public interface Maquina {

    /// Método abstracto que las maquina deben implementar para que se efectue su acción sobre la pieza
    void actua(Pieza pieza);

    /// Permite saber si la casilla sobre la que se actua es válida.
    /// @return {@code true} si es una casilla permitida, `false` en otro caso.
    default boolean casillaValida(Posicion pos){
        return List.of(IzSu, IzCe, IzIn, CeSu, CeCe).contains(pos);
    }
}
