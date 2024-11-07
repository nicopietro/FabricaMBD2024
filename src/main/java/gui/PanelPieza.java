package gui;
import fabrica.*;
import fabrica.marcas.*;
import fabrica.Cuadro;
import javax.swing.*;
import java.awt.*;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.List;

/**
 * @author Nicolás Pietrocola
 * @author Andrés Amo Caballero
 * @author Álvaro Cabello Martín
 * @author Javier Osuna Titos
 * @version 1.0
 */

public class PanelPieza extends JPanel {
    private Pieza pieza;
    private static final Color cFresa = new Color(0,0,255);//Color.BLUE;//new Color(170, 121, 66);
    private static final Color cLija = new Color(255,0,0);//Color.RED;
    private static final Color cPieza = new Color(245,196,109);
    private static final Color cTaladro = new Color(255,255,255);
    public void show(Pieza p) {
        pieza = p;
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (pieza ==  null) return;
        int OFFSET = 100;
        int wTotal = this.getWidth();
        int hTotal = this.getHeight();
        int w3 = (wTotal-2*OFFSET) /3;
        int h3 = (hTotal-2*OFFSET)/3;
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0,0,wTotal,hTotal);
        g2d.setColor(cPieza);
        g2d.fillRect(OFFSET,OFFSET,w3*3,h3*3);
        String piezaStr = pieza.toString();
        for (int fila = 0; fila < 3; fila++)
            for (int columna = 0; columna < 3; columna++) {
                int posX = OFFSET + columna * w3;
                int posY = OFFSET + fila  * h3;
                int centroX = OFFSET + columna*w3 + w3/2;
                int centroY = OFFSET + fila*h3 + h3/2;
                String cc = extrae(piezaStr, fila, columna);
                List<Integer> posiciones = List.of(12,15,18,21,0,3,6,9,24);
                for (int pos : posiciones) {
                    String comando = cc.substring(pos, pos + 2);
                    if (!comando.equals("  ")) {
                        int num = Integer.parseInt(cc.charAt(pos + 2) + "");
                        switch (comando) {
                            case "FH":
                                if (num > 0) {
                                    g2d.setColor(cFresa);
                                    g2d.fillRect(posX, posY + h3 / 2 - num * 7, w3, 14 * num);
                                }
                                break;
                            case "FV":
                                if (num > 0) {
                                    g2d.setColor(cFresa);
                                    g2d.fillRect(posX + w3 / 2 - num * 7, posY, 14 * num, h3);
                                }
                                break;
                            case "FI":
                                if (num > 0) {
                                    g2d.setColor(cFresa);
                                    int[] px = {posX, posX + num * 10, posX + w3, posX + w3, posX + w3 - num * 10, posX};
                                    int[] py = {posY, posY, posY + h3 - num * 10, posY + h3, posY + h3, posY + num * 10};
                                    g2d.fillPolygon(new Polygon(px, py, 6));
                                }
                                break;
                            case "FD":
                                if (num > 0) {
                                    g2d.setColor(cFresa);
                                    int[] px = {posX + w3, posX + w3, posX + num * 10, posX, posX, posX + w3 - num * 10};
                                    int[] py = {posY, posY + num * 10, posY + h3, posY + h3, posY + h3 - num * 10, posY};
                                    g2d.fillPolygon(new Polygon(px, py, 6));
                                }
                                break;
                            case "LN":
                                if (num > 0) {
                                    g2d.setColor(cLija);
                                    int[] px = {centroX, centroX - num * 11, centroX + num * 11};
                                    int[] py = {centroY, centroY + num * 22, centroY + num * 22};
                                    g2d.fillPolygon(new Polygon(px, py, 3));
                                }
                                break;
                            case "LE":
                                if (num > 0) {
                                    g2d.setColor(cLija);
                                    int[] px = {centroX, centroX - num * 22, centroX - num * 22};
                                    int[] py = {centroY, centroY - num * 11, centroY + num * 11};
                                    g2d.fillPolygon(new Polygon(px, py, 3));
                                }
                                break;
                            case "LS":
                                if (num > 0) {
                                    g2d.setColor(cLija);
                                    int[] px = {centroX, centroX - num * 11, centroX + num * 11};
                                    int[] py = {centroY, centroY - num * 22, centroY - num * 22};
                                    g2d.fillPolygon(new Polygon(px, py, 3));
                                }
                                break;
                            case "LO":
                                if (num > 0) {
                                    g2d.setColor(cLija);
                                    int[] px = {centroX, centroX + num * 22, centroX + num * 22};
                                    int[] py = {centroY, centroY - num * 11, centroY + num * 11};
                                    g2d.fillPolygon(new Polygon(px, py, 3));
                                }
                                break;
                            case "TL":
                                if (num > 0) {
                                    g2d.setColor(cTaladro);
                                    g2d.fillOval(posX + w3 / 2 - num * 10, posY + h3 / 2 - num * 10, 20 * num, 20 * num);
                                }
                                break;
                            default:
                                throw new RuntimeException("Marca no reconocida " + comando);
                        }
                    }
                }
                g2d.setColor(Color.lightGray);
                g2d.draw3DRect(posX,posY,w3,h3,true);
            }
    }
