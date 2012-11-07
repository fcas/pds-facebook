import com.restfb.types.User;

public class BuscarInfoUsuario {
	
	public User buscarInfoUsuario(String name){
		User user = Cliente.getInstance().fetchObject(name, User.class);
		return user;
	}

}
