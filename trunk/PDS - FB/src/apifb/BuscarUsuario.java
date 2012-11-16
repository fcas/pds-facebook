package apifb;
import com.restfb.types.User;

public class BuscarUsuario {

	public User getUser(String name) {
		return Cliente.getInstance().fetchObject(name, User.class);
	}

}