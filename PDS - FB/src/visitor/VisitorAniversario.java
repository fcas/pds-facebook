package visitor;

import graph.*;

public class VisitorAniversario implements Visitor {

	/**Imprime o nome e o dia do aniversário do vértice**/
	public void visit(ConcreteVertex vertice) {
		System.out.println("Nome: " + vertice.getName() + "\nAniversÃ¡rio: "
				+ vertice.getBirthday().getDia() + "\n");
	}
}