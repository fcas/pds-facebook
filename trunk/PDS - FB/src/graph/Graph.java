package graph;

import java.util.Iterator;

import tests.ParDeVerticesNaoExistenteException;
import tests.VerticeJaExisteException;
import tests.VerticeNaoExisteException;
import visitor.Visitor;;

public interface Graph {
	
	int getNumberOfEdges();

	boolean isDirected();

	void addVertex(Vertex v) throws VerticeJaExisteException;

	void addEdge(Edge edge) throws ParDeVerticesNaoExistenteException;

	boolean isEdge(Vertex v, Vertex w);

	void depthFirstTraversal(Visitor visitor, int startVertex);

	void breadthFirstTraversal(Visitor visitor, int startVertex);

	public Vertex searchVertex(String id);

	public Edge removeEdge(String origemId, String destinoId) throws ParDeVerticesNaoExistenteException;

	public Vertex removeVertex(String id) throws VerticeNaoExisteException;

	public int searchPositionVertex(String id);

	public Iterator<Edge> getEdges();

	public boolean existVertex(String id);

}
