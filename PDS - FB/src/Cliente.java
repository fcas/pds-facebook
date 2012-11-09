import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;

public class Cliente {

	static String token = "AAACEdEose0cBAKNXOwsNO356kl5P3VeZCpiV5SVO7ZAU1HzPbl6euovEzmjZARZBBMeHRZCNZCl6elgM0CIS00j4ITqNINqZBrG8bzNooLXniaOUYeYktBQ";

	private static final FacebookClient facebookClient = new DefaultFacebookClient(
			token);

	private Cliente() {
	}

	public static FacebookClient getInstance() {
		return facebookClient;
	}

}
