package fabrica;

import fabrica.marcas.Grosor;
import fabrica.posiciones.Posicion;
import fabrica.marcas.Sentido;

import static fabrica.marcas.Sentido.*;
import static fabrica.marcas.Grosor.*;
import static fabrica.posiciones.Posicion.*;

public class Cuadro {

    private Posicion posicion;
    private Grosor LN, LS, LE, LO, FV, FH, FD, FI, TL;

    /// Crea un nuevo cuadro de la pieza vacío.
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


    public void rotar(Sentido sentido) {
        rotarPosicion(sentido);
        rotarMarcas(sentido);
    }

    /// REVISAR!!!!
    /// Cambiar por setters que para eso los hice -> CAMBIADO YA
    private void rotarMarcas(Sentido sentido) {
        Grosor gAux;
        // Lija
        if (sentido == Antihorario)
        {
            gAux = LN;
            setLN(LE);
            setLE(LS);
            setLS(LO);
            setLO(gAux);
        }else {
            gAux = LN;
            setLN(LO);
            setLO(LS);
            setLS(LE);
            setLE(gAux);
        }
        // Independientemente al sentido ?????????
        // Fresadora
        gAux = FV;
        setFV(FH);
        setFH(gAux);
        gAux = FD;
        setFD(FI);
        setFI(gAux);
    }


    /// REVISAR!!!!
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
    @Override
    public String toString(){
        String resultado = "|";
        if(getLN()!=SinGrosor) resultado+="LN"+grosorAString(getLN());
        else resultado+="   ";
        if(getLE()!=SinGrosor) resultado+="LE"+grosorAString(getLE());
        else resultado+="   ";
        if(getLS()!=SinGrosor) resultado+="LS"+grosorAString(getLS());
        else resultado+="   ";
        if(getLO()!=SinGrosor) resultado+="LO"+grosorAString(getLO());
        else resultado+="   ";
        if(getFV()!=SinGrosor) resultado+="FV"+grosorAString(getFV());
        else resultado+="   ";
        if(getFH()!=SinGrosor) resultado+="FH"+grosorAString(getFH());
        else resultado+="   ";
        if(getFI()!=SinGrosor) resultado+="FI"+grosorAString(getFI());
        else resultado+="   ";
        if(getFD()!=SinGrosor) resultado+="FD"+grosorAString(getFD());
        else resultado+="   ";
        if(getTL()!=SinGrosor) resultado+="TL"+grosorAString(getTL());
        else resultado+="   ";
        return resultado;
    }
    public String grosorAString(Grosor g){
        if (Fino == g)return "1";
        else if (Medio == g)return "2";
        else if(Grueso == g)return "3";
        return "-1";
    }

    // Posicion
    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    // Setters
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
    public Grosor getLN() {
        return LN;
    }

    public Grosor getLS() {
        return LS;
    }

    public Grosor getLE() {
        return LE;
    }

    public Grosor getLO() {
        return LO;
    }

    public Grosor getFV() {
        return FV;
    }

    public Grosor getFH() {
        return FH;
    }

    public Grosor getFD() {
        return FD;
    }

    public Grosor getFI() {
        return FI;
    }

    public Grosor getTL() {
        return TL;
    }
}
