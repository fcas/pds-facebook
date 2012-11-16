package visitor;

import graph.*;

public class VisitorAniversario implements Visitor {

	public void visit(ConcreteVertex vertice) {
		System.out.println("Nome: " + vertice.getName() + "\nAniversário: "
				+ vertice.getBirthday().getDia() + "\n");
	}
}