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
    
    //ver se vai passar o nome mesmo.
    public UsuarioApi (String nome) {
        user = Cliente.getInstance().fetchObject(nome, User.class);
        
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
    
    //ver opção de criar um metodo que faz a adaptação do List<Page> pra List<IPagina> na classe Pagina?!
    @Override
    public List<IPagina> buscarPaginasCurtidas() {
        Connection<Page> conexao = Cliente.getInstance().fetchConnection(username+"/likes", Page.class);
	List<Page> minhasPaginas = conexao.getData();
        
        List<IPagina> listaPaginas = null;
        
        for (int i=0; i<minhasPaginas.size(); i++) {
            Page p = Cliente.getInstance().fetchObject(minhasPaginas.get(i).getId(),
					Page.class);
            
            IPagina pagina = new PaginaApi();
            pagina.setNome(p.getName());
            pagina.setLink(p.getLink());
            pagina.setLikes(p.getLikes().toString());
            pagina.setCategoria(p.getCategory());
            listaPaginas.add(pagina);
            
        }
        
        return listaPaginas;
    }

    @Override
    public List<IPagina> buscarPaginasPalavraChave(String palavra) {
        Connection<Page> conexao = Cliente.getInstance().fetchConnection("search",
				Page.class, Parameter.with("q", palavra),
				Parameter.with("type", "page"));
        
        List<Page> paginas = conexao.getData();
        List<IPagina> listaPaginas = null;
        
        for (int i=0; i<paginas.size(); i++) {
            Page p = Cliente.getInstance().fetchObject(paginas.get(i).getId(),
					Page.class);
            
            IPagina pagina = new PaginaApi();
            pagina.setNome(p.getName());
            pagina.setLink(p.getLink());
            pagina.setLikes(p.getLikes().toString());
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
			System.out.println(amigosData.get(i).getId());
			amigosIDs.add(amigosData.get(i).getId());
		}
		
		return amigosIDs;
	}

	@Override
	public List<String> getAmigosNomes() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Vertex> buscarAmigos(String nome) throws FileNotFoundException, IOException, VerticeJaExisteException, ParDeVerticesNaoExistenteException {
		//GerarGrafo gerar = new GerarGrafo();
		
		List<Vertex> listaVertices = GerarGrafo.getInstance().buscarVerticeNome(nome);
		System.out.println(listaVertices.size());
//		for (int i=0; i<listaVertices.size(); i++) {
//			System.out.println(listaVertices.get(i).getName());
//		}
		
		return listaVertices;
	}

}
