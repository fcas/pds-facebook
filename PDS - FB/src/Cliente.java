import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;

public class Cliente {

	static String token = "AAACEdEose0cBAFyoDOqRCkLiU0T94V39BcJkYKcZCfmq0PYxgFogZBka6TGaErvIeFrCqRZCXP8LXnyqaMTysZA3c8ZBxFCM7BoMZAErr2b66YX6ZBuPSLJ";

	private static final FacebookClient facebookClient = new DefaultFacebookClient(
			token);

	private Cliente() {
	}

	public static FacebookClient getInstance() {
		return facebookClient;
	}

}
