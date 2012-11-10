package graph;

import java.util.LinkedList;
import java.util.List;

public class GraphAsList extends AbstractGraph {
	private LinkedList<Edge>[] adjacencyList;

	public GraphAsList(int size) {
		super(size);
		this.adjacencyList = new LinkedList[size];
		for (int i = 0; i < size; ++i) {
			this.adjacencyList[i] = new LinkedList<Edge>();
		}
	}

	public Vertex searchVertex(String id) {
		Vertex retorno = null;
		for (int i = 0; i < super.listVertex.size(); i++) {
			if (id == super.listVertex.get(i).getId()) {
				retorno = super.listVertex.get(i);
			}
		}
		return retorno;
	}

	public boolean existVertex(String id) {
		return (searchVertex(id) != null);
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
	public void addEdge(Vertex v, Vertex w) {// verificar se ja existe
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
		if (!existVertex(v.getId())){
			super.listVertex.add(v);
	    }
	}
}
