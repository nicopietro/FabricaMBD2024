package fabrica.maquinas;

import fabrica.*;
import fabrica.marcas.Grosor;
import fabrica.marcas.Posicion;

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
        if(gr == Grosor.SinGrosor) throw new IllegalArgumentException("No se puede taladrar sin gorosor.");
        posActua = pos;
        grosor = gr;
    }
    ///Permite acutar con el taladro en la pieza que se quiera
    /// Este sobreescribirá cualquier otro taladro de menor grosor y además
    /// si hay lijas Finas y el taladro es Grueso las borrará.
    /// @param pieza Pieza sobre la que se quiere taladrar
    @Override
    public void actua(Pieza pieza) {
        Cuadro c = pieza.getCuadro(posActua);
        if ((c.getLE() == Grosor.Fino || c.getLN() == Grosor.Fino ||
                c.getLS() == Grosor.Fino || c.getLO() == Grosor.Fino)
                && grosor == Grosor.Grueso){
            c.setLS(Grosor.SinGrosor);
            c.setLN(Grosor.SinGrosor);
            c.setLE(Grosor.SinGrosor);
            c.setLO(Grosor.SinGrosor);
            c.setTL(grosor);
        }
        else if (grosor == Grosor.Grueso) c.setTL(grosor);
        else if (grosor == Grosor.Medio && (c.getLS() == Grosor.Fino ||
                c.getLS() == Grosor.SinGrosor)) c.setTL(grosor);
        else if (grosor == Grosor.Fino && c.getTL() == Grosor.SinGrosor) c.setTL(grosor);
    }
}
