import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;

public class Cliente {

	static String token = "AAACEdEose0cBADQvgmu4PSNYB3XdR5HJHjqDgQkEbZBizhoZBZBnNimPL9UKKxSkeMokZCwr4gCMfZAAU537g9DgqfKFs7rjlpNERwU1W3Uj9vebaYqwK";

	private static final FacebookClient facebookClient = new DefaultFacebookClient(
			token);

	private Cliente() {
	}

	public static FacebookClient getInstance() {
		return facebookClient;
	}

}
