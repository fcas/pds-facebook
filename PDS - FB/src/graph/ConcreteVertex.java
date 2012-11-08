package graph;

import java.util.LinkedList;

public class ConcreteVertex implements Vertex {
	private LinkedList<Vertex> listVertex = new LinkedList<Vertex>();
	private String name;
	private String birthday;
	private String id;
	
	public ConcreteVertex (String name, String birthday, String id) {
		this.name = name;
		this.birthday = birthday;
		this.id = id;
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

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return id;
	}

}
