package fabrica;

import fabrica.maquinas.*;
import fabrica.marcas.*;
import fabrica.posiciones.Posicion;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Fabrica {
    // Random para el metodo Fabrica aleatoria()
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

    public Fabrica(List<Maquina> maquinas) {
        pieza = new Pieza();
        for (Maquina m: maquinas){
            this.agrega(m);
        }
    }

    public List<Maquina> maquinas() {
        return maquinas;
    }

    public Fabrica aleatoria(int n) {
        Fabrica fabrica = new Fabrica();

        for (int i = 0; i < n; i++) {
            Maquina nuevaMaquina;
            Posicion pos = generaPosicionAleatoria();

            int tipo = alea.nextInt(4);

            switch (tipo) {
                case 0:
                    nuevaMaquina = new Fresadora(generaPosicionAleatoria(),
                            generaOrientacionFresadoraAleatorio(),
                            generaGrosorAleatorio());
                    break;
                case 1:
                    nuevaMaquina = new Lijadora(generaPosicionAleatoria(),
                            generaOrientacionLijadoraAleatorio(),
                            generaGrosorAleatorio());
                    break;
                case 2:
                    nuevaMaquina = new Taladradora(generaPosicionAleatoria(),
                            generaGrosorAleatorio());
                    break;
                case 3:
                    nuevaMaquina = new Rotadora(generaSentidoAleatorio());
                    break;
                default: nuevaMaquina = null;
            }


            if (nuevaMaquina != null)
                fabrica.agrega(nuevaMaquina);

        }
        return fabrica;
    }

    private Posicion generaPosicionAleatoria(){
        return null;
    }

    private Grosor generaGrosorAleatorio(){
        return null;
    }

    private OrFresa generaOrientacionFresadoraAleatorio(){
        return null;
    }

    private OrLija generaOrientacionLijadoraAleatorio(){
        return null;
    }

    private Sentido generaSentidoAleatorio(){
        return null;
    }

    /// Cada fabrica.maquina actua en el orden de la lista en la pieza
    public void ejecutar() {
        for (Maquina m : maquinas) {
            m.actua(pieza);
        }
    }
    @Override
    public String toString(){
        return pieza.toString();
    }


    /// Permite agregar una máquina a la fábrica si es una rotadora al principio no la agrega
    /// ya que no influye tampoco permite agregar dos rotadoras en sentidos contrarios
    ///
    /// @param m Máquina que se quiere añadir
    public void agrega(Maquina m){
        if (!(maquinas.isEmpty() && m instanceof Rotadora)){
            if (maquinas.isEmpty())
                maquinas.add(m);
            else if(maquinas.get(maquinas.size()-1) instanceof Rotadora  && m instanceof Rotadora){
                if (((Rotadora) maquinas.get(maquinas.size()-1)).getSentido() == ((Rotadora) m).getSentido())
                    maquinas.add(m);
            }else maquinas.add(m);
        }
    }
}
