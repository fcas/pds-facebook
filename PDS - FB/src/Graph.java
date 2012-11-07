package graph;

import java.util.Iterator;

public interface Graph {
	int getNumberOfEdges(); 
	int getNumberOfVertices(); 
	boolean isDirected(); 
	void addVertex(int v); 
	void addVertex(int v, Integer weight); 
	Vertex getVertex(int v); 
	void addEdge(int v, int w); 
	void addEdge(int v, int w, Integer weight); 
	Edge getEdge(int v, int w); 
	boolean isEdge(int v, int w); 
	Iterator getVertices(); 
	Iterator getEdges(); 
	void depthFirstTraversal(int startVertex); 
	void breadthFirstTraversal(int startVertex); 
}
