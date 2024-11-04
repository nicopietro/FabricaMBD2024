package fabrica;

import fabrica.posiciones.Posicion;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Pieza {

    private List<Cuadro> pieza;

    public Pieza() {
        pieza = new ArrayList<>();
        for (Posicion pos : Posicion.values()) {
            pieza.add(new Cuadro(pos));
        }
    }

    public Cuadro getCuadro(Posicion pos) {
        Iterator<Cuadro> iterator = pieza.iterator();
        while (iterator.hasNext()) {
            Cuadro c = iterator.next();
            if (c.getPosicion()==pos) return c;
        }
        throw new RuntimeException("No se encontró ningún cuadro");
    }
    @Override
    public String toString(){
        String string;
        string = getCuadro(Posicion.IzSu).toString() + getCuadro(Posicion.CeSu) + getCuadro(Posicion.DeSu)+
        "|"+"\n"+getCuadro(Posicion.IzCe).toString() + getCuadro(Posicion.CeCe) + getCuadro(Posicion.DeCe)+
        "|"+"\n"+getCuadro(Posicion.IzIn).toString() + getCuadro(Posicion.CeIn) + getCuadro(Posicion.DeIn) +"|";
        return string;
    }

    public List<Cuadro> getPieza() {
        return pieza;
    }
}
