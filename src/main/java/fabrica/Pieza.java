package fabrica;

import maquina.Maquina;

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
            if (c.getPosicion().equals(pos)) return c;
        }
        throw new RuntimeException("No se encontró ningún cuadro");
    }
    public List<String> toStringNuevo(){
        List<String> lista = new ArrayList<>();
        lista.add(getCuadro(Posicion.IzSu).toString() + getCuadro(Posicion.CeSu) + getCuadro(Posicion.DeSu));
        lista.add(getCuadro(Posicion.IzCe).toString() + getCuadro(Posicion.CeCe) + getCuadro(Posicion.DeCe));
        lista.add(getCuadro(Posicion.IzIn).toString() + getCuadro(Posicion.CeIn) + getCuadro(Posicion.DeIn));
        return lista;
    }

}
