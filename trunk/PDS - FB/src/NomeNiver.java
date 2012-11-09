import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import graph.*;

public class NomeNiver {

	public static void main(String[] args) throws IOException {

		String name = "felipecordeiroalves";
		String ids = "/home/felipe/ids.txt";
		String aniversarios = "/home/felipe/aniversarios";
		String nomes = "/home/felipe/nomes";

		IListaIDs listaIDs = new ListaIDs();

		List<String> lista = listaIDs.buscarIDs(name);

		AbstractGraph graph = new GraphAsList(lista.size());

		BufferedReader in_ids;
		BufferedReader in_aniversarios;
		BufferedReader in_nomes;

		try {

			in_ids = new BufferedReader(new FileReader(ids));
			in_aniversarios = new BufferedReader(new FileReader(aniversarios));
			in_nomes = new BufferedReader(new FileReader(nomes));

			while (in_ids.ready()) {
				in_ids.readLine();
				ConcreteVertex vertex = new ConcreteVertex(in_nomes.readLine(),
						in_aniversarios.readLine(), in_ids.readLine());
				graph.addVertex(vertex);
			}

		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

	}
}
