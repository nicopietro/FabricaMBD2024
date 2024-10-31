package fabrica;

import fabrica.marcas.Grosor;
import fabrica.marcas.Posicion;

public class Pieza_old {
    private record Marca(boolean existe, Grosor grosor) {};

    private record Cuadro(    boolean eLN, Grosor LN,
                              boolean eLS, Grosor LS,
                              boolean eLE, Grosor LE,
                              boolean eLO, Grosor LO,
                              boolean eFV, Grosor FV,
                              boolean eFH, Grosor FH,
                              boolean eFD, Grosor FD,
                              boolean eFI, Grosor FI,
                              boolean eTL, Grosor TL) {};

    private Marca LN, LS, LE, LO, FV, FH, FD, FI, TL;
    private Posicion posicion;




    public Pieza_old(Posicion pos) {
        posicion = pos;
        LN = new Marca(false, Grosor.Fino);
        LS = new Marca(false, Grosor.Fino);
        LE = new Marca(false, Grosor.Fino);
        LO = new Marca(false, Grosor.Fino);
        FV = new Marca(false, Grosor.Fino);
        FH = new Marca(false, Grosor.Fino);
        FD = new Marca(false, Grosor.Fino);
        FI = new Marca(false, Grosor.Fino);
        TL = new Marca(false, Grosor.Fino);
    }
}
