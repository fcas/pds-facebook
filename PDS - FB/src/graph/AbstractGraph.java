package graph;

import java.util.Iterator;
import java.util.List;
import visitor.Visitor;

public abstract class AbstractGraph implements Graph {

	protected int numberOfEdges;
	protected List<Vertex> vertexList;
	protected int numberOfVertex;
	private Iterator<Edge> adjacencyList;

	public List<Vertex> getListVertex() {
		return vertexList;
	}

	public void setAdjacencyList(Iterator<Edge> iterator) {
		this.adjacencyList = iterator;
	}

	public void depthFirstTraversal(Visitor visitor, int start) {
		boolean[] visited = new boolean[vertexList.size()];
		for (int i = 0; i < vertexList.size(); ++i) {
			visited[i] = false;
		}
		depthFirstTraversal(visitor, vertexList.get(start), visited);

	}

	private void depthFirstTraversal(Visitor visitor, Vertex v,
			boolean[] visited) {

		((ConcreteVertex) v).accept(visitor);
		visited[searchPositionVertex(v.getId())] = true;

		Iterator<Edge> p = adjacencyList;

		while (p.hasNext()) {
			Vertex to = p.next().getDestino();
			if (!visited[searchPositionVertex(to.getId())])
				depthFirstTraversal(visitor, to, visited);
		}

	}

}