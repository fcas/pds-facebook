import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;

public class Cliente {
	
	public static String token; 
	
	public static String getToken() {
		return token;
	}

	public static void setToken(String token) {
		Cliente.token = token;
	}

	private static final FacebookClient facebookClient = new DefaultFacebookClient(token);
	
	private Cliente() {} 
	
	 public static FacebookClient getInstance() {
	        return facebookClient;
	    }
	
}
