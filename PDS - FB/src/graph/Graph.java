package graph;

public interface Graph {
	int getNumberOfEdges(); 
	boolean isDirected(); 
	void addVertex(Vertex v); 
	void addEdge(Vertex v, Vertex w);
	boolean isEdge(Vertex v, Vertex w); 
	void depthFirstTraversal(int startVertex); 
	void breadthFirstTraversal(int startVertex);
	public Vertex searchVertex(String id);
}
