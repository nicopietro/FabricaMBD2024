import fabrica.*;
import fabrica.posiciones.*;
import gui.Gui;
import fabrica.maquinas.Fresadora;
import fabrica.maquinas.Rotadora;
import fabrica.maquinas.Lijadora;

public class Main2 {
    public static void main(String[] args) {
        Fabrica f = new Fabrica();
        f.agrega(new Fresadora(Posicion.CeCe, OrFresa.Vertical, Grosor.Medio));
        f.agrega(new Fresadora(Posicion.CeSu, OrFresa.Diagonal,Grosor.Medio));
        f.agrega(new Rotadora(Sentido.Antihorario));
        f.agrega(new Lijadora(Posicion.IzSu, OrLija.Norte,Grosor.Grueso));
        f.agrega(new Lijadora(Posicion.CeCe, OrLija.Sur,Grosor.Fino));
        f.agrega(new Fresadora(Posicion.CeSu, OrFresa.Diagonal, Grosor.Grueso));
        f.agrega(new Rotadora(Sentido.Horario));
        f.agrega(new Lijadora(Posicion.CeSu, OrLija.Norte,Grosor.Grueso));
        f.agrega(new Rotadora(Sentido.Antihorario));
        f.agrega(new Lijadora(Posicion.IzIn, OrLija.Norte,Grosor.Grueso));
        f.agrega(new Rotadora(Sentido.Antihorario));
        f.agrega(new Lijadora(Posicion.IzCe, OrLija.Norte, Grosor.Grueso));
        f.agrega(new Lijadora(Posicion.IzIn, OrLija.Norte,Grosor.Grueso));
        f.agrega(new Rotadora(Sentido.Antihorario));
        f.agrega(new Fresadora(Posicion.IzIn, OrFresa.Vertical, Grosor.Grueso));

        Pieza p = new Pieza();
        Gui gui = new Gui(f, p);
        gui.muestra();
        System.out.println(p);
    }
}
