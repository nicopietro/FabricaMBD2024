package fabrica.maquinas;

import fabrica.*;
import fabrica.marcas.Grosor;
import fabrica.marcas.OrLija;
import fabrica.posiciones.Posicion;

import java.util.List;

import static fabrica.marcas.OrLija.*;
import static fabrica.marcas.Grosor.*;

public class Lijadora  implements Maquina {

    private Posicion posicion;
    private OrLija orientacion;
    private Grosor grosor;

    /// Crea un objeto de la clase Lijadora.
    /// @param pos Posicón sobre la que se quiere actuar.
    /// @param ol Orientación de la marca que se quiere hacer.
    /// @param gr Grosor de la lijadora que se quiere implementar.
    /// @throws IllegalArgumentException Si se quiere actuar la lijadora sobre una posición
    /// fuera del alcance o si la orientación no es Norte o Sur.
    public Lijadora(Posicion pos, OrLija ol, Grosor gr) {
        if (!casillaValida(pos))
            throw new IllegalArgumentException("Solo se puede actuar en las casillas IzSu, IzCe, IzIn, CeSu o CeCe");
        if (!orientacionValida(ol))
            throw new IllegalArgumentException("Solo se puede actuar en la orientación Norte o Sur");
        posicion = pos;
        orientacion = ol;
        grosor = gr;
    }

    /// Método auxiliar que permite saber si la orientación es válida o no.
    /// @return {@code true} si es una orientación permitida `false` si la orientación no es válida.
    private boolean orientacionValida(OrLija ol) { return List.of(Norte, Sur).contains(ol); }

    /// Permite actuar con la lijadora en la pieza que se quiera.
    /// Ninguna lija fina puede crearse si ya existe un taladro grueso aplicado.
    /// @param pieza Pieza sobre la que se quiere actuar.
    @Override
    public void actua(Pieza pieza) {
        Cuadro c = pieza.getCuadro(posicion);
        Grosor g;
        if (orientacion == Norte) {
            g = c.getLN();
            if (grosor == Grueso)
                c.setLN(grosor);
            if (grosor == Medio && (g == Fino || g == SinGrosor))
                c.setLN(grosor);
            if (grosor == Fino && g == SinGrosor && !(c.getTL() == Grueso))
                c.setLN(grosor);
        } else {
            g = c.getLS();
            if (grosor == Grueso)
                c.setLS(grosor);
            if (grosor == Medio && (g == Fino || g == SinGrosor))
                c.setLS(grosor);
            if (grosor == Fino && g == SinGrosor && !(c.getTL() == Grueso))
                c.setLS(grosor);
        }
    }
}
