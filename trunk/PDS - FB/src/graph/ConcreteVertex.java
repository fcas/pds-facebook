package graph;

import java.util.LinkedList;

public class ConcreteVertex implements Vertex {
	private LinkedList<Vertex> listVertex = new LinkedList<Vertex>();
	private String name;
	private String birthday;
	
	public ConcreteVertex (String name, String birthday) {
		this.name = name;
		this.birthday = birthday;
	}
	
	public String getName() {
		return name;
	}
	
	public String getBirthday() {
		return birthday;
	}
	
	@Override
	public LinkedList<Vertex> getVizinhos() {
		return listVertex;
	}

}
