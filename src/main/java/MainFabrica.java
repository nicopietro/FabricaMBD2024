import fabrica.*;
import fabrica.maquinas.Taladradora;
import fabrica.marcas.*;
import fabrica.posiciones.*;
import gui.Gui;
import fabrica.maquinas.Lijadora;
//Este main es una prueba habria que borrarlo
public class MainFabrica {
    public static void main(String[] args) {
        Fabrica f = new Fabrica();
        f.agrega(new Lijadora(Posicion.CeCe, OrLija.Norte,Grosor.Fino));
        f.agrega(new Lijadora(Posicion.CeCe, OrLija.Sur,Grosor.Grueso));
        f.agrega(new Taladradora(Posicion.CeCe, Grosor.Grueso))

;

        Pieza p = new Pieza();
        Gui gui = new Gui(f, p);
        gui.muestra();
        System.out.println(p);
    }
}
