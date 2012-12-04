package model.rankings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class RankingCategorias {
	
	private List<Categorias> listaCategoria;
	
	public RankingCategorias() {
		listaCategoria = new ArrayList<Categorias>();
	}
	
	public List<Categorias> getListaCategoria() {
		return listaCategoria;
	}
	
	private Categorias buscaCategoriaRanking(String categoria){
		Categorias categoriaRanking = null;
		String stringComparada = null;
		Iterator<Categorias> iterator = listaCategoria.iterator();
		
		while (iterator.hasNext()) //enquanto houver elementos na lista
		{
			categoriaRanking = iterator.next();
			stringComparada = categoriaRanking.getCategoria();
			if (stringComparada.equals(categoria))
				return categoriaRanking;
		}
		return null;
	}
	
	public void adicionaCategoria (String categoria) {
		Categorias categoriaRanking = buscaCategoriaRanking(categoria);
		
		if (categoriaRanking != null){
			categoriaRanking.incrementadorCategoriaRanking();
		}else{
			Categorias addCategoria = new Categorias(categoria);
			listaCategoria.add(addCategoria);
		}
	}
	
	public void ordenarRanking() {
        Collections.sort(listaCategoria, new Comparator<Categorias>() {  
            @Override  
            public int compare(Categorias o1, Categorias o2) {  
                return o1.getContador().compareTo(o2.getContador());
            }  
        }				);
        
	}
	
	
	

}
