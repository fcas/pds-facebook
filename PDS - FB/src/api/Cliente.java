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

    static String token = "AAACEdEose0cBANZCZBrk466DpaMWDbhhcuL3Bu1kmhvlspuViWx6bmZB7YhtY0weoHHcpdWQWHhTApt6xxukrNRahJ1TpDlZC8GYG3nUEQZDZD";
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
