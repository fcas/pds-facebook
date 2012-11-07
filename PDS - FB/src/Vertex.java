package graph;

import java.util.Iterator;

public interface Vertex {
	int getNumber(); // Obtem id do vertice 
	Integer getWeight(); 
	Graph getGraph(); 
	Iterator getIncidentEdges(); // arestas que chegam 
	Iterator getEmanatingEdges(); // arestas que saem 
	Iterator getPredecessors(); // vertices predecessores 
	Iterator getSuccessors(); // vertices sucesssores 
}
