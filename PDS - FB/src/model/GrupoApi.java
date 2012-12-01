package model;

public class GrupoApi implements IGrupo {
	private String ID;
	private String link;
	private String nome;

	@Override
	public void setID(String ID) {
		this.ID = ID;
	}

	@Override
	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public void setLink(String link) {
		this.link = link;
	}

	@Override
	public String getID() {
		return ID;
	}

	@Override
	public String getNome() {
		return nome;
	}

	@Override
	public String getLink() {
		return link;
	}

}
