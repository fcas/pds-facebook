package visitor;

import graph.*;

public interface Visitor {
	public void visit(ConcreteVertex vertice);
	public boolean isDone();
}