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

    static String token = "AAACEdEose0cBAPZBGcSNZCZAqvXZAUyDtYL8ZAcEEJGRDNF9S4SVzNAejg5ZAbrZAX0jrUo7lpogJU4vZCy7ww26XGBrMKuXyEJ8d4ddtiiQjX4LBI3elqF6";
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
}
