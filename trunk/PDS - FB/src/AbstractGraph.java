package graph;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractGraph implements Graph {
	protected int numberOfVertices; 
	protected int numberOfEdges; 
	protected List vertex; 
	
	public AbstractGraph(int size){ 
		vertex = new ArrayList(); 
		this.numberOfVertices = size; 
	} 
}
