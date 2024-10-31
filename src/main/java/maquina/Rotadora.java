package maquina;

import fabrica.*;

public class Rotadora implements Maquina {

    private Sentido sentido;

    public Rotadora(Sentido sentido) {
        this.sentido = sentido;
    }

    @Override
    public void actua(Pieza pieza) {
        for (Posicion pos : Posicion.values()) {
            Cuadro c = pieza.getCuadro(pos);
            c.rotar(sentido);
        }
    }
}
