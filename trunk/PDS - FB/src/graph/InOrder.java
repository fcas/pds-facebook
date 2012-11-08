package graph;

public class InOrder extends AbstractPrePostVisitor {
	protected Visitor visitor;
	
	public InOrder (Visitor visitor) {
		this.visitor = visitor;
	}
	
	public void inVisit (Object object) {
		visitor.visit (object);
	}
	
	public boolean isDone () {
		return visitor.isDone ();
	}
}