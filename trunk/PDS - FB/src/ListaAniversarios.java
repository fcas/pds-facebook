import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.restfb.Connection;
import com.restfb.types.User;

public class ListaAniversarios {

public static void main(String[] args) {
	
		
		List<User> usuarios = new ArrayList();
		
		
		FetchObjectsResults fetchObjectsResults =
				  Cliente.getInstance().fetchObjects(Arrays.asList("me", "cocacola"), FetchObjectsResults.class);
		
		System.out.println("User name: " + fetchObjectsResults.me.getName());

//		for (int i = 0; i < friends.getData().size(); i++) {
//				Connection<User> AmigosDeAmigos = Cliente.getInstance()
//						.fetchConnectionPage(
//								friends.getData().addAll(usuarios),
//								User.class);
//				return AmigosDeAmigos;
//			}
//	
}

	}


