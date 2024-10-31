package gui;
import fabrica.maquinas.Maquina;
import fabrica.*;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Gui {
    JFrame ventana;
    Pieza pieza;
    Fabrica fabrica;
    PanelPieza panel;
    JList<Maquina> lista;
    public Gui(Fabrica f,Pieza p) {
        fabrica = f;
        pieza = p;
        ventana = new JFrame("Pieza");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new PanelPieza();
        panel.setOpaque(true);
        panel.setPreferredSize(new Dimension(600,600));
        panel.setMaximumSize(new Dimension(600,600));
        panel.setMinimumSize(new Dimension(600,600));
        JPanel total = new JPanel();
        total.setLayout(new BoxLayout(total, BoxLayout.PAGE_AXIS));
        total.add(panel);
        lista = new JList<>(fabrica.maquinas().toArray(new Maquina[0]));
        //lista.setOpaque(true);
        lista.setFont( new Font("Monospaced", Font.BOLD, 18));
        total.add(new JScrollPane(lista));
        //total.setOpaque(false);
        ventana.setContentPane(total);
        ventana.pack();
        ventana.setVisible(true);
        panel.show(p);
    }

    public void muestra() {
        Iterator<Maquina> it = fabrica.maquinas().iterator();
        int pos = 0;
        while (it.hasNext()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Maquina m = it.next();
            lista.setSelectedIndex(pos);
            m.actua(pieza);
            ventana.repaint();
            pos++;
        }
    }
}
