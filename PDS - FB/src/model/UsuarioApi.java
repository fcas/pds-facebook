/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import api.Cliente;
import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.types.Group;
import com.restfb.types.Page;
import com.restfb.types.Post;
import com.restfb.types.User;

import grafo.GerarGrafo;
import grafo.Vertex;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import tests.ParDeVerticesNaoExistenteException;
import tests.VerticeJaExisteException;

/**
 *
 * @author larissa
 */
public class UsuarioApi implements IUsuario {
	//Utilizado no mÈtodo recomendarPaginas(), para determinar quantos "likes" s„o necess·rios para que uma p·gina seja considerada relevante
	
	
    private User user;
    
    private String aniversario;
    private String ID;
    private String email;
    private String nome;
    private String bio;
    private String sobre;
    private String cidade;
    private String status;
    private String username;
    
    private List<IGrupo> listaMeusGrupos = meusGrupos();
    
    private final String caminhoArquivo = System.getProperty("user.dir") + System.getProperty("file.separator");
    
    private List<IPagina> paginasCurtidas = buscarPaginasCurtidas();
    
    private Ranking ranking = new Ranking();
    
    public UsuarioApi (String username) {
        user = Cliente.getInstance().fetchObject(username, User.class);
        
        this.setNome(user.getName());
        this.setID(user.getId());
        this.setCidade(user.getLocale());
        this.setUsername(user.getUsername());
        this.setAniversario(user.getBirthday());
        
    }       

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setAniversario(String aniversario) {
        this.aniversario = aniversario;
    }

    public void setBio() {
        this.bio = user.getBio();
    }

