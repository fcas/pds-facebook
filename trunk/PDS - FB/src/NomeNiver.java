import java.util.List;

import graph.*;

public class NomeNiver {

	public static void main(String[] args) {

		String name = "felipecordeiroalves";

		IUsuario usuario = new Usuario();
		IListaIDs listaIDs = new ListaIDs();

		List<String> lista = listaIDs.buscarIDs(name);

		AbstractGraph graph = new GraphAsList(lista.size());

		for (int i = 0; i < lista.size(); i++) {
			ConcreteVertex vertex = new ConcreteVertex(usuario.getName(lista
					.get(i)), usuario.getBirthday(lista.get(i)),
					usuario.getID(lista.get(i)));
			graph.addVertex(vertex);

			if (i % 2 == 0) { 
				graph.addEdge(graph.getListVertex().get(i), graph
						.getListVertex().get(i - 1));
			}
		}
	}
}
