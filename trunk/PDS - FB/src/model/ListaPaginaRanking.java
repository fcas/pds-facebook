package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class ListaPaginaRanking {
	
	List<PaginaRanking> listaPagina;
	
	public ListaPaginaRanking () {
		listaPagina = new ArrayList<PaginaRanking>();
	}
	
	public List<PaginaRanking> getListaPagina() {
		return listaPagina;
	}
	
	private PaginaRanking buscaPaginaRanking(IPagina pagina){
		PaginaRanking paginaRanking = null;
		IPagina paginaComparada = null;
		Iterator<PaginaRanking> iterator = listaPagina.iterator();
		
		while (iterator.hasNext()) //enquanto houver elementos na lista
		{
			paginaRanking = iterator.next();
			paginaComparada = paginaRanking.getPagina();
			if (paginaComparada.getNome().equals(pagina.getNome()))
				return paginaRanking;
		}
		return null;
	}
	
	public void adicionaPagina (IPagina pagina) {
		PaginaRanking paginaRanking = buscaPaginaRanking(pagina);
		
		if (paginaRanking != null){
			paginaRanking.incrementadorAmigoRanking();
		}else{
			PaginaRanking addPagina = new PaginaRanking(pagina);
			listaPagina.add(addPagina);
		}
	}
	
	public void ordenarRanking() {
		System.out.println("Ordenando páginas...");
        Collections.sort(listaPagina, new Comparator<PaginaRanking>() {
            @Override  
            public int compare(PaginaRanking o1, PaginaRanking o2) {  
                return o1.getPopularidade().compareTo(o2.getPopularidade());
            }  
        }				);
        
        System.out.println("Páginas ordenadas.");
	}
	
	/**
	 * Aplica às páginas curtidas pelos amigos do usuário, o índice de popularidade baseado em categorias mais curtidas pelo usuário.
	 * @param listaStrings Lista de Strings contendo as categorias mais curtidas pelo usuário
	 */
	public void aplicarCategoriasMaisCurtidas(List<String> listaStrings){
		System.out.println("Aplicando índices de categoria...");
		PaginaRanking paginaRanking = null;
		Iterator<PaginaRanking> iterator = listaPagina.iterator();
		
		for (int i = 0; i < listaStrings.size(); i++) //para cada String da lista recebida como parâmetro
		{//percorre a lista de páginas curtidas
			while (iterator.hasNext()) //enquanto houver elementos na lista
			{
				 paginaRanking = iterator.next(); //pega uma página curtida
				 if (paginaRanking.getPagina().getCategoria().equals(listaStrings.get(i))) //se a categoria dessa página for uma das categorias que o usuário tem mais interesse
					 paginaRanking.incrementadorCategoria(); //aplicar índice.
			}
		}
	System.out.println("Índices de categoria aplicados.");
	}
	
	
	
	
	
	
	
}