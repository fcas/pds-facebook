package graph;

import java.util.LinkedList;
import java.util.List;

public class GraphAsList extends AbstractGraph {
	private List<Edge>[] adjacencyList; 
	
	public GraphAsList(int size){ 
		super(size); 
		this.adjacencyList = new LinkedList[size]; 
		for (int i=0; i < size; ++i){ 
				this.adjacencyList[i] = new LinkedList<Edge>(); 
		} 
	}

	@Override
	public int getNumberOfEdges() {
		return super.numberOfEdges;
	}

	@Override
	public int getNumberOfVertices() {
		return super.numberOfVertex;
	}

	@Override
	public boolean isDirected() {
		return false;
	}
	
	@Override
	public void depthFirstTraversal(int startVertex) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void breadthFirstTraversal(int startVertex) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addEdge(Vertex v, Vertex w) {//verificar se ja existe
		v.getVizinhos().add(w);
		w.getVizinhos().add(v);
	}

	@Override
	public boolean isEdge(Vertex v, Vertex w) {
		for (int i = 0; i < v.getVizinhos().size(); i++) {
			if (v.getVizinhos().get(i) == w)
				return true;
		}
		return false;
	}

	@Override
	public void addVertex(Vertex v) {	
		
		super.listVertex.add(v);
	} 
}
