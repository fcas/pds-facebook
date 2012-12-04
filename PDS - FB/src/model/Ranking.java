package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Ranking {
	
	private List<AmigoRanking> lista = new ArrayList<AmigoRanking>();

	public List<AmigoRanking> getLista() {
		return lista;
	}
	
	public AmigoRanking amigoJaExisteID (String ID) {
		for (int i=0; i<lista.size(); i++) {
			if (lista.get(i).getID().equals(ID))
				return lista.get(i);
		}
		
		return null;
	}
	
	public AmigoRanking amigoJaExisteNome (String nome) {
		for (int i=0; i<lista.size(); i++) {
			if (lista.get(i).getNome().equals(nome))
				return lista.get(i);
		}
		
		return null;
	}
	
	public void ordenarRanking() {
	        Collections.sort(lista, new Comparator<AmigoRanking>() {  
	            @Override  
	            public int compare(AmigoRanking o1, AmigoRanking o2) {  
	                return o1.getPontos().compareTo(o2.getPontos());  
	            }  
	           
	     }); 
	}
	
}
