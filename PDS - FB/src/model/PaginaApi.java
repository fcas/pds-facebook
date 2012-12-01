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
    private String categoria;
    private String likes;
    private String link;

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setLikes(String likes) {
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
    public String getLikes() {
        return likes;
    }

    @Override
    public String getLink() {
        return link;
    }
    
}
