package graph;

import java.util.Iterator;
import java.util.LinkedList;
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
			depthFirstTraversal(visitor, vertexList.get(start), visited);
		}

	}

	private void depthFirstTraversal(Visitor visitor, Vertex v,
			boolean[] visited) {

		if (visitor.isDone())
			return;

		visitor.visit((ConcreteVertex) v);
		visited[searchPositionVertex(v.getId())] = true;
		// LinkedList<Vertex> p = v.getVizinhos();
		//
		// for (int i = 0; i < p.size(); i++) {
		//
		// System.out.println(p.get(i).getName());
		// }
		//
		//
		// for (int i = 0; i < p.size(); i++) {
		// Vertex to = p.get(i);
		// if (!visited[searchPositionVertex(v.getId())])
		// depthFirstTraversal(visitor, to, visited);
		// }

		Iterator<Edge> p = adjacencyList;

		// DESCOMENTA PARA VER QUE A LEITURA DA LISTA DE ADJACENCIAS ESTÁ
		// CORRETA.
		// while (p.hasNext()) {
		// System.out.println(p.next().getDestino().getName());
		// }

		while (p.hasNext()) {
			Vertex to = p.next().getDestino();
			if (!visited[searchPositionVertex(v.getId())])
				depthFirstTraversal(visitor, to, visited);
		}

	}

}