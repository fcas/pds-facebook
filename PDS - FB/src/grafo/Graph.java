package grafo;

import java.util.List;

import tests.ParDeVerticesNaoExistenteException;
import tests.VerticeJaExisteException;
import visitor.Visitor;;

public interface Graph {

	boolean isDirected();

	void addVertex(Vertex v) throws VerticeJaExisteException;

	void addEdge(Edge edge) throws ParDeVerticesNaoExistenteException;

	void depthFirstTraversal(Visitor visitor, int startVertex, List<Vertex> list);

	void breadthFirstTraversal(Visitor visitor, int startVertex, List<Vertex> list);

	public Vertex searchVertex(String id);

	public int searchPositionVertex(String id);

	public boolean existVertex(String id);
	
	public List<Vertex> buscarVerticeNome(String nome);
	
	public List<Vertex> sugerirAmigos(String nome);

}
