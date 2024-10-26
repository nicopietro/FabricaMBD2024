package fabrica;

import java.util.List;
import static fabrica.Posicion.*;
import static fabrica.OrFresa.*;

public class Fresadora implements Maquina {
    private Posicion posActua;
    private OrFresa orientacion;
    private Grosor grosor;
    ///Constructor de Fresadora
    /// @param pos posicón sobre la que se quiere actuar (debe de ser válida)
    /// @param gr Grosor de la fresadora que se quiere implementar
    /// @param of Orientación de la marca que se quiere hacer
    public Fresadora(Posicion pos, OrFresa of, Grosor gr) {
        if (!casillaValida(pos)) throw new IllegalArgumentException("Solo se puede actuar en las casillas IzSu, IzCe, IzIn, CeSu o CeCe");
        if (!orientacionValida(of)) throw new IllegalArgumentException("Solo se puede actuar en la orientación diagonal derecha o vertical");
        posActua = pos;
        orientacion = of;
        grosor = gr;
    }
    ///Permite saber si la casilla sobre la que se actua es válida.
    /// @return 'true' si es una casilla permitida 'false' si no.
    private boolean casillaValida(Posicion pos){
        return List.of(IzSu, IzCe, IzIn, CeSu, CeCe).contains(pos);
    }
    ///Permite saber si la orientación es válida o no.
    /// @return 'true' si es una orientación permitida 'false' si no.
    private boolean orientacionValida(OrFresa pos){
        return List.of(Diagonal, Vertical).contains(pos);
    }

    @Override
    public void actua(Pieza pieza) {

    }
}
