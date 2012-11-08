package graph;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractGraph implements Graph {
	protected int numberOfVertex; 
	protected int numberOfEdges; 
	protected List<Vertex> listVertex; 
	
	public AbstractGraph(int size){ 
		listVertex = new ArrayList<Vertex>(); 
		this.numberOfVertex = size; 
	} 
	
//	public void depthFirst(Visitor visitor, int start) {
//		boolean[] visited = new boolean[numberOfVertices];
//		for (int i; i<numberOfVertices; ++i) {
//			visited[i] = false;
//		}
//		
//	}
}
