/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;

/**
 *
 * @author larissa
 */
public class Cliente {

    static String token = "AAACEdEose0cBAKkT9ZBnrNKU95DGNr4YfuRh42cB306sNkwwoMD1vqj8nThNsddv7REjrE67YIW7noYZCPUZAmm2YZAuH1IWp0nrjm2dwQZDZD";
    private static FacebookClient facebookClient = null;

    private Cliente() {
    }

    /**
     * retorna o Client criado de acordo com o token
     */
    public static FacebookClient getInstance() {
        if (facebookClient == null)
            facebookClient = new DefaultFacebookClient(token);
        
        return facebookClient;
    }
    
    public static void setToken(String usuario_token) {
    	token = usuario_token;
    }
}
