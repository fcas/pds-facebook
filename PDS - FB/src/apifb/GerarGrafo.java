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

	/** Inicializa a lista de usu�rios e os diret�rios para a cria��o dos grafos **/
	public GerarGrafo() {

		usuarios.add("felipecordeiroalves");
		usuarios.add("larissabatistaleite");
		usuarios.add("showrodrigues");

		/*Alterar o endereco com o diretorio dos arquivos txt.
		 * Em linux, usar barra normal para divisao de diretorios (/).
		 * ex.: /Home/Usuario/Entrada
		 * Para Windows, usar dupla barra invertida (\\)
		 * ex.: C:\\Users\\Public\\Documents\\Entrada   */
		for (int i = 0; i < usuarios.size(); i++) {
			enderecos.add("/home/felipe/ids_" + usuarios.get(i) + ".txt");
			enderecos.add("/home/felipe/nomes_" + usuarios.get(i) + ".txt");
			enderecos.add("/home/felipe/aniversarios_" + usuarios.get(i)
					+ ".txt");
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
	private void Povoar() throws IOException,
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
					try{
						graph.addVertex(vertex);
					} catch (VerticeJaExisteException e) {
					}
					user = graph.searchVertex(id);
					primeiraLinha = false;
				} else {
					ConcreteVertex vertex = new ConcreteVertex(
							in_nomes.readLine(),
							process(in_aniversarios.readLine()),
							in_ids.readLine());
					try{
					graph.addVertex(vertex);
					} catch (VerticeJaExisteException e) {
					}
					Edge edge = new ConcreteEdge(user,
							graph.searchVertex(vertex.getId()));
					graph.addEdge(edge);
				}
			}
		}


	}
	
	/** Retorna um grafo constru�do e povoado. **/
	public AbstractGraph getGraph() throws FileNotFoundException, IOException, VerticeJaExisteException, ParDeVerticesNaoExistenteException{
		Povoar();
		return graph;
	}
}
