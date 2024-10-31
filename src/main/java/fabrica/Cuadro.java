package fabrica;

public class Cuadro {
    private Posicion posicion;
    private Grosor LN, LS, LE, LO, FV, FH, FD, FI, TL;

    public Cuadro(Posicion pos) {
        posicion = pos;
        LN = Grosor.SinGrosor;
        LS = Grosor.SinGrosor;
        LE = Grosor.SinGrosor;
        LO = Grosor.SinGrosor;
        FV = Grosor.SinGrosor;
        FH = Grosor.SinGrosor;
        FD = Grosor.SinGrosor;
        FI = Grosor.SinGrosor;
        TL = Grosor.SinGrosor;
    }


    public void rotar(Sentido sentido) {
        rotarPosicion(sentido);
        rotarMarcas(sentido);
    }

    /// REVISAR!!!!
    /// Cambiar por setters que para eso los hice
    private void rotarMarcas(Sentido sentido) {
        Grosor gAux = Grosor.SinGrosor;
        // Las lijas giran de forma dependiente al sentido
        if (sentido == Sentido.Horario)
        {
            gAux = LN;
            LN = LE;
            LE = LS;
            LS = LO;
            LO = gAux;
        }
        else {
            gAux = LN;
            LN = LO;
            LO = LS;
            LS = LE;
            LO = gAux;
        }
        // Todo lo demas gira independientemente al sentido
        gAux = FV;
        FV = FH;
        FH = gAux;
        gAux = FD;
        FD = FI;
        FI = gAux;
    }


    /// REVISAR!!!!
    private void rotarPosicion(Sentido sentido) {
        if (sentido == Sentido.Horario)
            switch (posicion) {
                case Posicion.IzSu -> setPosicion(Posicion.DeSu);
                case Posicion.CeSu -> setPosicion(Posicion.DeCe);
                case Posicion.DeSu -> setPosicion(Posicion.DeIn);
                case Posicion.DeCe -> setPosicion(Posicion.CeIn);
                case Posicion.DeIn -> setPosicion(Posicion.IzIn);
                case Posicion.CeIn -> setPosicion(Posicion.IzCe);
                case Posicion.IzIn -> setPosicion(Posicion.IzSu);
                case Posicion.IzCe -> setPosicion(Posicion.CeSu);
            }
        else
            switch (posicion) {
                case Posicion.IzSu -> setPosicion(Posicion.IzIn);
                case Posicion.CeSu -> setPosicion(Posicion.IzCe);
                case Posicion.DeSu -> setPosicion(Posicion.IzSu);
                case Posicion.DeCe -> setPosicion(Posicion.CeSu);
                case Posicion.DeIn -> setPosicion(Posicion.DeSu);
                case Posicion.CeIn -> setPosicion(Posicion.DeCe);
                case Posicion.IzIn -> setPosicion(Posicion.DeIn);
                case Posicion.IzCe -> setPosicion(Posicion.CeIn);
            }
    }
    @Override
    public String toString(){
        String resultado = "|";
        if(getLN()!=Grosor.SinGrosor) resultado+="LN"+grosorAString(getLN());
        else resultado+="   ";
        if(getLE()!=Grosor.SinGrosor) resultado+="LE"+grosorAString(getLN());
        else resultado+="   ";
        if(getLS()!=Grosor.SinGrosor) resultado+="LS"+grosorAString(getLN());
        else resultado+="   ";
        if(getLO()!=Grosor.SinGrosor) resultado+="LO"+grosorAString(getLN());
        else resultado+="   ";
        if(getFV()!=Grosor.SinGrosor) resultado+="FV"+grosorAString(getLN());
        else resultado+="   ";
        if(getFH()!=Grosor.SinGrosor) resultado+="FH"+grosorAString(getLN());
        else resultado+="   ";
        if(getFI()!=Grosor.SinGrosor) resultado+="FI"+grosorAString(getLN());
        else resultado+="   ";
        if(getFD()!=Grosor.SinGrosor) resultado+="FD"+grosorAString(getLN());
        else resultado+="   ";
        if(getTL()!=Grosor.SinGrosor) resultado+="TL"+grosorAString(getLN());
        else resultado+="   ";
        return resultado;
    }
    public String grosorAString(Grosor g){
        if (Grosor.Fino == g)return "1";
        else if (Grosor.Medio == g)return "2";
        else return "3";
    }

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

    public Posicion getPosicion() {
        return posicion;
    }

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
