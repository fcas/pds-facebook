package graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

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

	/**Retorna um vertice da lista buscando pela String "id". Retorna null caso o vertice nao seja encontrado**/
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

	/**Tenta remover uma aresta e retorna-a. Caso os vertices passados como parametro sejam invalidos, lanca excecao.**/
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

	/**Tenta remover um vertice e o retorna. Caso o vertice nao exista, lanca excecao**/
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

	/**Retorna um inteiro correspondente a posicao do vertice na lista de vertices buscando pelo id. Retorna -1 caso o vertice nao exista**/
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

	/**Retorna as arestas do grafo**/
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

	/**Retorna true caso exista uma aresta com o id passado por parametro ou false caso contrario.**/
	@Override
	public boolean existVertex(String id) {
		return (searchVertex(id) != null);
	}

	/**Retorna um inteiro correspondente a quantidade de arestas**/
	@Override
	public int getNumberOfEdges() {
		return super.numberOfEdges;
	}

	/**Retorna true se o grafo for direcionado e false caso contrario**/
	@Override
	public boolean isDirected() {
		return false;
	}

	/**Percorre o grafo em profundidade, chamando o visitor passado por parametro**/
	@Override
	public void depthFirstTraversal(Visitor visitor, int startVertex, List<Vertex> list) {
		super.depthFirstTraversal(visitor, startVertex, list);
	}
	
	/**Percorre o grafo em largura, chamando o visitor passado por parametro**/
	@Override
	public void breadthFirstTraversal(Visitor visitor, int start, List<Vertex> list){
		super.breadthFirstTraversal(visitor, start, list);
	}

	/**Adiciona uma aresta entre dois vertices existentes. Lanca excecao caso um vertice seja invalido**/
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

	/**Retorna true caso exista alguma aresta entre os vertices indicados ou false caso contratio**/
	@Override
	public boolean isEdge(Vertex v, Vertex w) {
		for (int i = 0; i < v.getVizinhos().size(); i++) {
			if (v.getVizinhos().get(i) == w)
				return true;
		}
		return false;
	}

	/**Cria um vertice. Caso esse vertice ja exista, lanca excecao**/
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