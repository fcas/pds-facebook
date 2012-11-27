package grafo;

import java.util.Iterator;
import java.util.LinkedList;

public interface Vertex {

	public LinkedList<Vertex> getVizinhos();
	public Iterator<Vertex> getVizinhosIterador();
	public String getName();
	public Data getBirthday();
	public String getId();
}