/*
    @Override
    public void paintComponent2(Graphics g) {
        super.paintComponent(g);
        if (pieza ==  null) return;
        String piezaStr = pieza.toString();
        int OFFSET = 100;
        int wTotal = this.getWidth();
        int hTotal = this.getHeight();
        int w3 = (wTotal-2*OFFSET) /3;
        int h3 = (hTotal-2*OFFSET)/3;
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0,0,wTotal,hTotal);
        g2d.setColor(cPieza);
        g2d.fillRect(OFFSET,OFFSET,w3*3,h3*3);
        for (int fila = 0; fila < 3; fila++)
            for (int columna = 0; columna < 3; columna++) {
                int posX = OFFSET + columna * w3;
                int posY = OFFSET + fila  * h3;
                String c = extrae(piezaStr,fila, columna);

                switch(c) {
                    case Cuadro(LijaN(int rN), LijaE(int rE), LijaS(int rS), LijaO(int rO), FresaV(int av), FresaH(int ah), FresaI(int ai), FresaD(int ad), Taladro(int at)):
                        if (ah > 0) {
                            g2d.setColor(cFresa);
                            g2d.fillRect(posX, posY + h3 / 2 - ah * 7, w3, 14 * ah);
                        }
                        if (av > 0) {
                            g2d.setColor(cFresa);
                            g2d.fillRect(posX + w3 / 2 - av * 7, posY, 14 * av, h3);
                        }
                        if (ai > 0) {
                            g2d.setColor(cFresa);
                            int [] px = {posX, posX+ai*10, posX+w3, posX+w3, posX+w3-ai*10, posX};
                            int [] py = {posY, posY, posY+h3-ai*10, posY+h3,posY+h3, posY+ai*10};
                            g2d.fillPolygon(new Polygon(px,py,6));
                        }
                        if (ad > 0) {
                            g2d.setColor(cFresa);
                            int [] px = {posX+w3, posX+w3, posX+ad*10, posX, posX, posX+w3-ad*10};
                            int [] py = {posY, posY+ad*10, posY+h3, posY+h3, posY+h3-ad*10, posY};
                            g2d.fillPolygon(new Polygon(px,py,6));
                        }
                        int centroX = OFFSET + columna*w3 + w3/2;
                        int centroY = OFFSET + fila*h3 + h3/2;
                        if (rN > 0) {
                            g2d.setColor(cLija);
                            int [] px = {centroX, centroX-rN*11, centroX+rN*11};
                            int [] py = {centroY, centroY+rN*22, centroY+rN*22};
                            g2d.fillPolygon(new Polygon(px,py,3));
                        }
                        if (rE > 0) {
                            g2d.setColor(cLija);
                            int [] px = {centroX, centroX-rE*22, centroX-rE*22};
                            int [] py = {centroY, centroY-rE*11, centroY+rE*11};
                            g2d.fillPolygon(new Polygon(px,py,3));
                        }
                        if (rS > 0) {
                            g2d.setColor(cLija);
                            int [] px = {centroX, centroX-rS*11, centroX+rS*11};
                            int [] py = {centroY, centroY-rS*22, centroY-rS*22};
                            g2d.fillPolygon(new Polygon(px,py,3));
                        }
                        if (rO > 0) {
                            g2d.setColor(cLija);
                            int [] px = {centroX, centroX+rO*22, centroX+rO*22};
                            int [] py = {centroY, centroY-rO*11, centroY+rO*11};
                            g2d.fillPolygon(new Polygon(px,py,3));
                        }

                        if (at > 0) {
                            g2d.setColor(cTaladro);
                            g2d.fillOval(posX+w3/2-at*10, posY+h3/2-at*10,20*at,20*at);
                        }
                }
                g2d.setColor(Color.lightGray);
                g2d.draw3DRect(posX,posY,w3,h3,true);
            }
    }
*/
    private String extrae(String pS, int fila, int columna) {
        Scanner sc = new Scanner(pS);
        sc.useDelimiter("[|\n]+");
        int num = fila*3+columna;
        try {
            while (num > 0) {
                sc.next();
                num--;
            }
            return sc.next();
        } catch (NoSuchElementException e) {
            throw new RuntimeException("Pieza mal construida "+ pieza);
        }
    }
}


