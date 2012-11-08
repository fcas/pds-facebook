package graph;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractGraph3 implements Graph {
	protected int numberOfVertices; 
	protected int numberOfEdges; 
	protected List vertex; 
	
	public AbstractGraph3(int size){ 
		vertex = new ArrayList(); 
		this.numberOfVertices = size; 
	}
	 
}
