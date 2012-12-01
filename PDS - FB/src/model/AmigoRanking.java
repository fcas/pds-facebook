package model;

public class AmigoRanking {
	private String ID;
	private String nome;
	private int pontos;
	
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getPontos() {
		return pontos;
	}
	public void setPontos(int pontos) {
		this.pontos = pontos;
	}
	
	public void incrementaPontos(int num) {
		pontos = pontos + num;
	}
	
}
