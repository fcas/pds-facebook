import com.restfb.Connection;
import com.restfb.types.User;

public class BuscarAmigos {

	public Connection<User> buscarAmigos(String name) {

		Connection<User> AmigosDeAmigos = Cliente.getInstance()
				.fetchConnection(name + "/friends", User.class);
		
		return AmigosDeAmigos;

	}

}
