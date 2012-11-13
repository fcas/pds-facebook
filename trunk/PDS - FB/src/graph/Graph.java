package graph;

import java.util.Iterator;
import visitor.Visitor;;

public interface Graph {
	
	int getNumberOfEdges();

	boolean isDirected();

	void addVertex(Vertex v);

	void addEdge(Edge edge);

	boolean isEdge(Vertex v, Vertex w);

	void depthFirstTraversal(Visitor visitor, int startVertex);

	void breadthFirstTraversal(int startVertex);

	public Vertex searchVertex(String id);

	public Edge removeEdge(String origemId, String destinoId);

	public Vertex removeVertex(String id);

	public int searchPositionVertex(String id);

	public Iterator<Edge> getEdges();

	public boolean existVertex(String id);

}
