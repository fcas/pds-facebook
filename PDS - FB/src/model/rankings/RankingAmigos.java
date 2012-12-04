package model.rankings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class RankingAmigos {
	
	private List<Amigos> lista = new ArrayList<Amigos>();

	public List<Amigos> getLista() {
		return lista;
	}
	
	public Amigos amigoJaExisteID (String ID) {
		for (int i=0; i<lista.size(); i++) {
			if (lista.get(i).getID().equals(ID))
				return lista.get(i);
		}
		
		return null;
	}
	
	public Amigos amigoJaExisteNome (String nome) {
		for (int i=0; i<lista.size(); i++) {
			if (lista.get(i).getNome().equals(nome))
				return lista.get(i);
		}
		
		return null;
	}
	
	public void ordenarRanking() {
	        Collections.sort(lista, new Comparator<Amigos>() {  
	            @Override  
	            public int compare(Amigos o1, Amigos o2) {  
	                return o1.getPontos().compareTo(o2.getPontos());  
	            }  
	           
	     }); 
	}
	
}
