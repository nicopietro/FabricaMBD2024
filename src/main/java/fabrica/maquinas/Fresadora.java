package fabrica.maquinas;

import fabrica.*;
import fabrica.marcas.Grosor;
import fabrica.marcas.OrFresa;
import fabrica.marcas.Posicion;

import java.util.List;

import static fabrica.marcas.OrFresa.*;
import static fabrica.marcas.Grosor.*;

public class Fresadora implements Maquina {
    private Posicion posActua;
    private OrFresa orientacion;
    private Grosor grosor;

    ///Constructor de Fresadora.
    /// @param pos Posicón sobre la que se quiere actuar.
    /// @param gr Grosor de la fresadora que se quiere implementar.
    /// @param of Orientación de la marca que se quiere hacer.
    /// @throws IllegalArgumentException Si se quiere actuar la fresadora sobre una posición
    /// fuera del alcance o si la orientación no es diagonal derecha o vertical.
    public Fresadora(Posicion pos, OrFresa of, Grosor gr) {
        if (!casillaValida(pos)) throw new IllegalArgumentException("Solo se puede actuar en las casillas IzSu, IzCe, IzIn, CeSu o CeCe");
        if (!orientacionValida(of)) throw new IllegalArgumentException("Solo se puede actuar en la orientación diagonal derecha o vertical");
        posActua = pos;
        orientacion = of;
        grosor = gr;
    }

    ///Permite saber si la orientación es válida o no.
    /// @return 'true' si es una orientación permitida 'false' si no.
    private boolean orientacionValida(OrFresa pos){
        return List.of(Diagonal, Vertical).contains(pos);
    }

    /// Permite aplicar una fresadora a una pieza.
    /// @param pieza Pieza sobre la que se quiere actuar.
    @Override
    public void actua(Pieza pieza) {
        Cuadro c = pieza.getCuadro(posActua);
        Grosor g;
        if (orientacion == Diagonal) {
            g = c.getFD();
            if(grosor == Grueso) c.setFV(grosor);
            if(grosor == Medio && (g == Fino || g == Medio)) c.setFV(grosor);
            if(grosor == Fino && g == SinGrosor) c.setFV(grosor);
        }
        else {
            g = c.getFV();
            if(grosor == Grueso) c.setFD(grosor);
            if(grosor == Medio && (g == Fino || g == Medio)) c.setFD(grosor);
            if(grosor == Fino && g == SinGrosor) c.setFD(grosor);
        }
    }

}
