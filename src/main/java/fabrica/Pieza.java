package fabrica;

import fabrica.posiciones.Posicion;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Pieza {

    private List<Cuadro> pieza;

    /// Crea un objeto de la clase Pieza con 9 cuadros sin ninguna marca
    public Pieza() {
        pieza = new ArrayList<>();
        for (Posicion pos : Posicion.values()) {
            pieza.add(new Cuadro(pos));
        }
    }

    /// Devuelve el cuadro de la posición pasada como parámetro
    /// @param pos Posición del cuadro que se desea retornar
    public Cuadro getCuadro(Posicion pos) {
        Iterator<Cuadro> iterator = pieza.iterator();
        while (iterator.hasNext()) {
            Cuadro c = iterator.next();
            if (c.getPosicion()==pos) return c;
        }
        throw new RuntimeException("No se encontró ningún cuadro");
    }

    /// Redefinición del método toString que devuelve una representación de la pieza
    /// con sus 9 cuadros y todas las marcas de cada uno
    @Override
    public String toString(){
        return
            "|" + getCuadro(Posicion.IzSu).toString() + getCuadro(Posicion.CeSu) + getCuadro(Posicion.DeSu) + "|\n"
                + getCuadro(Posicion.IzCe).toString() + getCuadro(Posicion.CeCe) + getCuadro(Posicion.DeCe) + "|\n"
                + getCuadro(Posicion.IzIn).toString() + getCuadro(Posicion.CeIn) + getCuadro(Posicion.DeIn) + "|";
    }

    public List<Cuadro> getPieza() {
        return pieza;
    }
}
