package model;

import java.util.ArrayList;
import java.util.List;

import com.restfb.types.Comment;

public class PostApi implements IPost {

	private List<String> usuariosComent = new ArrayList<String>();
	
	@Override
	public void setUsuariosComent(String nome) {
		//if (!(usuariosComent.contains(nome))) {
			usuariosComent.add(nome);
		//}
	}

	public List<String> getUsuariosComent() {
		return usuariosComent;
	}
	
	public void organizarLista() {
		for (int i=0; i<usuariosComent.size(); i++) {
			if (quantidade(usuariosComent.get(i).toString()) < 3) {
				usuariosComent.remove(i);
			}
		}
	}
	
	public int quantidade (String nome) {
		int quant = 0;
		for (int i=0; i<usuariosComent.size(); i++) {
			if (usuariosComent.equals(nome))
				quant++;
		}
		
		return quant;
	}
}
