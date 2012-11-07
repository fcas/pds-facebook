public class Usuario implements IUsuario {

	BuscarUsuario buscar = new BuscarUsuario();

	public String getBirthday(String name) {
		return buscar.getUser(name).getBirthday();
	}

	public String getID(String name) {
		return buscar.getUser(name).getId();
	}

	public String getEmail(String name) {
		return buscar.getUser(name).getEmail();
	}

	public String getName(String name) {
		return buscar.getUser(name).getName();
	}

}
