package graph;

public class AbstractContainer extends AbstractObject implements Container{
	protected int count;
	
	public String toString(){
		final StringBuffer buffer = new StringBuffer();
		Visitor visitor = new AbstractVisitor(){
			private boolean comma;
			
			public void visit (Object object){
				if (comma)
					buffer.append(", ");
				buffer.append(object);
				comma = true;
			}
		};
		accept (visitor);
		return getClass().getName() + " {"+ buffer +"}";
	}
	// ...
}
