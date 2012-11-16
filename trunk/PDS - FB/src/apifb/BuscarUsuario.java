package apifb;
import com.restfb.types.User;

public class BuscarUsuario {

	/**Busca e guarda informacoes do usuario**/
	public User getUser(String name) {
		return Cliente.getInstance().fetchObject(name, User.class);
	}

}