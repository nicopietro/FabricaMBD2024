//import fabrica.Fabrica;
//import fabrica.Pieza;
//import fabrica.maquinas.Fresadora;
//import fabrica.maquinas.Lijadora;
//import fabrica.maquinas.Rotadora;
//import fabrica.maquinas.Taladradora;
//import fabrica.posiciones.*;
//import fabrica.marcas.*;
//import gui.Gui;
//
//public class Main3 {
//    public static void main(String[] args) {
//        Fabrica f = new Fabrica();
//        f.agrega(new Fresadora(Posicion.IzCe, OrFresa.Diagonal, Grosor.Fino ));
//        f.agrega(new Fresadora(Posicion.IzCe, OrFresa.Vertical, Grosor.Grueso ));
//        f.agrega(new Fresadora(Posicion.CeSu, OrFresa.Diagonal, Grosor.Medio ));
//
//        f.agrega(new Lijadora(Posicion.IzCe, OrLija.Norte, Grosor.Medio));
//        f.agrega(new Lijadora(Posicion.IzSu, OrLija.Sur, Grosor.Grueso));
//        f.agrega(new Lijadora(Posicion.CeCe, OrLija.Norte, Grosor.Fino));
//        f.agrega(new Taladradora(Posicion.CeCe,Grosor.Grueso));
//        f.agrega(new Taladradora(Posicion.IzCe,Grosor.Fino));
//        f.agrega(new Rotadora(Sentido.Horario));
//
///*
//        f.agrega(new Taladradora(Posicion.CeCe,Grosor.Grueso));
//        f.agrega(new Lijadora(Posicion.CeSu, OrLija.Norte,Grosor.Fino));
//        f.agrega(new Taladradora(Posicion.CeSu,Grosor.Grueso));
//
//        f.agrega(new Rotadora(Sentido.Horario));
//        f.agrega(new Fresadora(Posicion.IzCe, OrFresa.Diagonal, 1 ));
//        f.agrega(new Fresadora(Posicion.IzCe, OrFresa.Vertical, 3 ));
//        f.agrega(new Rotadora(Sentido.Horario));
//        f.agrega(new Fresadora(Posicion.CeSu, OrFresa.Diagonal, 1 ));
//        f.agrega(new Fresadora(Posicion.CeSu, OrFresa.Vertical, 3 ));
//         */
//        Pieza p = new Pieza();
//        Gui gui = new Gui(f, p);
//        gui.muestra();
//        System.out.println(p);
//    }
//}
