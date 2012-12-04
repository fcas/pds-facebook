/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;

import api.Cliente;

import com.restfb.Connection;
import com.restfb.Parameter;
import com.restfb.types.Page;

/**
 *
 * @author larissa
 */
public class PaginaApi implements IPagina {
    
    private String nome;
    private String ID;
    private String categoria;
    private long likes;
    private String link;

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setLikes(long likes) {
        this.likes = likes;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public String getCategoria() {
        return categoria;
    }

    @Override
    public long getLikes() {
        return likes;
    }

    @Override
    public String getLink() {
        return link;
    }

	@Override
	public void setID(String ID) {
		this.ID = ID;
	}

	@Override
	public String getID() {
		return ID;
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
    
}
