package apifb;
import java.util.Date;


public interface IUsuario {

	public String getBirthday(String name);

	public String getID(String name);

	public String getEmail(String name);

	public String getName(String name);

	public String getBio(String name);

	public String getAbout(String name);

	public Date getBirthdayAsDate(String name);

	public String getHometownName(String name);

	public String getRelationshipStatus(String name);

}
