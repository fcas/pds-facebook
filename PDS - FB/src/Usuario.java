import com.restfb.types.User;

public class Usuario implements IUsuario {

	BuscarInfoUsuario buscar = new BuscarInfoUsuario();
	User user;
	
	public String getBirthday(String name) {
		return buscar.getUser(name).getBirthday();
	}
	
	public String getID(String name) {
		return buscar.getUser(name).getId();
	}

}
