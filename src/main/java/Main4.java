import fabrica.Fabrica;
import fabrica.Pieza;
import gui.Gui;

public class Main4 {
    public static void main(String[] args) {
        Fabrica f = Fabrica.aleatoria(20);
        Pieza p = new Pieza();
        Gui gui = new Gui(f, p);
        gui.muestra();
        System.out.println(p);
    }

}
