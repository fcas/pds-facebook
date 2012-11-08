package graph;

public class PostOrder
extends AbstractPrePostVisitor
{
protected Visitor visitor;
public PostOrder (Visitor visitor)
{ this.visitor = visitor; }
public void postVisit (Object object)
{ visitor.visit (object); }

public boolean isDone ()
{ return visitor.isDone (); }
}