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
import tests.VerticeJaExisteException;

import model.IUsuario;
import model.Ranking;
import model.UsuarioApi;

/**
 *
 * @author larissa
 */
public class Principal extends javax.swing.JFrame {
	private static final long serialVersionUID = 2515070054356991455L;
	
	private static CardLayout cl;
    @SuppressWarnings("unused")
	private static GerarGrafo gerarGrafo;
    private static IUsuario usuarioLarissa;
    
    public Principal() {
        initComponents();
        cl = new CardLayout();
        cardPanel.setLayout(cl);
        cardPanel.add(new TelaLogin(), "telalogin");
        cardPanel.add(new InfoUsuario(), "infousuario");
        cardPanel.add(new AmigosNome(), "amigosnome");
        cardPanel.add(new AmigosInterajo(), "amigosinterajo");
        cardPanel.add(new PaginaPalavraChave(), "paginapalavrachave");
        cardPanel.add(new PaginasRecomendadas(), "paginasrecomendadas");
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }

    public static void InfoUsuario() {
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
    
    public static IUsuario getUsuario() {
    	return usuarioLarissa;
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
    	
//    	IUsuario usuarioFelipe = new UsuarioApi("felipecordeiroalves");
    	usuarioLarissa = new UsuarioApi("larissabatistaleite");
//    	IUsuario usuarioAnderson = new UsuarioApi("showrodrigues");
    	gerarGrafo = new GerarGrafo();
    	
    	try {
			usuarioLarissa.buscarAmigosMaiorAfinidade();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (VerticeJaExisteException e) {
			e.printStackTrace();
		} catch (ParDeVerticesNaoExistenteException e) {
			e.printStackTrace();
		}
    	
    	Ranking ranking = usuarioLarissa.getRanking();
    	for (int i=ranking.getLista().size()-1; i>-1; i--) {
    		System.out.println(ranking.getLista().get(i).getNome() + "  " + ranking.getLista().get(i).getPontos());
    	}
//    	//System.out.println(usuarioFelipe.getUsername()+ "  " + usuarioFelipe.getCidadeNatal());
//    	DaoFactory factory = DaoFactory.createDaoFactory(0);
    	
    	//colocar um if para gerar o grafo direto se o arquivo ja existir
//    	try {
//			factory.criarUsuario(usuarioFelipe);
//			factory.criarUsuario(usuarioAnderson);
//			factory.criarUsuario(usuarioLarissa);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
    	
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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Principal().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JPanel cardPanel;
    // End of variables declaration//GEN-END:variables
}
