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

    static String token = "AAACEdEose0cBANqPJBqXBHme6TNw6AZBl1IrvgFbcmFnA69KMg7vsTZCjP2J6S4Lf3UjuyGwlPfF260Pmt7P0bKWy3UFePsh7pl2IhTgZDZD";
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
