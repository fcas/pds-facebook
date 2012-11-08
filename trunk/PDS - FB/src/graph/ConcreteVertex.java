package graph;

import java.util.Iterator;

public class ConcreteVertex implements Vertex {

	private String aniversario; 
	private String nome; 
	private String ID;
	
	public String getAniversario() {
		return aniversario;
	}

	public void setAniversario(String aniversario) {
		this.aniversario = aniversario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	@Override
	public int getNumber() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Integer getWeight() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Graph getGraph() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator getIncidentEdges() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator getEmanatingEdges() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator getPredecessors() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator getSuccessors() {
		// TODO Auto-generated method stub
		return null;
	}

}
