import java.util.Collection;

import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.types.Page;
import com.restfb.types.Post;
import com.restfb.types.User;


public class Teste {
	
	public static void main(String[] args) {
		
		String name = "felipecordeiroalves";
		String token = "AAACEdEose0cBAHrVbtqHRpd5mkZC0kZCqm4kO0JpMZAZC2TGnTKEDbFhCLK3wZBtgA3ZC7vK8wKoMWtK9odxpIXWybZB5eHaxg4tRZAQjACvLbVuyfaFSZAO0";
		FacebookClient facebookClient = new DefaultFacebookClient(token);

		
//		
		Connection<User> myFriends = facebookClient.fetchConnection(name+"/friends", User.class);
//		Connection<Post> myFeed = facebookClient.fetchConnection(name+"/feed", Post.class);
//
		for (int i=0; i<875; i++)
			System.out.println(myFriends.getData().get(i).getName());
//		System.out.println("Count of my friends: " +
//		System.out.println("First item in my feed: " + myFeed.getData().get(0).getName());
		
		User user = facebookClient.fetchObject(name, User.class); 
		

		System.out.println("User name: " + user.getName());
		System.out.println("User hometown: " + user.getHometownName());
		System.out.println("User link: " + user.getLink());
		System.out.println("User link: " + user.getBirthday());
		System.out.println("User link: " + user.getPolitical());
		System.out.println("User link: " + user.getEmail());
		System.out.println("User link: " + user.getBio());
		System.out.println("User link: " + user.getRelationshipStatus());
		
	}
	
}
