package model.rankings;

import model.IPagina;

public class Paginas {
	private IPagina pagina;
	private int popularidade;
	
	public Paginas(IPagina pagina) {
		this.pagina = pagina;
		popularidade = 1;
	}
	
	public int incrementadorAmigoRanking (){
		this.popularidade++;
		return popularidade;
	}
	
	public int incrementadorCategoria (){
		this.popularidade += 3;
		return popularidade;
	}
	
	public Integer getPopularidade() {
		return popularidade;
	}
	
	public IPagina getPagina() {
		return pagina;
	}
}
