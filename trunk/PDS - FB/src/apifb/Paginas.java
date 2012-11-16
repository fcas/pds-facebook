package apifb;

import java.util.List;

import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.types.Page;

public class Paginas {

	public static void main(String[] args) {
		
		String token = "AAACEdEose0cBAC89eBqYmEmd1BMqdHQbHhEFOAJYd0ZAC6IFVPk8Nnql8uPTTZAtXCSLg1dYprsjYCLbZA2FZCiRxATsCAbwUxT48aNQoAZDZD";

		FacebookClient facebookClient = new DefaultFacebookClient(token);

		Page page = facebookClient.fetchObject("revengeabc", Page.class);

		// List<Page> p = facebookClient.fetchObjects("Movies", Page.class,
		// Pages.class);

		System.out.println(page.getAbout());
		System.out.println(page.getCategory());
		System.out.println(page.getLikes());
		//
		// Connection<Page> connectionPage =
		// facebookClient.fetchConnection("fernando.morquecho.7/likes",
		// Page.class);
		// Connection<Post> myFeed =
		// facebookClient.fetchConnection("felipecordeiroalves/feed",
		// Post.class);
		//
		// List<Post> listPosts = myFeed.getData();
		// int i=0;
		// //for (int i=0; i<10; i++) {
		// System.out.println(listPosts.get(i).getMessage());
		// System.out.println(listPosts.get(i).getWithTags().get(0).getName());
		// System.out.println(listPosts.get(i).getWithTags().get(1).getName());
		// //}
		//
		// List<Page> listPage = connectionPage.getData();


		// for (int i=0; i<listPage.size(); i++) {
		// System.out.println(listPage.get(i).getName());
		// System.out.println(listPage.get(i).getCategory());
		// //System.out.println(listPage.get(i).getAbout());
		// }

		Connection<Page> cPage = facebookClient.fetchConnection("search",
				Page.class, Parameter.with("q", "USA"),
				Parameter.with("type", "page"));
		List<Page> search = cPage.getData();
		System.out.println(search.size());
		for (int idx = 0; idx < search.size(); idx++) {
			Page p = facebookClient.fetchObject(search.get(idx).getId(),
					Page.class);

			System.out.println(p.getName());
			System.out.println(p.getCategory());
			System.out.println(p.getLikes());
			System.out.println(p.getLink());
			System.out.println();
			// System.out.println(listPage.get(i).getAbout());

		}

		// Connection<Post> connectionPost =
		// facebookClient.fetchConnection("search", Post.class,
		// Parameter.with("q", "USA"), Parameter.with("type", "post"));
		// List<Post> searchPost = connectionPost.getData();

	}

}
