package graph;

import java.util.LinkedList;

public interface Vertex {
	
	public LinkedList getVizinhos();
	public String getName();
	public String getBirthday();
	public String getId();
}
