package model;

import java.util.List;

public interface IPost {
	//COLOCAR OS SET
	public String getConteudo();
	public List<IComentario> getComentarios();
	
}
