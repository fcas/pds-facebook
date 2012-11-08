import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;

public class Cliente {

	static String token = "AAACEdEose0cBAKbPVhxfaO7AUtiYQy1ZBe99hu7L3yxda3yZBB7DDwfc8g1DTCY1JZAbfTdPfJGC5dORXg3WlZCd8XiJeT6QXQXzZAk9qklVIAMbZCDU0y";

	private static final FacebookClient facebookClient = new DefaultFacebookClient(
			token);

	private Cliente() {
	}

	public static FacebookClient getInstance() {
		return facebookClient;
	}

}
