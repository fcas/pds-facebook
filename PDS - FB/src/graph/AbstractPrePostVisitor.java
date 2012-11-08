package graph;

public abstract class AbstractPrePostVisitor implements PrePostVisitor {
	public void preVisit (Object object) {
		
	}
	public void inVisit (Object object) {
		
	}
	public void postVisit (Object object) {
		
	}
	public boolean isDone () {
		return false;
	}
}