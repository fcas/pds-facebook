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

    static String token = "AAACEdEose0cBAC3cayZCc3InasCMsH6rV7MWmWZCb8FNYLQtOb0zhbcLmWOpUSvuZBy3bQU7BOQfOQEWoDjVBFWakWWF08tM4aXaCVhzFMgVt3DQIk0";
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
