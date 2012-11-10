package apifb;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;

public class Cliente {

	static String token = "AAACEdEose0cBAHkgtDMhkoDB6vzsOZA79Le2RcyZASascdV1wZA77VsIykUC33XIlqHGWMQI0Ofveo8HwSyJZA9odQw9oLbeBiov7yDpRwWziL0sF5vI";

	private static final FacebookClient facebookClient = new DefaultFacebookClient(
			token);

	private Cliente() {
	}

	public static FacebookClient getInstance() {
		return facebookClient;
	}

}
