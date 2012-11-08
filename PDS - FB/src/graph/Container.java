package graph;

import java.util.Enumeration;

public interface Container extends Comparable{
	int getCount ();
	boolean isEmpty();
	boolean isFull();
	void purge();
	void accept(Visitor visitor);
	Enumeration getEnumeration();
}
