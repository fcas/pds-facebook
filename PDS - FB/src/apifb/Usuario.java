package apifb;
import java.util.Date;

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
	
	public String getBio(String name) {
		return buscar.getUser(name).getBio();
	}
	
	public String getAbout(String name) {
		return buscar.getUser(name).getAbout();
	}
	
	public Date getBirthdayAsDate (String name) {
		return buscar.getUser(name).getBirthdayAsDate();
	}
	
	public String getHometownName (String name) {
		return buscar.getUser(name).getHometownName();
	}
	
	public String getRelationshipStatus (String name) {
		return buscar.getUser(name).getRelationshipStatus();
	}

}
