package visitor;

import grafo.*;

public class VisitorAniversario implements Visitor {

	/**Imprime o nome e o dia do anivers�rio do v�rtice**/
	public void visit(ConcreteVertex vertice) {
		System.out.println("Nome: " + vertice.getName() + "\nAniversário: "
				+ vertice.getBirthday().getDia() + "\n");
	}
}