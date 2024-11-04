package fabrica.maquinas;

import fabrica.Cuadro;
import fabrica.Pieza;
import fabrica.marcas.Grosor;
import fabrica.posiciones.Posicion;

import static fabrica.marcas.Grosor.*;

public class Taladradora implements Maquina {

    private Posicion posActua;
    private Grosor grosor;

    /// Crea un objeto de la clase Taladradora.
    /// @param pos Posición sobre la que se quiere actuar.
    /// @param gr  Grosor que se quiere usar en la taladradora.
    /// @throws IllegalArgumentException Si se quiere actuar sobre una pieza fuera del alcance o
    /// el taladro no tiene grosor.
    public Taladradora(Posicion pos, Grosor gr) {
        if (!casillaValida(pos))
            throw new IllegalArgumentException("Solo se puede actuar en las casillas IzSu, IzCe, IzIn, CeSu o CeCe");
        if (gr == SinGrosor)
            throw new IllegalArgumentException("No se puede taladrar sin gorosor.");
        posActua = pos;
        grosor = gr;
    }

    /// Permite actuar con el taladro en la pieza que se quiera.
    /// Este sobreescribirá cualquier otro taladro de menor grosor y además
    /// si hay lijas Finas y el taladro es Grueso las borrará.
    /// @param pieza Pieza sobre la que se quiere taladrar.
    @Override
    public void actua(Pieza pieza) {
        Cuadro c = pieza.getCuadro(posActua);
        if (grosor == Grueso) {
            c.setTL(grosor);
            if (c.getLE() == Fino)
                c.setLE(SinGrosor);
            if (c.getLO() == Fino)
                c.setLO(SinGrosor);
            if (c.getLN() == Fino)
                c.setLN(SinGrosor);
            if (c.getLS() == Fino)
                c.setLS(SinGrosor);
        } else if (grosor == Medio && (c.getTL() == Fino || c.getTL() == SinGrosor))
            c.setTL(grosor);
        else if (grosor == Fino && c.getTL() == SinGrosor)
            c.setTL(grosor);
    }
}
