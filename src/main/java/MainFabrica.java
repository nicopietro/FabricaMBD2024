import fabrica.*;
import fabrica.maquinas.Fresadora;
import fabrica.maquinas.Rotadora;
import fabrica.maquinas.Taladradora;
import fabrica.marcas.*;
import fabrica.posiciones.*;
import gui.Gui;
import fabrica.maquinas.Lijadora;

/**
 * @author Nicolás Pietrocola
 * @author Andrés Amo Caballero
 * @author Álvaro Cabello Martín
 * @author Javier Osuna Titos
 * @version 1.0
 */

public class MainFabrica {
    public static void main(String[] args) {
        Fabrica f = new Fabrica();

        f.agrega(new Lijadora(Posicion.IzCe, OrLija.Norte, Grosor.Medio));
        f.agrega(new Rotadora(Sentido.Horario));
        f.agrega(new Rotadora(Sentido.Horario));

        f.agrega(new Fresadora(Posicion.IzIn, OrFresa.Diagonal, Grosor.Grueso));
        f.agrega(new Fresadora(Posicion.IzIn, OrFresa.Vertical, Grosor.Medio));
        f.agrega(new Fresadora(Posicion.IzCe, OrFresa.Vertical, Grosor.Medio));
        f.agrega(new Taladradora(Posicion.CeCe, Grosor.Grueso));
        f.agrega(new Taladradora(Posicion.IzIn, Grosor.Grueso));
        f.agrega(new Taladradora(Posicion.IzCe, Grosor.Medio));
        f.agrega(new Taladradora(Posicion.CeSu, Grosor.Fino));
        f.agrega(new Lijadora(Posicion.CeCe, OrLija.Norte, Grosor.Medio));

        f.agrega(new Rotadora(Sentido.Antihorario));
        f.agrega(new Fresadora(Posicion.IzCe, OrFresa.Vertical, Grosor.Medio));
        f.agrega(new Lijadora(Posicion.CeCe, OrLija.Norte, Grosor.Grueso));

        Pieza p = new Pieza();
        Gui gui = new Gui(f, p);
        gui.muestra();
        System.out.println(p);
    }
}
