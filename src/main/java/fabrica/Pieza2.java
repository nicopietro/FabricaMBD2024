package fabrica;

import java.util.List;

public class Pieza2 {
    private record Cuadro(
            Posicion posicion,
            boolean eLN, Grosor LN,
            boolean eLS, Grosor LS,
            boolean eLE, Grosor LE,
            boolean eLO, Grosor LO,
            boolean eFV, Grosor FV,
            boolean eFH, Grosor FH,
            boolean eFD, Grosor FD,
            boolean eFI, Grosor FI,
            boolean eTL, Grosor TL
    ) {};
    private List<Cuadro> pieza;
    private Posicion posicion;

    public Pieza2() {
        for (Posicion pos : Posicion.values()) {
            pieza.add(new Cuadro(
                    pos,
                    false, Grosor.Fino,
                    false, Grosor.Fino,
                    false, Grosor.Fino,
                    false, Grosor.Fino,
                    false, Grosor.Fino,
                    false, Grosor.Fino,
                    false, Grosor.Fino,
                    false, Grosor.Fino,
                    false, Grosor.Fino));
        }

    }
}
