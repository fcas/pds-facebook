package graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

	/**Cria um boolean[] auxiliar e chama o metodo concreto de percorrimento**/
	public void depthFirstTraversal(Visitor visitor, int start, List<Vertex> list) {
		
		boolean[] visited = new boolean[vertexList.size()];
		for (int i = 0; i < vertexList.size(); ++i) {
			visited[i] = false;
		}
		depthFirstTraversal(visitor, vertexList.get(start), visited, list);
	}

	/**Percorre o grafo em profundidade chamando o metodo accept de todos os vertices e
	 * adiciona numa lista ligada todos os vertices que percorre**/
	private void depthFirstTraversal(Visitor visitor, Vertex v,
			boolean[] visited, List<Vertex> list) {
		
		((ConcreteVertex) v).accept(visitor);
		visited[searchPositionVertex(v.getId())] = true;
		list.add(v);

		Iterator<Edge> p = adjacencyList;

		while (p.hasNext()) {
			Vertex to = p.next().getDestino();
			if (!visited[searchPositionVertex(to.getId())])
				depthFirstTraversal(visitor, to, visited, list);
		}
	}
	
	/**Percorre o grafo em largura chamando o metodo accept de todos os vertices e
	 * adiciona numa lista ligada todos os vertices que percorre**/
	public void breadthFirstTraversal(Visitor visitor, int start, List<Vertex> list) {
		boolean enqueued[] = new boolean[vertexList.size()];
		
		Queue<Vertex> queue = new LinkedList<Vertex>();
		
		enqueued[start] = true;
		queue.add(vertexList.get(start));
		
		
		while (!queue.isEmpty()){
			Vertex vertex = queue.remove();
			((ConcreteVertex) vertex).accept(visitor);
			list.add(vertex);
			Iterator<Edge> sucessors = adjacencyList;
			
			//Enfileira os sucessores
			while (sucessors.hasNext()) {
				Vertex next = sucessors.next().getDestino();
				if (!enqueued[searchPositionVertex(next.getId())]){
					enqueued[searchPositionVertex(next.getId())] = true;
					queue.add(next);
				}
					
			}
		}
	}
}