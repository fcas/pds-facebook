import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;

public class Cliente {

	static String token = "AAACEdEose0cBANxYEKmZCY5biGWLpZBwAs7KfDYeR2J7OVTXtI8ZBiXwNPh8hFOuOHCR9Q9swr0V9XNg54F64xZCTJyWvfXSwgR127YrGC8OfCz2Kxbx";

	private static final FacebookClient facebookClient = new DefaultFacebookClient(
			token);

	private Cliente() {
	}

	public static FacebookClient getInstance() {
		return facebookClient;
	}

}
