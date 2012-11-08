/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufrn.dimap.interfaceGrafica.resources;

/**
 *
 * @author Anthonini
 */
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;


public class background extends javax.swing.JPanel {

    private BufferedImage imgFundo = null;

    public background( String imagem ) {
        inicializeImage( imagem );
    }

    public void setBackgroundImage( String imagem ){
        inicializeImage( imagem );
        repaint();
    }

    private void inicializeImage( String imagem ){
        try {
            imgFundo = ImageIO.read(new URL(getClass().getResource(imagem), imagem));
        } catch (Exception ex) {
        }
    }
    
    @Override
    public void paintComponent(Graphics g){
        try{            
            if(imgFundo != null){
                super.paintComponent(g);
                g.drawImage(imgFundo, 0, 0, this.getWidth(), this.getHeight(), this);
            }
        }
        catch(Exception e){
        }
    }
}
