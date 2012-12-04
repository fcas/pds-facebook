/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;


/**
 *
 * @author larissa
 */
public interface IPagina {
   
    public void setNome (String nome);
    public void setID(String ID);
    public void setCategoria (String categoria);
    public void setLikes (long likes);
    public void setLink (String link);
    public String getNome();
    public String getID();
    public String getCategoria();
    public long getLikes();
    public String getLink();
    public List<IPagina> buscarPaginasPalavraChave(String palavra);
    
}
