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

import model.rankings.Amigos;
import model.rankings.Categorias;
import model.rankings.RankingCategorias;
import model.rankings.RankingPaginas;
import model.rankings.Paginas;
import model.rankings.RankingAmigos;

import tests.ParDeVerticesNaoExistenteException;
import tests.VerticeJaExisteException;

/**
 *
 * @author larissa
 */
public class UsuarioApi implements IUsuario {

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
    
    private RankingAmigos ranking = new RankingAmigos();
    
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
    
    public RankingAmigos getRanking() {
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
	
	@Override
	public RankingAmigos buscarAmigosMaiorAfinidade() throws FileNotFoundException, IOException, VerticeJaExisteException, ParDeVerticesNaoExistenteException {
		
		/*CRITERIO = PAGINAS. COLOCAR EM ARQUIVO PARA MELHORAR DESEMPENHO*/
		List<String> listaAmigosIDs = getAmigosIDs();
		
		for (int i=0; i<listaAmigosIDs.size(); i++) {
			int quantPaginas = paginasEmComum(listaAmigosIDs.get(i).toString()).size();
			if (quantPaginas >= 15) {//ESSE CRITÉRIO PODE SER MUDADO
					
					Amigos amigo = ranking.amigoJaExisteID(listaAmigosIDs.get(i).toString());
					if (amigo != null) {
						amigo.incrementaPontos(quantPaginas);
					} else {
						Vertex v = GerarGrafo.getInstance().searchVertex(listaAmigosIDs.get(i).toString());
						if (v != null) {
							amigo = new Amigos();
							amigo.setID(v.getId());
							amigo.setNome(v.getName());
							amigo.setPontos(quantPaginas);
							ranking.getLista().add(amigo);
						}
					}	
			}
			/*CRITERIO = GRUPOS. COLOCAR EM ARQUIVO PARA MELHORAR DESEMPENHO*/
			int quantGrupos = gruposEmComum(listaAmigosIDs.get(i).toString());
			if (quantGrupos > 2) {//ESSE CRITÉRIO PODE SER MUDADO
				
				Amigos amigo = ranking.amigoJaExisteID(listaAmigosIDs.get(i).toString());
				if (amigo != null) {
					amigo.incrementaPontos(quantGrupos*3);
				} else {
					Vertex v = GerarGrafo.getInstance().searchVertex(listaAmigosIDs.get(i).toString());
					if (v != null) {
						amigo = new Amigos();
						amigo.setID(v.getId());
						amigo.setNome(v.getName());
						amigo.setPontos(quantGrupos*3);
						ranking.getLista().add(amigo);
					}
				}
			}
				
		}
		
		/*CRITERIO = COMENTÁRIO EM POST. Cada comentário vale 7 pts*/
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
			Amigos amigo = ranking.amigoJaExisteNome(post.getUsuariosComent().get(i).toString());
			if (amigo != null) {
				amigo.setPontos(amigo.getPontos()+7);
			} else {
				amigo = new Amigos();
				amigo.setID(GerarGrafo.getInstance().searchVertexNome(nome).getId());
				amigo.setNome(post.getUsuariosComent().get(i).toString());
				amigo.setPontos(7);
				ranking.getLista().add(amigo);
			}
		}
		
		return ranking;
		
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
	
	public RankingPaginas paginasAmigosRanking() throws IOException, VerticeJaExisteException, ParDeVerticesNaoExistenteException {
		int cont = 0;
    	BufferedReader ranking = new BufferedReader(new FileReader(caminhoArquivo+"ranking.txt")); //seta o caminho do arquivo de leitura "ranking.txt" que cont�m ranking dos amigos mais pr�ximos

		RankingPaginas listaRanking = new RankingPaginas();
		  while(cont < 5) //para os 5 primeiro amigos do ranking
	        {
	        	Vertex v = (Vertex) GerarGrafo.getInstance().searchVertexNome(ranking.readLine()); //v = pr�xima linha do arquivo "ranking.txt"
	        	if (v != null) //se v conseguiu pegar um v�rtice
	        	{
	        		System.out.println("v = " + v.getName());
	        		/*
	        		 * Cria uma lista completa de p�ginas que os amigos do ranking curtem.
	        		 * Em seguida, verifica quais dessas p�ginas o usu�rio j� curte.
	        		 * Ap�s, verifica quais dessas p�ginas s�o pouco populares e as remove da lista.  
	        		 */
	        		List<IPagina> paginasAmigo = buscarPaginasAmigo(v.getId()); //lista auxiliar de p�ginas. Pega as p�ginas que "v" curte
	        		for (int i=0; i<paginasCurtidas.size(); i++) //para cada p�gina que o usu�rio curte
	        		{
	        			if (paginasAmigo.contains(paginasCurtidas.get(i))) //se o usu�rio j� curte a mesma p�gina que o amigo
	        				paginasAmigo.remove(paginasCurtidas.get(i)); //essa p�gina n�o ser� sugerida.
	        		}
	        		
	        		for (int i=0; i<paginasAmigo.size(); i++) //para cada p�gina restante na lista de amigos
	        		{
	        			
	        			if (paginasAmigo.get(i).getLikes() >= 3000) //se essa p�gina tem "LIMITE_CURTIDAS" curtidas,
	        			{
	        				listaRanking.adicionaPagina(paginasAmigo.get(i));
	        			}
	        		}
	        	}
	        	
	        	ranking.readLine(); //pula uma linha do arquivo ranking.txt
	        	cont++; //conta um amigo do ranking
	        }
		  ranking.close(); //resource leak
		  return listaRanking;
	}
	
	@Override
	public List<IPagina> recomendarPaginas() throws IOException, VerticeJaExisteException, ParDeVerticesNaoExistenteException {
    	List<IPagina> paginasRecomendadas = new ArrayList<IPagina>(); //lista de p�ginas recomendadas para o usu�rio
    	RankingPaginas listaRanking = paginasAmigosRanking();
        
        /*
         * Ordenar por categoria 
         */
        
        List<String> categoriasMaisCurtidas = this.categoriasMaisCurtidas(); //verifica categorias que o usu�rio mais se interessa
        
        listaRanking.aplicarCategoriasMaisCurtidas(categoriasMaisCurtidas); //aplica o �ndice de categorias 
        listaRanking.ordenarRanking(); //ordena baseado nos novos �ndices
        
        //adicionar p�ginas ordenadas � lista de p�ginas recomendadas
        List<Paginas> aux = listaRanking.getListaPagina();
		for (int i = 0; i < aux.size(); i++){
        	paginasRecomendadas.add(aux.get(i).getPagina());
        }
        
       
		return paginasRecomendadas;
		
	}
	
	public List<String> categoriasMaisCurtidas() {
		RankingCategorias listaRanking = new RankingCategorias();
		for (int i = 0; i < paginasCurtidas.size(); i++){
			listaRanking.adicionaCategoria(paginasCurtidas.get(i).getCategoria());
		}
		listaRanking.ordenarRanking();
		
		List<String> listaTresPrimeiros = new ArrayList<String>();
		List<Categorias> rankingFinal = listaRanking.getListaCategoria();
		for (int i = 0; i < 3; i++){
			listaTresPrimeiros.add(rankingFinal.get(i).getCategoria());
		}
		
		return listaTresPrimeiros;
	}
	
	public int verificaRepeticoes(Vertex nome, Vertex amigo) {

		int cont = 0;

		for (int i = 0; i < nome.getVizinhos().size(); i++) {
			for (int j = 0; j < nome.getVizinhos().get(i).getVizinhos().size(); j++) {
				String aux = nome.getVizinhos().get(i).getVizinhos().get(j)
						.getName();
				if (!(aux.equals(nome.getName()))
						&& aux.equals(amigo.getName()))
					cont++;
			}
		}

		return cont;

	}
	
	@Override
	public List<Vertex> sugerirAmigos(String nome) throws FileNotFoundException, IOException, VerticeJaExisteException, ParDeVerticesNaoExistenteException {

		List<Vertex> listaPotenciaisAmigos = new ArrayList<Vertex>();
		Vertex vertex = null;
		Vertex amigo;

		// busca o vertice contendo nome
		for (int i = 0; i < GerarGrafo.getInstance().getListVertex().size(); i++) {
			if (nome.equals(GerarGrafo.getInstance().getListVertex().get(i).getName())) {
				vertex = GerarGrafo.getInstance().getListVertex().get(i);
			}
		}

		// varre os amigos de nome
		for (int j = 0; j < vertex.getVizinhos().size(); j++) {
			// varre os amigos dos amigos de nome
			for (int k = 0; k < vertex.getVizinhos().get(j).getVizinhos()
					.size(); k++) {
				amigo = vertex.getVizinhos().get(j).getVizinhos().get(k);
				if (verificaRepeticoes(vertex, amigo) > 2) {
					if (!listaPotenciaisAmigos.contains(amigo)) {
						System.out.println("adicionando " + amigo.getName());
						listaPotenciaisAmigos.add(amigo);
					}

				}
			}
		}

		for (int j = 0; j < vertex.getVizinhos().size(); j++) {
			if (listaPotenciaisAmigos.contains(vertex.getVizinhos().get(j))) {
				System.out.println("removendo "
						+ vertex.getVizinhos().get(j).getName());
				listaPotenciaisAmigos.remove(vertex.getVizinhos().get(j));
			}
		}

		return listaPotenciaisAmigos;

	}
}