package br.ufrn.dimap.interfaceGrafica;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.BasicStroke;
import java.awt.Image;
import java.awt.geom.Line2D;
import java.net.URL;
import java.util.LinkedList;
import javax.imageio.ImageIO;

public class PainelAux extends javax.swing.JPanel {

    public LinkedList<Integer> x1;
    public LinkedList<Integer> y1;
    public LinkedList<Integer> x2;
    public LinkedList<Integer> y2;
    public LinkedList<Color> corAresta;

    /** Creates new form PainelAux */
    public PainelAux() {
        initComponents();
        x1 = new LinkedList<Integer>();
        y1 = new LinkedList<Integer>();
        x2 = new LinkedList<Integer>();
        y2 = new LinkedList<Integer>();
        corAresta = new LinkedList<Color>();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);        
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setStroke(new BasicStroke(4));
        for (int i = 0; i < x1.size(); i++) {
            g2d.setColor(corAresta.get(i));
            g2d.draw(new Line2D.Double(x1.get(i), y1.get(i), x2.get(i), y2.get(i)));
        }        
    }

    public void addAresta(int a, int b, int c, int d, Color cor, Graphics g) {
        x1.add(a);
        y1.add(b);
        x2.add(c);
        y2.add(d);
        corAresta.add(cor);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
