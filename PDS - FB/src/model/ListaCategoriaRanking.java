package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class ListaCategoriaRanking {
	
	List<CategoriaRanking> listaCategoria;
	
	public ListaCategoriaRanking() {
		listaCategoria = new ArrayList<CategoriaRanking>();
	}
	
	public List<CategoriaRanking> getListaCategoria() {
		return listaCategoria;
	}
	
	private CategoriaRanking buscaCategoriaRanking(String categoria){
		CategoriaRanking categoriaRanking = null;
		String stringComparada = null;
		Iterator<CategoriaRanking> iterator = listaCategoria.iterator();
		
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
		CategoriaRanking categoriaRanking = buscaCategoriaRanking(categoria);
		
		if (categoriaRanking != null){
			categoriaRanking.incrementadorCategoriaRanking();
		}else{
			CategoriaRanking addCategoria = new CategoriaRanking(categoria);
			listaCategoria.add(addCategoria);
		}
	}
	
	public void ordenarRanking() {
        Collections.sort(listaCategoria, new Comparator<CategoriaRanking>() {  
            @Override  
            public int compare(CategoriaRanking o1, CategoriaRanking o2) {  
                return o1.getContador().compareTo(o2.getContador());
            }  
        }				);
        
	}
	
	
	

}
