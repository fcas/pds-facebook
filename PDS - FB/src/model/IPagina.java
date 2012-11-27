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
    public void setCategoria (String categoria);
    public void setLikes (String likes);
    public void setLink (String link);
    public String getNome();
    public String getCategoria();
    public String getLikes();
    public String getLink();
    
}
