package fabrica;

import fabrica.maquinas.*;
import fabrica.marcas.*;
import fabrica.posiciones.Posicion;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Fabrica {
    private List<Maquina> maquinas;
    private Pieza pieza;
    private static Random alea = new Random();

    /// Lista del ejemplo - Si la quieren sacar por favor comentar ya que se puede reutilizar en el main!
    public Fabrica() {
        pieza = new Pieza();
        maquinas = new ArrayList<>();
//        maquinas.add(new Fresadora(Posicion.IzSu, OrFresa.Vertical, Grosor.Medio));
//        maquinas.add(new Fresadora(Posicion.IzCe, OrFresa.Diagonal, Grosor.Medio));
//        maquinas.add(new Fresadora(Posicion.IzIn, OrFresa.Vertical,Grosor.Medio));
//        maquinas.add(new Rotadora(Sentido.Antihorario));
//        maquinas.add(new Lijadora(Posicion.CeSu, OrLija.Norte,Grosor.Fino));
//        maquinas.add(new Fresadora(Posicion.CeSu,OrFresa.Diagonal, Grosor.Grueso));
//        maquinas.add(new Rotadora(Sentido.Antihorario));
//        maquinas.add(new Fresadora(Posicion.CeCe, OrFresa.Diagonal,Grosor.Medio));
//        maquinas.add(new Taladradora(Posicion.IzCe,Grosor.Medio));
//        maquinas.add(new Rotadora(Sentido.Antihorario));
//        maquinas.add(new Fresadora(Posicion.CeSu, OrFresa.Vertical, Grosor.Fino));
//        maquinas.add(new Fresadora(Posicion.IzIn, OrFresa.Vertical, Grosor.Medio));
//        maquinas.add(new Rotadora(Sentido.Horario));
//        maquinas.add(new Lijadora(Posicion.IzCe, OrLija.Sur,Grosor.Grueso));
//        maquinas.add(new Fresadora(Posicion.CeCe, OrFresa.Diagonal, Grosor.Fino));
//        maquinas.add(new Lijadora(Posicion.IzSu, OrLija.Norte,Grosor.Medio));
//        maquinas.add(new Fresadora(Posicion.IzCe, OrFresa.Vertical, Grosor.Medio));
//        maquinas.add(new Fresadora(Posicion.IzSu,OrFresa.Diagonal, Grosor.Grueso));
    }

    //REVISAR, se ha cambiado el agrega
    public Fabrica(List<Maquina> maquinas) {
        pieza = new Pieza();
        for (Maquina m : maquinas) {
            this.agrega(m);
        }
    }

    public List<Maquina> maquinas() {
        return maquinas;
    }

    /// Crea una fabrica compuesta por maquinas que se generan aleatoriamente
    ///
    /// @param n Es el numero de maquinas que se quiere generar
    public static Fabrica aleatoria(int n) {
        Fabrica fabrica = new Fabrica();

        for (int i = 0; i < n; i++) {
            Maquina nuevaMaquina;

            do {
                nuevaMaquina = crearMaquinaAleatoria();
                } while(!fabrica.agrega(nuevaMaquina));
        }
        return fabrica;
    }

    ///Crea una maquina aleatoria
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

    /// Genera una posicion valida aleatoria
    private static Posicion generaPosicionAleatoria() {
        Posicion[] posiciones = {Posicion.IzSu, Posicion.IzCe, Posicion.IzIn, Posicion.CeSu, Posicion.CeCe};
        return posiciones[alea.nextInt(posiciones.length)];
    }

    /// Genera un grosor valido aleatorio
    private static Grosor generaGrosorAleatorio() {
        Grosor[] grosores = {Grosor.Fino, Grosor.Medio, Grosor.Grueso};
        return grosores[alea.nextInt(grosores.length)];
    }

    /// Genera una orientacion de la Fresadora valida aleatoria
    private static OrFresa generaOrientacionFresadoraAleatorio() {
        OrFresa[] orientacionFresadora = {OrFresa.Diagonal, OrFresa.Vertical};
        return orientacionFresadora[alea.nextInt(orientacionFresadora.length)];
    }

    /// Genera una orientacion de la Lijadora aleatoria
    private static OrLija generaOrientacionLijadoraAleatorio() {
        OrLija[] orientacionLijadora = {OrLija.Norte, OrLija.Sur};
        return orientacionLijadora[alea.nextInt(orientacionLijadora.length)];
    }

    /// Genera un sentido aleatorio
    private static Sentido generaSentidoAleatorio() {
        Sentido[] sentidos = Sentido.values();
        return sentidos[alea.nextInt(sentidos.length)];
    }

    /// Cada fabrica.maquina actua en el orden de la lista en la pieza
    public void ejecutar() {
        for (Maquina m : maquinas) {
            m.actua(pieza);
        }
    }

    @Override
    public String toString() {
        return pieza.toString();
    }


    /// Permite agregar una máquina a la fábrica si es una rotadora al principio no la agrega
    /// ya que no influye tampoco permite agregar dos rotadoras en sentidos contrarios
    ///
    /// @param m Máquina que se quiere añadir
    /* public void agrega(Maquina m){

        if (!(maquinas.isEmpty() && m instanceof Rotadora)){
            if (maquinas.isEmpty())
                maquinas.add(m);
            else if(maquinas.get(maquinas.size()-1) instanceof Rotadora  && m instanceof Rotadora){
                if (((Rotadora) maquinas.get(maquinas.size()-1)).getSentido() == ((Rotadora) m).getSentido())
                    maquinas.add(m);
            }else maquinas.add(m);
        } */
    public boolean agrega(Maquina m) {

        if ((maquinas.isEmpty() && m instanceof Rotadora))
            return false;

        if (!maquinas.isEmpty() &&
                (maquinas.get(maquinas.size() - 1) instanceof Rotadora) &&
                (m instanceof Rotadora) &&
                !(((Rotadora) maquinas.get(maquinas.size() - 1)).getSentido() == ((Rotadora) m).getSentido()))
            return false;

        maquinas.add(m);
        return true;
    }

}