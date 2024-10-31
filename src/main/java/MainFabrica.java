import fabrica.*;
import maquina.*;

import java.util.ArrayList;
import java.util.List;

public class MainFabrica {
    public static void main(String[] args) {
        Fabrica fab = new Fabrica(List.of(new Taladradora(Posicion.IzCe, Grosor.Medio),new Taladradora(Posicion.IzCe, Grosor.Grueso)) );
        fab.ejecutar();
        System.out.println(fab);
    }
}