package graph;

public class PreOrder
extends AbstractPrePostVisitor
{
protected Visitor visitor;
public PreOrder (Visitor visitor)
{ this.visitor = visitor; }
public void preVisit (Object object)
{ visitor.visit (object); }

public boolean isDone ()
{ return visitor.isDone (); }
}