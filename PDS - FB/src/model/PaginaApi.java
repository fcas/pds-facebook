/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

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
    
}