    public void setCidade(String cidade) {
        this.cidade = user.getHometownName();
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSobre(String sobre) {
        this.sobre = sobre;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public void setUsername(String username) {
    	this.username = username;
    }
    
    public String getUsername() {
    	return username;
    }
    
    @Override
    public String getAniversario() {
        return aniversario;
    }

    @Override
    public String getID() {
        return ID;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public String getBio() {
        return bio;
    }

    @Override
    public String getSobre() {
        return sobre;
    }

    @Override
    public String getCidadeNatal() {
        return cidade;
    }

    @Override
    public String getStatusRelacionamento() {
        return status;
    }
    
    public Ranking getRanking() {
    	ranking.ordenarRanking();
    	return ranking;
    }

    @Override
    public List<IUsuario> getAmigos() {
    	
    	User user;
    	
		Connection<User> amigosConexao = Cliente.getInstance().fetchConnection(
				  username+"/friends", User.class);
		
		List<User> amigosData = amigosConexao.getData();
		
		List<IUsuario> amigos = new ArrayList<IUsuario>();
		
		for (int i=0; i<amigosData.size(); i++) {
			user = Cliente.getInstance().fetchObject(amigosData.get(i).getId(), User.class);
			String username = user.getUsername();
			System.out.println(username);
			
			if (username != null) {
				IUsuario usuario = new UsuarioApi(username);
				amigos.add(usuario);
			}	
		}	
		
		//System.out.println("ESCREVENDO NO ARQUIVO");
		return amigos;
    }
    
    @Override
    public List<IPagina> buscarPaginasCurtidas() {
        Connection<Page> conexao = Cliente.getInstance().fetchConnection("me/likes", Page.class);
        List<Page> minhasPaginas = conexao.getData();
        
        List<IPagina> listaPaginas = new ArrayList<IPagina>();
        
        for (int i=0; i<minhasPaginas.size(); i++) {
        	System.out.println("fetching page " + minhasPaginas.get(i).getId());
            Page p = Cliente.getInstance().fetchObject(minhasPaginas.get(i).getId(),
					Page.class);

            IPagina pagina = new PaginaApi();
            pagina.setNome(p.getName());
            pagina.setLink(p.getLink());
            pagina.setLikes(p.getLikes());
            pagina.setCategoria(p.getCategory());
            pagina.setID(p.getId());
            listaPaginas.add(pagina);
            
        }
        
        return listaPaginas;
    }

    public List<IGrupo> meusGrupos() {
    	
		Connection<Group> cgroup = Cliente.getInstance().fetchConnection("me/groups", Group.class);
		List<Group> lista = cgroup.getData();
		
		List<IGrupo> listaMeusGrupos = new ArrayList<IGrupo>();
		
		for (int i=0; i<lista.size(); i++) {
			IGrupo grupo = new GrupoApi();
			grupo.setID(lista.get(i).getId());
			grupo.setLink(lista.get(i).getLink());
			grupo.setNome(lista.get(i).getName());
			
			listaMeusGrupos.add(grupo);
		}
		
		return listaMeusGrupos;
		
    }
    
    @Override
    public List<IPagina> buscarPaginasPalavraChave(String palavra) {
        Connection<Page> conexao = Cliente.getInstance().fetchConnection("search",
				Page.class, Parameter.with("q", palavra),
				Parameter.with("type", "page"));
        
        List<Page> paginas = conexao.getData();
        List<IPagina> listaPaginas = new ArrayList<IPagina>();
   
        for (int i=0; i<paginas.size(); i++) {
            Page p = Cliente.getInstance().fetchObject(paginas.get(i).getId(),
					Page.class);
            
            IPagina pagina = new PaginaApi();
            pagina.setNome(p.getName());
            pagina.setLink(p.getLink());
            //pagina.setLikes(p.getLikes().toString());
            pagina.setCategoria(p.getCategory());
            listaPaginas.add(pagina);
            
        }
        
        return listaPaginas;
    }

	@Override
	public List<String> getAmigosIDs() {
		Connection<User> amigosConexao = Cliente.getInstance().fetchConnection(
				  username+"/friends", User.class);
		
		List<User> amigosData = amigosConexao.getData();
		List<String> amigosIDs = new ArrayList<String>();
		
		for (int i = 0; i < amigosData.size(); i++) {
			amigosIDs.add(amigosData.get(i).getId());
		}
		
		return amigosIDs;
	}

	@Override
	public List<String> getAmigosNomes() {
		Connection<User> amigosConexao = Cliente.getInstance().fetchConnection(
				  username+"/friends", User.class);
		
		List<User> amigosData = amigosConexao.getData();
		List<String> amigosNomes = new ArrayList<String>();
		
		for (int i = 0; i < amigosData.size(); i++) {
			amigosNomes.add(amigosData.get(i).getName());
		}
		
		return amigosNomes;
	}

	public List<Vertex> buscarAmigos(String nome) throws FileNotFoundException, IOException, VerticeJaExisteException, ParDeVerticesNaoExistenteException {
		
		List<Vertex> listaVertices = GerarGrafo.getInstance().buscarVerticeNome(nome);
		
		return listaVertices;
	}
	
	//retorna os Nomes dos amigos
	@Override
	public List<String> buscarAmigosMaiorAfinidade() throws FileNotFoundException, IOException, VerticeJaExisteException, ParDeVerticesNaoExistenteException {
		
		/*CRITERIO = PAGINAS. COLOCAR EM ARQUIVO PARA MELHORAR DESEMPENHO*/
		List<String> listaAmigosIDs = getAmigosIDs();
		
		for (int i=0; i<listaAmigosIDs.size(); i++) {
			int quantPaginas = paginasEmComum(listaAmigosIDs.get(i).toString()).size();
			if (quantPaginas >= 15) {//ESSE CRIT√âRIO PODE SER MUDADO
					
					AmigoRanking amigo = ranking.amigoJaExisteID(listaAmigosIDs.get(i).toString());
					if (amigo != null) {
						amigo.incrementaPontos(quantPaginas);
					} else {
						Vertex v = GerarGrafo.getInstance().searchVertex(listaAmigosIDs.get(i).toString());
						if (v != null) {
							amigo = new AmigoRanking();
							amigo.setID(v.getId());
							amigo.setNome(v.getName());
							amigo.setPontos(quantPaginas);
							ranking.getLista().add(amigo);
						}
					}	
			}
			/*CRITERIO = GRUPOS. COLOCAR EM ARQUIVO PARA MELHORAR DESEMPENHO*/
			int quantGrupos = gruposEmComum(listaAmigosIDs.get(i).toString());
			if (quantGrupos > 2) {//ESSE CRIT√âRIO PODE SER MUDADO
				
				AmigoRanking amigo = ranking.amigoJaExisteID(listaAmigosIDs.get(i).toString());
				if (amigo != null) {
					amigo.incrementaPontos(quantGrupos*3);
				} else {
					Vertex v = GerarGrafo.getInstance().searchVertex(listaAmigosIDs.get(i).toString());
					if (v != null) {
						amigo = new AmigoRanking();
						amigo.setID(v.getId());
						amigo.setNome(v.getName());
						amigo.setPontos(quantGrupos*3);
						ranking.getLista().add(amigo);
					}
				}
			}
				
		}
		
		/*CRITERIO = COMENT√ÅRIO EM POST. Cada coment√°rio vale 7 pts*/
		Connection<Post> conPost = Cliente.getInstance().fetchConnection("me/feed", Post.class, Parameter.with("limit", 400));
		List<Post> lisPost = conPost.getData();
		IPost post = new PostApi();
		
		for (int i=0; i<lisPost.size(); i++) {
			for (int j=0; j<lisPost.get(i).getComments().getData().size(); j++) {
				String nome = lisPost.get(i).getComments().getData().get(j).getFrom().getName();
				if (nome != null && !nome.equals("Larissa Batista Leite")) {
					post.setUsuariosComent(nome);
				}	
			}
		}
		
		
		for (int i=0; i<post.getUsuariosComent().size(); i++) {
			AmigoRanking amigo = ranking.amigoJaExisteNome(post.getUsuariosComent().get(i).toString());
			if (amigo != null) {
				amigo.setPontos(amigo.getPontos()+7);
			} else {
				amigo = new AmigoRanking();
				amigo.setID(GerarGrafo.getInstance().searchVertexNome(nome).getId());
				amigo.setNome(post.getUsuariosComent().get(i).toString());
				amigo.setPontos(7);
				ranking.getLista().add(amigo);
			}
		}
		
		return null;//AJEITAR ESSE RETURN
		
	}
	
	public List<IPagina> buscarPaginasAmigo (String ID) {
		Connection<Page> conexao = Cliente.getInstance().fetchConnection(ID+"/likes", Page.class);
        List<Page> paginasAmigo = conexao.getData();
        
        List<IPagina> listaPaginas = new ArrayList<IPagina>();
        
        for (int i=0; i<paginasAmigo.size(); i++) {
        	System.out.println("Fetching info from page: " + paginasAmigo.get(i).getName());
            Page p = Cliente.getInstance().fetchObject(paginasAmigo.get(i).getId(),
					Page.class);
            
            IPagina pagina = new PaginaApi();
            pagina.setNome(p.getName());
            pagina.setLink(p.getLink());
            pagina.setLikes(p.getLikes());
            pagina.setCategoria(p.getCategory());
            pagina.setID(p.getId());
            listaPaginas.add(pagina);
            
        }
        
        return listaPaginas;
	}
	
	public List<IPagina> paginasEmComum (String ID) {
		
        List<IPagina> listaPaginas = buscarPaginasAmigo(ID);
        
        List<IPagina> paginasComuns = new ArrayList<IPagina>();
        
	        for (int i=0; i<paginasCurtidas.size(); i++) {
	        	for (int j=0; j<listaPaginas.size(); j++) {
		        	if (listaPaginas.get(j).getNome().equals(paginasCurtidas.get(i).getNome()))
		        		paginasComuns.add(paginasCurtidas.get(i));
	        	}
	        }

        return paginasComuns;
		
	}
	
	public int gruposEmComum(String ID) {
		int quantidade = 0;
		
		Connection<Group> cgroup = Cliente.getInstance().fetchConnection(ID+"/groups", Group.class);
		List<Group> lista = cgroup.getData();
		
		List<IGrupo> gruposAmigo = new ArrayList<IGrupo>();
		
		for (int i=0; i<lista.size(); i++) {
			IGrupo grupo = new GrupoApi();
			grupo.setID(lista.get(i).getId());
			grupo.setLink(lista.get(i).getLink());
			grupo.setNome(lista.get(i).getName());
			
			gruposAmigo.add(grupo);
		}
		
        for (int i=0; i<listaMeusGrupos.size(); i++) {
        	for (int j=0; j<gruposAmigo.size(); j++) {
	        	if (gruposAmigo.get(j).getNome().equals(listaMeusGrupos.get(i).getNome()))
	        		quantidade++;
        	}
        }
        
        return quantidade;
	}
	
	//botar global
	public List<IPagina> recomendarPaginas() throws IOException, VerticeJaExisteException, ParDeVerticesNaoExistenteException {
		System.out.println("Criando lista de RecomendaÁıes.");
    	BufferedReader ranking = new BufferedReader(new FileReader(caminhoArquivo+"ranking.txt")); //seta o caminho do arquivo de leitura "ranking.txt" que contÈm ranking dos amigos mais prÛximos
    	int cont = 0; //auxiliar
    	List<IPagina> paginasRecomendadas = new ArrayList<IPagina>(); //lista de p·ginas recomendadas para o usu·rio
    	ListaPaginaRanking listaRanking = new ListaPaginaRanking();
    	
        while(cont < 5) //para os 5 primeiro amigos do ranking
        {
        	Vertex v = (Vertex) GerarGrafo.getInstance().searchVertexNome(ranking.readLine()); //v = prÛxima linha do arquivo "ranking.txt"
        	if (v != null) //se v conseguiu pegar um vÈrtice
        	{
        		System.out.println("v = " + v.getName());
        		/*
        		 * Cria uma lista completa de p·ginas que os amigos do ranking curtem.
        		 * Em seguida, verifica quais dessas p·ginas o usu·rio j· curte.
        		 * ApÛs, verifica quais dessas p·ginas s„o pouco populares e as remove da lista.  
        		 */
        		List<IPagina> paginasAmigo = buscarPaginasAmigo(v.getId()); //lista auxiliar de p·ginas. Pega as p·ginas que "v" curte
        		for (int i=0; i<paginasCurtidas.size(); i++) //para cada p·gina que o usu·rio curte
        		{
        			if (paginasAmigo.contains(paginasCurtidas.get(i))) //se o usu·rio j· curte a mesma p·gina que o amigo
        				paginasAmigo.remove(paginasCurtidas.get(i)); //essa p·gina n„o ser· sugerida.
        		}
        		
        		for (int i=0; i<paginasAmigo.size(); i++) //para cada p·gina restante na lista de amigos
        		{
        			
        			if (paginasAmigo.get(i).getLikes() >= 3000) //se essa p·gina tem "LIMITE_CURTIDAS" curtidas,
        			{
        				listaRanking.adicionaPagina(paginasAmigo.get(i));
        			}
        		}
        	}
        	
        	ranking.readLine(); //pula uma linha do arquivo ranking.txt
        	cont++; //conta um amigo do ranking
        }
        
        System.out.println("Lista de recomendaÁıes criada.");
        
        /*
         * Ordenar por categoria 
         */
        
        List<String> categoriasMaisCurtidas = this.categoriasMaisCurtidas(); //verifica categorias que o usu·rio mais se interessa
        
        System.out.println("Categorias mais curtidas pelo usu·rio: ");
        for (int i = 0; i<categoriasMaisCurtidas.size(); i++){
        	System.out.println(categoriasMaisCurtidas.get(i));
        }
        
        listaRanking.aplicarCategoriasMaisCurtidas(categoriasMaisCurtidas); //aplica o Ìndice de categorias 
        listaRanking.ordenarRanking(); //ordena baseado nos novos Ìndices
        
        
        
        //adicionar p·ginas ordenadas ‡ lista de p·ginas recomendadas
        List<PaginaRanking> aux = listaRanking.getListaPagina();
		System.out.println("Lista de p·ginas de Sugest„o: ");
        for (int i = 0; i < aux.size(); i++){
        	paginasRecomendadas.add(aux.get(i).getPagina());
        	System.out.println(aux.get(i).getPagina().getNome() + " - " + aux.get(i).getPopularidade());
        }
        System.out.println("Total: " + paginasRecomendadas.size());
        
        
        
        
        ranking.close(); //resource leak
		return paginasRecomendadas;
		
	}

	public List<String> categoriasMaisCurtidas() {
		System.out.println("Calculando categorias preferidas...");
		ListaCategoriaRanking listaRanking = new ListaCategoriaRanking();
		for (int i = 0; i < paginasCurtidas.size(); i++){
			listaRanking.adicionaCategoria(paginasCurtidas.get(i).getCategoria());
		}
		listaRanking.ordenarRanking();
		
		List<String> listaTresPrimeiros = new ArrayList<String>();
		List<CategoriaRanking> rankingFinal = listaRanking.getListaCategoria();
		for (int i = 0; i < 3; i++){
			listaTresPrimeiros.add(rankingFinal.get(i).getCategoria());
		}
		
		return listaTresPrimeiros;
	}
}