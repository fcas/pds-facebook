import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;

public class Cliente {

	static String token = "AAACEdEose0cBAF9gomTfxL3VHNcEUjIxTyDbWdmpmkMtPWFohepdiF42jDNPbv6bAiVBjAstXNUwEEBuqHT36ISkyrMH4sGi3bTYRNxAcvoTLn7z";

	private static final FacebookClient facebookClient = new DefaultFacebookClient(
			token);

	private Cliente() {
	}

	public static FacebookClient getInstance() {
		return facebookClient;
	}

}
