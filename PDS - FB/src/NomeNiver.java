import java.util.List;
import com.restfb.types.User;

public class NomeNiver {

	public static void main(String[] args) {

		String name = "felipecordeiroalves";

		BuscarInfoUsuario usuario = new BuscarInfoUsuario();
		ListaIDs listaIDs = new ListaIDs();

		List<String> lista = listaIDs.buscarIDs(name);

		User user;

		for (int i = 0; i < lista.size(); i++) {
			user = usuario.buscarInfoUsuario(lista.get(i));
			System.out.println(user.getBirthday());
		}

	}
}
