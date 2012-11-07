import com.restfb.types.User;

public class BuscarInfoUsuario {

	public User getUser(String name) {
		return Cliente.getInstance().fetchObject(name, User.class);
	}

}
