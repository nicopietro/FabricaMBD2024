package fabrica;

import fabrica.marcas.Grosor;
import fabrica.marcas.Sentido;
import fabrica.posiciones.Posicion;

import static fabrica.marcas.Grosor.*;
import static fabrica.marcas.Sentido.*;
import static fabrica.posiciones.Posicion.*;

public class Cuadro {

    private Posicion posicion;
    private Grosor LN, LS, LE, LO, FV, FH, FD, FI, TL;

    /// Crea un nuevo cuadro de la pieza sin ninguna marca
    public Cuadro(Posicion pos) {
        posicion = pos;
        LN = SinGrosor;
        LS = SinGrosor;
        LE = SinGrosor;
        LO = SinGrosor;
        FV = SinGrosor;
        FH = SinGrosor;
        FD = SinGrosor;
        FI = SinGrosor;
        TL = SinGrosor;
    }

    /// Rota un cuadro, cambiando su posición y la orientación de todas sus marcas
    public void rotar(Sentido sentido) {
        rotarPosicion(sentido);
        rotarMarcas(sentido);
    }

    /// Cambia las orientaciones de las marcas en el cuadro según el sentido de rotación pasado como parámetro.
    /// Para una lija, por ejemplo, una lija norte pasa a ser una lija este si se gira en sentido horario
    /// Para la fresadora, independientemente del sentido, una marca vertical pasa a ser horizontal
    /// y una diagonal izquierda pasa a ser diagonal derecha
    /// @param sentido Sentido de rotación
    private void rotarMarcas(Sentido sentido) {
        Grosor gAux;
        // Lija
        if (sentido == Antihorario) {
            gAux = LN;
            setLN(LE);
            setLE(LS);
            setLS(LO);
            setLO(gAux);
        } else {
            gAux = LN;
            setLN(LO);
            setLO(LS);
            setLS(LE);
            setLE(gAux);
        }
        // Fresadora
        gAux = FV;
        setFV(FH);
        setFH(gAux);
        gAux = FD;
        setFD(FI);
        setFI(gAux);
    }


    /// Cambia la posición de la pieza según el sentido de rotación pasado como parámetro.
    /// @param sentido Sentido de rotación
    private void rotarPosicion(Sentido sentido) {
        if (sentido == Sentido.Horario)
            switch (posicion) {
                case IzSu -> setPosicion(DeSu);
                case CeSu -> setPosicion(DeCe);
                case DeSu -> setPosicion(DeIn);
                case DeCe -> setPosicion(CeIn);
                case DeIn -> setPosicion(IzIn);
                case CeIn -> setPosicion(IzCe);
                case IzIn -> setPosicion(IzSu);
                case IzCe -> setPosicion(CeSu);
            }
        else
            switch (posicion) {
                case IzSu -> setPosicion(IzIn);
                case CeSu -> setPosicion(IzCe);
                case DeSu -> setPosicion(IzSu);
                case DeCe -> setPosicion(CeSu);
                case DeIn -> setPosicion(DeSu);
                case CeIn -> setPosicion(DeCe);
                case IzIn -> setPosicion(DeIn);
                case IzCe -> setPosicion(CeIn);
            }
    }

    /// Redefinición del método toString que devuelve una representación de la pieza
    /// en 27 caracteres con todas sus marcas y grosores
    @Override
    public String toString() {
        StringBuilder resultado = new StringBuilder();
        if (getLN() != SinGrosor) resultado.append("LN").append(grosorAString(getLN()));
        else resultado.append("   ");
        if (getLE() != SinGrosor) resultado.append("LE").append(grosorAString(getLE()));
        else resultado.append("   ");
        if (getLS() != SinGrosor) resultado.append("LS").append(grosorAString(getLS()));
        else resultado.append("   ");
        if (getLO() != SinGrosor) resultado.append("LO").append(grosorAString(getLO()));
        else resultado.append("   ");
        if (getFV() != SinGrosor) resultado.append("FV").append(grosorAString(getFV()));
        else resultado.append("   ");
        if (getFH() != SinGrosor) resultado.append("FH").append(grosorAString(getFH()));
        else resultado.append("   ");
        if (getFI() != SinGrosor) resultado.append("FI").append(grosorAString(getFI()));
        else resultado.append("   ");
        if (getFD() != SinGrosor) resultado.append("FD").append(grosorAString(getFD()));
        else resultado.append("   ");
        if (getTL() != SinGrosor) resultado.append("TL").append(grosorAString(getTL()));
        else resultado.append("   ");
        return resultado.toString();
    }

    /// Método auxiliar para representar los grosores con enteros
    private String grosorAString(Grosor g) {
        if (Fino == g) return "1";
        else if (Medio == g) return "2";
        else if (Grueso == g) return "3";
        return "-1";
    }

    // Setters
    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }

    public void setLN(Grosor LN) {
        this.LN = LN;
    }

    public void setLS(Grosor LS) {
        this.LS = LS;
    }

    public void setLE(Grosor LE) {
        this.LE = LE;
    }

    public void setLO(Grosor LO) {
        this.LO = LO;
    }

    public void setFV(Grosor FV) {
        this.FV = FV;
    }

    public void setFH(Grosor FH) {
        this.FH = FH;
    }

    public void setFD(Grosor FD) {
        this.FD = FD;
    }

    public void setFI(Grosor FI) {
        this.FI = FI;
    }

    public void setTL(Grosor TL) {
        this.TL = TL;
    }

    // Getters
    public Posicion getPosicion() { return posicion; }

    public Grosor getLN() { return LN; }

    public Grosor getLS() { return LS;}

    public Grosor getLE() { return LE; }

    public Grosor getLO() { return LO; }

    public Grosor getFV() { return FV; }

    public Grosor getFH() { return FH; }

    public Grosor getFD() { return FD; }

    public Grosor getFI() { return FI; }

    public Grosor getTL() { return TL; }
}
