package model;

public class PaginaRanking {
	private IPagina pagina;
	private int popularidade;
	
	public PaginaRanking(IPagina pagina) {
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
