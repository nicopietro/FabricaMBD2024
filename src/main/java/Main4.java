import fabrica.Fabrica;
import fabrica.Pieza;
import gui.Gui;

/**
 * @author Nicolás Pietrocola
 * @author Andrés Amo Caballero
 * @author Álvaro Cabello Martín
 * @author Javier Osuna Titos
 * @version 1.0
 */

public class Main4 {
    public static void main(String[] args) {
        Fabrica f = Fabrica.aleatoria(20);
        Pieza p = new Pieza();
        Gui gui = new Gui(f, p);
        gui.muestra();
        System.out.println(p);
    }

}
