import com.restfb.Connection;
import com.restfb.types.User;

public class NomeNiver {

	public static void main(String[] args) {

		String name = "felipecordeiroalves";

		BuscarAmigos friends = new BuscarAmigos();

		BuscarAmigosDeAmigos amigosdeamigos = new BuscarAmigosDeAmigos();

		Connection<User> amigos = amigosdeamigos.buscarAmigosDeAmigos(
				friends.buscarAmigos(name), "AnderShow Rodrigues");

		for (int i = 0; i < amigos.getData().size(); i++) {
			System.out.println(amigos.getData().get(i).getName());
			System.out.println(amigos.getData().get(i).getBirthday());
		}

	}
}
