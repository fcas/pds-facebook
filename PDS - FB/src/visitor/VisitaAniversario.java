package visitor;

import graph.*;

public class VisitaAniversario implements Visitor {
	public boolean visited = false;

	public void visit(ConcreteVertex vertice) {
		System.out.println("Nome: " + vertice.getName() + "\nAniversário: "
				+ vertice.getBirthday().getDia() + "\n");
	}
}