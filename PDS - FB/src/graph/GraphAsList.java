package graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import tests.ParDeVerticesNaoExistenteException;
import tests.VerticeJaExisteException;
import tests.VerticeNaoExisteException;
import visitor.Visitor;

public class GraphAsList extends AbstractGraph {
	private LinkedList<LinkedList<Edge>> adjacencyList;

	public GraphAsList() {
		super.vertexList = new ArrayList<Vertex>();
		adjacencyList = new LinkedList();
	}

	@Override
	public Vertex searchVertex(String id) {
		Vertex retorno = null;
		for (int i = 0; i < vertexList.size(); i++) {
			if (id == vertexList.get(i).getId()) {
				retorno = vertexList.get(i);
			}
		}
		return retorno;
	}

	@Override
	public Edge removeEdge(String origemId, String destinoId) throws ParDeVerticesNaoExistenteException {
		Edge retorno = null;
		int posicaoOrigem = searchPositionVertex(origemId);
		int posicaoDestino = searchPositionVertex(destinoId);
		Iterator<Edge> EdgeIterador = adjacencyList.get(posicaoOrigem)
				.iterator();
		Edge EdgeAux;
		if (posicaoOrigem != -1 && posicaoDestino != -1) {
			while (EdgeIterador.hasNext() && retorno == null) {
				EdgeAux = EdgeIterador.next();
				if (EdgeAux.getDestino().getId() == destinoId) {
					adjacencyList.get(posicaoOrigem).remove(EdgeAux);
					retorno = EdgeAux;
				}
			}
		} else {
			throw new ParDeVerticesNaoExistenteException();
		}
		return retorno;
	}

	@Override
	public Vertex removeVertex(String id) throws VerticeNaoExisteException{
		Vertex retorno = null;
		int posicaoVertice = searchPositionVertex(id);
		if (posicaoVertice != -1) {
			vertexList.remove(posicaoVertice);
			adjacencyList.remove(posicaoVertice);
		} else {
			throw new VerticeNaoExisteException(id);
		}
		return retorno;
	}

	@Override
	public int searchPositionVertex(String id) {
		int retorno = -1;
		for (int i = 0; i < vertexList.size(); i++) {
			if (id == vertexList.get(i).getId()) {
				retorno = i;
			}
		}
		return retorno;
	}

	@Override
	public Iterator<Edge> getEdges() {
		LinkedList<Edge> Edges = new LinkedList();
		Iterator<Edge> EdgesIterador;
		for (int i = 0; i < vertexList.size(); i++) {
			EdgesIterador = adjacencyList.get(i).iterator();
			while (EdgesIterador.hasNext()) {
				Edges.add(EdgesIterador.next());
			}
		}
		return Edges.iterator();
	}

	@Override
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
	public void depthFirstTraversal(Visitor visitor, int startVertex) {
		super.depthFirstTraversal(visitor, startVertex);
	}
	
	@Override
	public void breadthFirstTraversal(Visitor visitor, int start){
		super.breadthFirstTraversal(visitor, start);
	}

	@Override
	public void addEdge(Edge edge) throws ParDeVerticesNaoExistenteException {
		int posicaoOrigem = searchPositionVertex((edge.getOrigem().getId()));
		int posicaoDestino = searchPositionVertex(edge.getDestino().getId());
		if (posicaoOrigem != -1 && posicaoDestino != -1) {
			adjacencyList.get(posicaoOrigem).add(edge);
		} else {
			throw new ParDeVerticesNaoExistenteException();
		}
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
	public void addVertex(Vertex v) throws VerticeJaExisteException {
		if (!existVertex(v.getId())) {
			vertexList.add(v);
			adjacencyList.add(new LinkedList());
		} else {
			throw new VerticeJaExisteException(); 
		}
	}
	

}