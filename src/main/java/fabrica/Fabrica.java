package fabrica;

import fabrica.maquinas.*;
import fabrica.marcas.*;
import fabrica.posiciones.Posicion;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Nicolás Pietrocola
 * @author Andrés Amo Caballero
 * @author Álvaro Cabello Martín
 * @author Javier Osuna Titos
 * @version 1.0
 */

public class Fabrica {

    private static Random alea = new Random();
    private List<Maquina> maquinas;
    private Pieza pieza;

    /// Crea un objeto de la clase Fabrica con una lista de máquinas vacia y una pieza sin marcas.
    public Fabrica() {
        pieza = new Pieza();
        maquinas = new ArrayList<>();
    }

    /// Crea un objeto de la clase Fabrica a partir de una lista de Máquinas.
    /// @param maquinas Lista de maquinas que compondrá la fabrica.
    public Fabrica(List<Maquina> maquinas) {
        pieza = new Pieza();
        for (Maquina m : maquinas) {
            this.agrega(m);
        }
    }

    /// @return Lista de maquinas contenidas en la fabrica.
    public List<Maquina> maquinas() {
        return maquinas;
    }

    /// Crea una fabrica compuesta por maquinas que se generan aleatoriamente.
    /// @param n Cantidad de maquinas que se incluran en la fabrica.
    public static Fabrica aleatoria(int n) {
        Fabrica fabrica = new Fabrica();
        for (int i = 0; i < n; i++) {
            Maquina nuevaMaquina;
            do {
                nuevaMaquina = crearMaquinaAleatoria();
                } while (!fabrica.agrega(nuevaMaquina));
        }
        return fabrica;
    }

    ///Crea una maquina aleatoria.
    private static Maquina crearMaquinaAleatoria() {
        int tipo = alea.nextInt(4);
        return switch (tipo) {
            case 0 -> new Fresadora(generaPosicionAleatoria(),
                    generaOrientacionFresadoraAleatorio(),
                    generaGrosorAleatorio());
            case 1 -> new Lijadora(generaPosicionAleatoria(),
                    generaOrientacionLijadoraAleatorio(),
                    generaGrosorAleatorio());
            case 2 -> new Taladradora(generaPosicionAleatoria(),
                    generaGrosorAleatorio());
            case 3 -> new Rotadora(generaSentidoAleatorio());
            default -> throw new IllegalArgumentException("Tipo de maquina no valido");
        };
    }

    /// Devuelve una posicion aleatoria válida.
    private static Posicion generaPosicionAleatoria() {
        Posicion[] posiciones = {Posicion.IzSu, Posicion.IzCe, Posicion.IzIn, Posicion.CeSu, Posicion.CeCe};
        return posiciones[alea.nextInt(posiciones.length)];
    }

    /// Devuelve un grosor aleatorio válida.
    private static Grosor generaGrosorAleatorio() {
        Grosor[] grosores = {Grosor.Fino, Grosor.Medio, Grosor.Grueso};
        return grosores[alea.nextInt(grosores.length)];
    }

    /// Devuelve una orientacion aleatoria válida para la Fresadora.
    private static OrFresa generaOrientacionFresadoraAleatorio() {
        OrFresa[] orientacionFresadora = {OrFresa.Diagonal, OrFresa.Vertical};
        return orientacionFresadora[alea.nextInt(orientacionFresadora.length)];
    }

    /// Devuelve una orientacion aleatoria válida para la Lijadora.
    private static OrLija generaOrientacionLijadoraAleatorio() {
        OrLija[] orientacionLijadora = {OrLija.Norte, OrLija.Sur};
        return orientacionLijadora[alea.nextInt(orientacionLijadora.length)];
    }

    /// Devuelve un sentido de giro aleatoria válido para la Rotadora.
    private static Sentido generaSentidoAleatorio() {
        Sentido[] sentidos = Sentido.values();
        return sentidos[alea.nextInt(sentidos.length)];
    }

    /// Cada máquina incluida en la fabrica actua en el orden en que se encuentra en la lista de máquinas.
    public void ejecutar() {
        for (Maquina m : maquinas) {
            m.actua(pieza);
        }
    }

    @Override
    public String toString() {
        return pieza.toString();
    }

    /// Verifica si una maquina es válida para ser agregada a la fabrica.
    /// Se considera que una máquina no es válida si:
    /// - La primer máquina de la lista es una rotadora
    /// - Si se intenta agregar una rotadora, pero la máquina anterior también es una rotadora pero con sentido contrario.
    /// @param m Máquina que se quiere añadir.
    /// @return {@code true} si la máquina es válida para ser añadida,
    /// `false` si la máquina no cumple con los criterios de válidez.
    public boolean agrega(Maquina m) {
        if (m instanceof Rotadora)
            if (maquinas.isEmpty())
                return false;
            else if ((maquinas.getLast() instanceof Rotadora)
                    && !(((Rotadora) maquinas.getLast()).getSentido() == ((Rotadora) m).getSentido()))
                return false;
        maquinas.add(m);
        return true;
    }

}