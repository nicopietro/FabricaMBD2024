package fabrica.maquinas;

import fabrica.*;
import fabrica.marcas.Grosor;
import fabrica.posiciones.Posicion;

import static fabrica.marcas.Grosor.*;

public class Taladradora implements Maquina {

    private Posicion posActua;
    private Grosor grosor;
    ///Constructor de la clase
    /// @param pos Posición sobre la que se quiere actuar
    /// @param gr Grosor que se quiere usar en la taladradora
    /// @throws IllegalArgumentException Si se quiere actuar sobre una pieza fuera del alcance o
    /// el taladro no tiene grosor
    public Taladradora(Posicion pos, Grosor gr) {
        if(!casillaValida(pos)) throw new IllegalArgumentException("Solo se puede actuar en las casillas IzSu, IzCe, IzIn, CeSu o CeCe");
        if(gr == SinGrosor) throw new IllegalArgumentException("No se puede taladrar sin gorosor.");
        posActua = pos;
        grosor = gr;
    }
    ///Permite actuar con el taladro en la pieza que se quiera
    /// Este sobreescribirá cualquier otro taladro de menor grosor y además
    /// si hay lijas Finas y el taladro es Grueso las borrará.
    /// @param pieza Pieza sobre la que se quiere taladrar.
    @Override
    public void actua(Pieza pieza) {
        Cuadro c = pieza.getCuadro(posActua);
        if (c.getLE() == Fino && grosor == Grueso)
            c.setLE(SinGrosor);
        if (c.getLO() == Fino && grosor == Grueso)
            c.setLO(SinGrosor);
        if (c.getLN() == Fino && grosor == Grueso)
            c.setLN(SinGrosor);
        if (c.getLS() == Fino && grosor == Grueso)
            c.setLS(SinGrosor);

//        if ((c.getLE() == Fino || c.getLN() == Fino ||
//                c.getLS() == Fino || c.getLO() == Fino)
//                && grosor == Grueso){
//            c.setLS(SinGrosor);
//            c.setLN(SinGrosor);
//            c.setLE(SinGrosor);
//            c.setLO(SinGrosor);
//            c.setTL(grosor);
//        }
        if (grosor == Grueso) c.setTL(grosor);
        else if (grosor == Medio && (c.getLS() == Fino ||
                c.getLS() == SinGrosor)) c.setTL(grosor);
        else if (grosor == Fino && c.getTL() == SinGrosor) c.setTL(grosor);
    }
}
