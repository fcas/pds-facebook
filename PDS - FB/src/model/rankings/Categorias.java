package model.rankings;

public class Categorias {

	private String categoria;
	private int contador;
	
	public Categorias(String categoria) {
		this.categoria = categoria;
		this.contador = 0;
	}
	
	public int incrementadorCategoriaRanking(){
		this.contador++;
		return contador;
	}
	
	public Integer getContador() {
		return contador;
	}
	
	public String getCategoria() {
		return categoria;
	}
	
	
}
