package graph;

import java.util.LinkedList;
import apifb.Data;

public class ConcreteVertex implements Vertex {
	private LinkedList<Vertex> listVertex = new LinkedList<Vertex>();
	private String name;
	private Data birthday;
	private String id;

	public ConcreteVertex(String name, Data data, String id) {
		this.name = name;
		this.birthday = data;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public Data getBirthday() {
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
