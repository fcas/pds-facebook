package api;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.IPagina;

import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.types.Group;
import com.restfb.types.Page;
import com.restfb.types.Post;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String token = "AAACEdEose0cBACOGNvmbYA2EivYFjcRlX0fnVZCI6ekKiPpZANhMJuCkYhrh3ZAsmjsTpqi1cDlocx91kscaHVNFC6RrhLSTqg1Ml1IZAQZDZD";

		FacebookClient facebookClient = new DefaultFacebookClient(token);
		
		Page page = facebookClient.fetchObject("revengeabc", Page.class);
		
		//List<Page> p = facebookClient.fetchObjects("Movies", Page.class, Pages.class);

		System.out.println(page.getAbout());
		System.out.println(page.getCategory());
		System.out.println(page.getLikes());
//		
		//paginas que um amigo curte
		Connection<Page> connectionPage = facebookClient.fetchConnection("fernando.morquecho.7/likes", Page.class);
//		Connection<Post> myFeed = facebookClient.fetchConnection("felipecordeiroalves/feed", Post.class);
//		
//		List<Post> listPosts = myFeed.getData();
//		int i=0;
//		//for (int i=0; i<10; i++) {
//			System.out.println(listPosts.get(i).getMessage());
//			System.out.println(listPosts.get(i).getWithTags().get(0).getName());
//			System.out.println(listPosts.get(i).getWithTags().get(1).getName());
//		//}
//		
		List<Page> listPage = connectionPage.getData();
		
		Connection<Page> cp = facebookClient.fetchConnection("me/likes", Page.class);
		List<Page> myPages = cp.getData();
		//System.out.println(myPages.size() + "   " + listPage.size());
		
		for (int i=0; i<listPage.size(); i++) {//paginas em comum com um amigo
			for (int j=0; j<myPages.size(); j++) {
				if (myPages.get(j).getName().equals(listPage.get(i).getName()))
					System.out.println(myPages.get(j).getName());
			}
			//System.out.println(listPage.get(i).getName());
			//System.out.println(listPage.get(i).getCategory());
			//System.out.println(listPage.get(i).getAbout());
		}
		//pagina por palavra chave
//		Connection<Page> cPage = facebookClient.fetchConnection("search", Page.class, Parameter.with("q", "Rio de Janeiro"), Parameter.with("type", "page"));
//		List <Page> search = cPage.getData();
//		System.out.println(search.size());
//		for (int idx=0; idx<search.size(); idx++) {
//			Page p = facebookClient.fetchObject(search.get(idx).getId(), Page.class);
//			
//			System.out.println(p.getName());
//			System.out.println(p.getCategory());
//			System.out.println(p.getLikes());
//			System.out.println(p.getLink());
//			System.out.println();
//		//	System.out.println(listPage.get(i).getAbout());
//			
//		}
////		
//		List<Page> lp = facebookClient.executeQuery("SELECT page_id FROM page WHERE type='Sport'", Page.class);
//		System.out.println(lp.size());
//		
		//Connection<Post> connectionPost = facebookClient.fetchConnection("search", Post.class,  Parameter.with("q", "USA"), Parameter.with("type", "post"));
		//List<Post> search = connectionPost.getData();
		
		//for (int idx=0; idx<search.size(); idx++) {
			//System.out.println(listPage.get(i).getName());
			//System.out.println(listPage.get(i).getCategory());
		//	System.out.println(listPage.get(i).getAbout());
			
		//}
		
		Connection<Post> conPost = facebookClient.fetchConnection("me/feed", Post.class, Parameter.with("limit", 400));
		List<Post> lisPost = conPost.getData();
		for (int i=0; i<lisPost.size(); i++) {
			System.out.println("---------POST "+i+"---------");
			System.out.println(lisPost.get(i).getMessage());
//			for (int k=0; k<lisPost.get(i).getLikes().getData().size(); k++)
//				System.out.println("LIKES = " + lisPost.get(i).getLikes().getData().get(k).getName());
			
			for (int j=0; j<lisPost.get(i).getComments().getData().size(); j++)
				System.out.println("COMMENTS = " +lisPost.get(i).getComments().getData().get(j).getFrom().getName());
		}
		
//		Connection<Group> cgroup = facebookClient.fetchConnection("fernando.morquecho.7/groups", Group.class);
//		List<Group> listagrupos = cgroup.getData();
//		System.out.println(listagrupos.size());
//
//		System.out.println("-------GRUPOS DE FERNANDO-------");
//		for (int i=0; i<listagrupos.size(); i++) {
//			System.out.println(listagrupos.get(i).getName());
//		}
//	
//		Connection<Group> cg = facebookClient.fetchConnection("search", Group.class, Parameter.with("q", "Strathclyde"), Parameter.with("type", "group"));
//		List<Group> listag = cg.getData();
//		System.out.println(listag.size());
//
//		System.out.println("-------GRUPOS BUSCADOS-------");
//		for (int i=0; i<listag.size(); i++) {
//			System.out.println(listag.get(i).getName());
//		}
	}
//
//	public List<IPagina> paginasPorAmigosMaisProximos() {
//		List<IPagina> listaPaginas = new ArrayList<IPagina>();
//		
//		
//		return listaPaginas;
//	}
}
