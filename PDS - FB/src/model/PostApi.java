package model;

import java.util.ArrayList;
import java.util.List;

import api.Cliente;

import com.restfb.Connection;
import com.restfb.types.Comment;
import com.restfb.types.Post;

public class PostApi implements IPost {
	
	private String conteudo;
	private List<IComentario> listaComentarios = new ArrayList();
	
	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
	
	public void setComentarios(List<Comment> comentario) {
		for (int i=0; i<comentario.size(); i++) {
			IComentario c = new ComentarioApi();
			c.setMensagem(comentario.get(i).getMessage());
			c.setUsuario(comentario.get(i).getFrom().getName());
			listaComentarios.add(c);
		}
	}
	
	@Override
	public String getConteudo() {
		return conteudo;
	}

	@Override
	public List<IComentario> getComentarios() {
		return listaComentarios;
	}

}
