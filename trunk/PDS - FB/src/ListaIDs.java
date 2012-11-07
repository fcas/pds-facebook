import java.util.ArrayList;
import java.util.List;

import com.restfb.Connection;
import com.restfb.types.User;

public class ListaIDs {

	public List<String> buscarIDs(String name) {

		Connection<User> amigos = Cliente.getInstance().fetchConnection(
				name + "/friends", User.class);

		List<String> usuarios = new ArrayList<String>();

		for (int i = 0; i < amigos.getData().size(); i++) {

			usuarios.add(amigos.getData().get(i).getId());

		}
		return usuarios;

	}

}
