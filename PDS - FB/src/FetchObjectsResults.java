import com.restfb.Facebook;
import com.restfb.types.User;


public class FetchObjectsResults {
	
	@Facebook
	  User me;

	  // If the Facebook property name doesn't match
	  // the Java field name, specify the Facebook field name in the annotation.

}
