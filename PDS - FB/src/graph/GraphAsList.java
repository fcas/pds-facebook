package graph;

import java.util.Iterator;
import java.util.LinkedList;

public class GraphAsList extends AbstractGraph3 {

	private LinkedList<LinkedList<Edge>> adjacencyList;
	private LinkedList<Vertex> vertexList;

	public GraphAsList() {
		vertexList = new LinkedList();
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
	public Edge removeEdge(String origemId, String destinoId){
		Edge retorno = null;
		int posicaoOrigem = searchPositionVertex(origemId);
		int posicaoDestino =searchPositionVertex(destinoId);
		Iterator<Edge> arestaIterador = adjacencyList.get(posicaoOrigem)
				.iterator();
		Edge arestaAux;
		if (posicaoOrigem != -1 && posicaoDestino != -1) {
			while (arestaIterador.hasNext() && retorno == null) {
				arestaAux = arestaIterador.next();
				if (arestaAux.getDestino().getId() == destinoId) {
					adjacencyList.get(posicaoOrigem).remove(arestaAux);
					retorno = arestaAux;
				}
			}
		} else {
			System.out.println("Par de vértices não existe");
		}
		return retorno;
	}

	@Override
	public Vertex removeVertex(String id) {
		Vertex retorno = null;
		int posicaoVertice = searchPositionVertex(id);
		if (posicaoVertice != -1) {
			vertexList.remove(posicaoVertice);
			adjacencyList.remove(posicaoVertice);
		} else {
			System.out.println("Vértice com Id = " + id + " não Existe");
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
		LinkedList<Edge> arestas = new LinkedList();
		Iterator<Edge> arestasIterador;
		for (int i = 0; i < vertexList.size(); i++) {
			arestasIterador = adjacencyList.get(i).iterator();
			while (arestasIterador.hasNext()) {
				arestas.add(arestasIterador.next());
			}
		}
		return arestas.iterator();
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
	public void depthFirstTraversal(int startVertex) {
		// TODO Auto-generated method stub

	}

	@Override
	public void breadthFirstTraversal(int startVertex) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addEdge(Edge edge) {// verificar se ja existe
		int posicaoOrigem = searchPositionVertex((edge.getOrigem().getId()));
		int posicaoDestino = searchPositionVertex(edge.getDestino().getId());
		if (posicaoOrigem != -1 && posicaoDestino != -1) {
			adjacencyList.get(posicaoOrigem).add(edge);
			System.out.println(edge.getOrigem().getName() + " tem amizade com "
					+ edge.getDestino().getName());
		} else {
			System.out.println("Par de vértices não existe");
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
	public void addVertex(Vertex v) {
		if (!existVertex(v.getId())) {
			vertexList.add(v);
			adjacencyList.add(new LinkedList());
		}
	}
}
