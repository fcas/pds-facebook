import com.restfb.types.User;

public class BuscarInfoUsuario {
	
	User user;
	
	public User buscarInfoUsuario(String name){
		
		user = Cliente.getInstance().fetchObject(name, User.class);
		
		return user;
	}

}
