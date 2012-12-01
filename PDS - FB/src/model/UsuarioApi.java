/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import api.Cliente;
import com.restfb.Connection;
import com.restfb.Parameter;
import com.restfb.types.Group;
import com.restfb.types.Page;
import com.restfb.types.User;

import grafo.GerarGrafo;
import grafo.Vertex;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
    
    private List<IPagina> paginasCurtidas = buscarPaginasCurtidas();
    
    private Ranking ranking = new Ranking();
    
    //ver se vai passar o nome mesmo.
    public UsuarioApi (String username) {
        user = Cliente.getInstance().fetchObject(username, User.class);
        
        this.setNome(user.getName());
        this.setID(user.getId());
        this.setCidade(user.getLocale());
        this.setUsername(user.getUsername());
        
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
        
        List<IPagina> listaPaginas = new ArrayList<IPagina>();;
        
        for (int i=0; i<minhasPaginas.size(); i++) {
//            Page p = Cliente.getInstance().fetchObject(minhasPaginas.get(i).getId(),
//					Page.class);
            
            IPagina pagina = new PaginaApi();
            pagina.setNome(minhasPaginas.get(i).getName());
            pagina.setLink(minhasPaginas.get(i).getLink());
            //pagina.setLikes(minhasPaginas.get(i).getLikes().toString());
            pagina.setCategoria(minhasPaginas.get(i).getCategory());
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
			//System.out.println(amigosData.get(i).getId());
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
		
		List<Vertex> listaVertices = GerarGrafo.getInstance().buscarListaNomes(nome);
		//System.out.println(listaVertices.size());
		
		return listaVertices;
	}
	
	//retorna os Nomes dos amigos
	@Override
	public List<String> buscarAmigosMaiorAfinidade() throws FileNotFoundException, IOException, VerticeJaExisteException, ParDeVerticesNaoExistenteException {
		
		/*CRITERIO = PAGINAS. COLOCAR EM ARQUIVO PARA MELHORAR DESEMPENHO*/
		List<String> listaAmigosIDs = getAmigosIDs();
		
		for (int i=0; i<listaAmigosIDs.size(); i++) {
			//System.out.println("BUSCANDO PARA AMIGO " + listaAmigosIDs.get(i).toString());
			int quantPaginas = paginasEmComum(listaAmigosIDs.get(i).toString());
			if (quantPaginas >= 15) {//ESSE CRITÉRIO PODE SER MUDADO
					
					AmigoRanking amigo = ranking.amigoJaExiste(listaAmigosIDs.get(i).toString());
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
			if (quantGrupos > 2) {//ESSE CRITÉRIO PODE SER MUDADO
				
				AmigoRanking amigo = ranking.amigoJaExiste(listaAmigosIDs.get(i).toString());
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
		
		return listaAmigosIDs;//AJEITAR ESSE RETURN
		
	}
	
	public int paginasEmComum (String ID) {
		
		//System.out.println("BUSCANDO PAGINAS QUE EU CURTO");
		
        Connection<Page> conexao = Cliente.getInstance().fetchConnection(ID+"/likes", Page.class);
        List<Page> paginasAmigo = conexao.getData();
        
        //System.out.println("AMIGO " + ID + " CURTE " + paginasAmigo.size() + " PAGINAS");
        List<IPagina> listaPaginas = new ArrayList<IPagina>();
        
        for (int i=0; i<paginasAmigo.size(); i++) {
            //Page p = Cliente.getInstance().fetchObject(paginasAmigo.get(i).getId(),
					//Page.class);
            
            IPagina pagina = new PaginaApi();
            pagina.setNome(paginasAmigo.get(i).getName());
            pagina.setLink(paginasAmigo.get(i).getLink());
            pagina.setCategoria(paginasAmigo.get(i).getCategory());
            listaPaginas.add(pagina);
            
        }
        
        List<IPagina> paginasComuns = new ArrayList<IPagina>();
        
	        for (int i=0; i<paginasCurtidas.size(); i++) {
	        	for (int j=0; j<listaPaginas.size(); j++) {
		        	if (listaPaginas.get(j).getNome().equals(paginasCurtidas.get(i).getNome()))
		        		paginasComuns.add(paginasCurtidas.get(i));
	        	}
	        }

        //System.out.println("TAMANHO DA LISTA DE PAGINAS EM COMUM = " + paginasComuns.size());
        return paginasComuns.size();
		
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

}
