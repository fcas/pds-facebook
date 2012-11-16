package apifb;

import graph.AbstractGraph;
import graph.ConcreteEdge;
import graph.ConcreteVertex;
import graph.Edge;
import graph.GraphAsList;
import graph.Vertex;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import tests.ParDeVerticesNaoExistenteException;
import tests.VerticeJaExisteException;

public class GerarGrafo {

	List<String> usuarios = new ArrayList<>();
	List<String> enderecos = new ArrayList<>();

	AbstractGraph graph = new GraphAsList();

	BufferedReader in_ids;
	BufferedReader in_nomes;
	BufferedReader in_aniversarios;

	/** Inicializa a lista de usuários e os diretórios para a criação dos grafos **/
	public GerarGrafo() {

		usuarios.add("felipecordeiroalves");
		usuarios.add("larissabatistaleite");
		usuarios.add("showrodrigues");

		for (int i = 0; i < usuarios.size(); i++) {
			enderecos.add("C:\\pdsfb\\ids_" + usuarios.get(i) + ".txt");
			enderecos.add("C:\\pdsfb\\nomes_" + usuarios.get(i) + ".txt");
			enderecos.add("C:\\pdsfb\\aniversarios_" + usuarios.get(i)
					+ ".txt");
			System.out.println(enderecos.get(i));
		}
		
	}

	/** Transforma string em data. **/
	public static Data process(String str) throws IOException {

		Data data = new Data();

		if (!str.equals("null")) {
			data.setDia(str.substring(0, 2));
			data.setMes(str.substring(3, 5));
			if (!str.substring(5).equals("")) {
				data.setAno(str.substring(6, 10));
			}

		}

		return data;

	}

	/** Povoa o grafo **/
	private void Povoar() throws IOException, VerticeJaExisteException,
			ParDeVerticesNaoExistenteException, FileNotFoundException {
		
		for (int i = 0; i < enderecos.size();) {

			in_ids = new BufferedReader(new FileReader(enderecos.get(i++)));
			in_nomes = new BufferedReader(new FileReader(enderecos.get(i++)));
			in_aniversarios = new BufferedReader(new FileReader(
					enderecos.get(i++)));

			boolean primeiraLinha = true;
			String id = in_ids.readLine();
			Vertex user = null;

			while (in_ids.ready()) {
				if (primeiraLinha) {
					ConcreteVertex vertex = new ConcreteVertex(
							in_nomes.readLine(),
							process(in_aniversarios.readLine()), id);
					graph.addVertex(vertex);
					user = graph.searchVertex(id);
					primeiraLinha = false;
				} else {
					ConcreteVertex vertex = new ConcreteVertex(
							in_nomes.readLine(),
							process(in_aniversarios.readLine()),
							in_ids.readLine());
					graph.addVertex(vertex);
					Edge edge = new ConcreteEdge(user,
							graph.searchVertex(vertex.getId()));
					graph.addEdge(edge);
				}
			}
		}

		graph.setAdjacencyList(graph.getEdges());

	}
	
	public AbstractGraph getGraph() throws FileNotFoundException, IOException, VerticeJaExisteException, ParDeVerticesNaoExistenteException{
		Povoar();
		return graph;
	}
}
