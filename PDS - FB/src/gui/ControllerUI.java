/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import grafo.GerarGrafo;

import java.awt.CardLayout;
import java.io.FileNotFoundException;
import java.io.IOException;

import tests.ParDeVerticesNaoExistenteException;


import model.IUsuario;

/**
 * @author larissa
 */
public class ControllerUI extends javax.swing.JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = -5454173901301185284L;
	private static CardLayout cl;
    @SuppressWarnings("unused")
	private static GerarGrafo gerarGrafo;
    
    private static InfoUsuario infoUsuario = new InfoUsuario();
    
    private static Facade facade = new Facade();
    
    public ControllerUI() {
        initComponents();
        cl = new CardLayout();
        cardPanel.setLayout(cl);
        cardPanel.add(new TelaLogin(), "telalogin");
        cardPanel.add(infoUsuario, "infousuario");
        cardPanel.add(new AmigosNome(), "amigosnome");
        cardPanel.add(new AmigosInterajo(), "amigosinterajo");
        cardPanel.add(new PaginaPalavraChave(), "paginapalavrachave");
        cardPanel.add(new PaginasRecomendadas(), "paginasrecomendadas");
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }

    public static void InfoUsuario(String token, String usuario) {
    	facade.setToken(token);
    	facade.setUsuario(usuario);
    	IUsuario u = facade.getUsuario();
    	infoUsuario.setName(u.getNome());
    	infoUsuario.setCidade(u.getCidadeNatal());
    	infoUsuario.setSobre(u.getSobre());
    	infoUsuario.setAniversario(u.getAniversario());
        cl.show(cardPanel, "infousuario");
    }
    
    public static void AmigosNome() {
        cl.show(cardPanel, "amigosnome");
    }
    
    public static void AmigosInterajo() {
        cl.show(cardPanel, "amigosinterajo");
    }
    
    public static void PaginaPalavraChave() {
        cl.show(cardPanel, "paginapalavrachave");
    }
    
    public static void PaginasRecomendadas() {
        cl.show(cardPanel, "paginasrecomendadas");
    }
    
    public static Facade getFacade() {
    	return facade;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cardPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cardPanel.setPreferredSize(new java.awt.Dimension(770, 460));

        javax.swing.GroupLayout cardPanelLayout = new javax.swing.GroupLayout(cardPanel);
        cardPanel.setLayout(cardPanelLayout);
        cardPanelLayout.setHorizontalGroup(
            cardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 770, Short.MAX_VALUE)
        );
        cardPanelLayout.setVerticalGroup(
            cardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 460, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cardPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cardPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     * @throws ParDeVerticesNaoExistenteException 
     * @throws IOException 
     * @throws FileNotFoundException 
     */
    public static void main(String args[]) throws FileNotFoundException, IOException, ParDeVerticesNaoExistenteException {



    	gerarGrafo = new GerarGrafo();
    	
    	/*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ControllerUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ControllerUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ControllerUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ControllerUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new ControllerUI().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JPanel cardPanel;
    // End of variables declaration//GEN-END:variables
}