package fabrica.maquinas;

import fabrica.*;
import fabrica.marcas.Posicion;

import java.util.List;

import static fabrica.marcas.Posicion.*;

public interface Maquina {

    void actua(Pieza pieza);

    ///Permite saber si la casilla sobre la que se actua es válida.
    /// @return 'true' si es una casilla permitida, 'false' en otro caso.
    default boolean casillaValida(Posicion pos){
        return List.of(IzSu, IzCe, IzIn, CeSu, CeCe).contains(pos);
    }
}
