package graph;

public interface Edge {
	Vertex getV0(); // vertice origem 
	Vertex getV1(); // vertice destino 
	Graph getGraph(); 
	Integer getWeight(); // obtencao de pe
	boolean isDirected(); 
	Vertex getMate(Vertex vertex); 
	// obtem o vertice da outra ponta 
}
