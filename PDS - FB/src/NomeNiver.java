import java.util.ArrayList;
import java.util.List;

import com.restfb.Connection;
import com.restfb.types.User;

public class NomeNiver {

	public static void main(String[] args) {

		String name = "felipecordeiroalves";

		BuscarAmigos friends = new BuscarAmigos();

		Connection<User> amigos = friends.buscarAmigos(name);
		List<User> usuarios = new ArrayList();
		
		for (int i = 0; i < amigos.getData().size(); i++) {
			User user = Cliente.getInstance().fetchObject(amigos.getData().get(i).getId(), User.class);
			usuarios.add(user);
		}
		
		for (int i = 0; i < usuarios.size(); i++) {
			System.out.println(usuarios.get(i).getBirthday());
		}


		
	}
}
