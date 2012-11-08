package graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class GraphAsList extends AbstractGraph3 {
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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getNumberOfVertices() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isDirected() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addVertex(int v) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addVertex(int v, Integer weight) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Vertex getVertex(int v) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addEdge(int v, int w) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addEdge(int v, int w, Integer weight) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Edge getEdge(int v, int w) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEdge(int v, int w) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator getVertices() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator getEdges() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void depthFirstTraversal(int startVertex) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void breadthFirstTraversal(int startVertex) {
		// TODO Auto-generated method stub
		
	} 
}
