package graph;

import java.util.LinkedList;

import apifb.Data;

public interface Vertex {
	
	@SuppressWarnings("rawtypes")
	public LinkedList getVizinhos();
	public String getName();
	public Data getBirthday();
	public String getId();
}
