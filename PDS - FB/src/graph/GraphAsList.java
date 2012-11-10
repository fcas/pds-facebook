package graph;

import java.util.LinkedList;

public class GraphAsList extends AbstractGraph3 {

	private LinkedList<LinkedList<Edge>> adjacencyList;
	private LinkedList<Vertex> vertexList;

	public GraphAsList() {
		vertexList = new LinkedList();
		adjacencyList = new LinkedList();
	}

	public Vertex searchVertex(String id) {
		Vertex retorno = null;
		for (int i = 0; i < vertexList.size(); i++) {
			if (id == vertexList.get(i).getId()) {
				retorno = vertexList.get(i);
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
			vertexList.add(v);
	    }
	}
}
