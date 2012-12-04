package model.rankings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import model.IPagina;

public class RankingPaginas {
	
	private List<Paginas> listaPagina;
	
	public RankingPaginas () {
		listaPagina = new ArrayList<Paginas>();
	}
	
	public List<Paginas> getListaPagina() {
		return listaPagina;
	}
	
	private Paginas buscaPaginaRanking(IPagina pagina){
		Paginas paginaRanking = null;
		IPagina paginaComparada = null;
		Iterator<Paginas> iterator = listaPagina.iterator();
		
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
		Paginas paginaRanking = buscaPaginaRanking(pagina);
		
		if (paginaRanking != null){
			paginaRanking.incrementadorAmigoRanking();
		}else{
			Paginas addPagina = new Paginas(pagina);
			listaPagina.add(addPagina);
		}
	}
	
	public void ordenarRanking() {
		System.out.println("Ordenando paginas...");
        Collections.sort(listaPagina, new Comparator<Paginas>() {
            @Override  
            public int compare(Paginas o1, Paginas o2) {  
                return o1.getPopularidade().compareTo(o2.getPopularidade());
            }  
        }				);
        
        System.out.println("Paginas ordenadas.");
	}
	
	/**
	 * Aplica �s p�ginas curtidas pelos amigos do usu�rio, o �ndice de popularidade baseado em categorias mais curtidas pelo usu�rio.
	 * @param listaStrings Lista de Strings contendo as categorias mais curtidas pelo usu�rio
	 */
	public void aplicarCategoriasMaisCurtidas(List<String> listaStrings){
		System.out.println("Aplicando indices de categoria...");
		Paginas paginaRanking = null;
		Iterator<Paginas> iterator = listaPagina.iterator();
		
		for (int i = 0; i < listaStrings.size(); i++) //para cada String da lista recebida como par�metro
		{//percorre a lista de p�ginas curtidas
			while (iterator.hasNext()) //enquanto houver elementos na lista
			{
				 paginaRanking = iterator.next(); //pega uma p�gina curtida
				 if (paginaRanking.getPagina().getCategoria().equals(listaStrings.get(i))) //se a categoria dessa p�gina for uma das categorias que o usu�rio tem mais interesse
					 paginaRanking.incrementadorCategoria(); //aplicar �ndice.
			}
		}
	System.out.println("indices de categoria aplicados.");
	}
	
	
	
	
	
	
	
}