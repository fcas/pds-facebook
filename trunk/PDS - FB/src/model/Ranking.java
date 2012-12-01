package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Ranking {
	/*NO VERTICE DO GRAFO, DETERMINAR A QUANTIDADE DE PONTOS QUE ELE TEM, PRA PODER FAZER O RANKING.
	 * CADA COISA EM COMUM: PÁGINA, GRUPO E ALGUM COMENTARIO EM POSTS. CADA UM VALE 1 PONTO
	 */
	
	private List<AmigoRanking> lista = new ArrayList();

	public List<AmigoRanking> getLista() {
		return lista;
	}
	
	public AmigoRanking amigoJaExiste (String ID) {
		for (int i=0; i<lista.size(); i++) {
			if (lista.get(i).getID().equals(ID))
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
