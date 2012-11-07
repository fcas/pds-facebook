import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;

public class Cliente {

	static String token = "AAACEdEose0cBAKfZABXWybKAj0ZBrf3sVEH2c3SNYLSIm2BZCqUJd3WAiDnga50jgNxfosP1kRi1Ic5w9taK82Vz8HIV6j3Dlwmtn7E4NI5wQuCrY5v";

	private static final FacebookClient facebookClient = new DefaultFacebookClient(
			token);

	private Cliente() {
	}

	public static FacebookClient getInstance() {
		return facebookClient;
	}

}
