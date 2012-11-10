package graph;

import java.util.LinkedList;

public abstract class AbstractGraph3 implements Graph {
	protected int numberOfVertices; 
	protected int numberOfEdges; 
	protected LinkedList<Vertex> vertex; 
	
	public AbstractGraph3(){ 
		vertex = new LinkedList(); 
	}
	 
}
