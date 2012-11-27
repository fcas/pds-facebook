package grafo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import tests.ParDeVerticesNaoExistenteException;
import tests.VerticeJaExisteException;

public class GerarGrafo {
	
	private final String caminhoArquivo = "/home/larissa/workspace2/";

	private List<String> usuarios = new ArrayList<String>();
	private List<String> arquivos = new ArrayList<String>();

	private static AbstractGraph graph = new GraphAsList();

	private BufferedReader in_ids;
	private BufferedReader in_nomes;
	private BufferedReader in_aniversarios;

	/** Inicializa a lista de usuarios e os diretorios para a criacao dos grafos 
	 * @throws ParDeVerticesNaoExistenteException 
	 * @throws IOException 
	 * @throws FileNotFoundException **/
	public GerarGrafo() throws FileNotFoundException, IOException, ParDeVerticesNaoExistenteException {

		System.out.println("Construtor GerarGrafo!!!");
		
		
		usuarios.add("felipecordeiroalves");
		usuarios.add("larissabatistaleite");
		usuarios.add("showrodrigues");

		/*Alterar o endereco com o diretorio dos arquivos txt.
		 * Em linux, usar barra normal para divisao de diretorios (/).
		 * ex.: /Home/Usuario/Entrada
		 * Para Windows, usar dupla barra invertida (\\)
		 * ex.: C:\\Users\\Public\\Documents\\Entrada   */
		for (int i = 0; i < usuarios.size(); i++) {
			arquivos.add(caminhoArquivo + "ids_" + usuarios.get(i) + ".txt");
			arquivos.add(caminhoArquivo + "nomes_" + usuarios.get(i) + ".txt");
			arquivos.add(caminhoArquivo + "aniversarios_" + usuarios.get(i)
					+ ".txt");
		}
		
		Povoar();
		
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
		
		for (int i = 0; i < arquivos.size();) {
			System.out.println("Grafo sendo construido!!!!");
			in_ids = new BufferedReader(new FileReader(arquivos.get(i++)));
			in_nomes = new BufferedReader(new FileReader(arquivos.get(i++)));
			in_aniversarios = new BufferedReader(new FileReader(
					arquivos.get(i++)));

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
	
	/** Retorna um grafo construido e povoado. **/
	public static AbstractGraph getInstance() throws FileNotFoundException, IOException, VerticeJaExisteException, ParDeVerticesNaoExistenteException{
//		if (graph == null)
//			graph = new GraphAsList();
		
		return graph;
	}
}
