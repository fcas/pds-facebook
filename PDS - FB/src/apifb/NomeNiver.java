package apifb;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import graph.*;

public class NomeNiver {

	public static void main(String[] args) throws IOException {

		List<String> usuarios = new ArrayList<>();
		List<String> enderecos = new ArrayList<>();

		usuarios.add("felipecordeiroalves");
		usuarios.add("larissabatistaleite");
		usuarios.add("showrodrigues");

		CriarArquivoAniversarios arq_aniversario = new CriarArquivoAniversarios();
		CriarArquivoIds arq_ids = new CriarArquivoIds();
		CriarArquivoNomes arq_nomes = new CriarArquivoNomes();

		

	for (int i = 0; i < usuarios.size(); i++) {
//			arq_ids.criarArquivoIds(usuarios.get(i));
			//arq_nomes.criarArquivoNomes(usuarios.get(i));
			//arq_aniversario.criarArquivoAniversarios(usuarios.get(i));
		enderecos.add("/home/felipe/ids_" + usuarios.get(i) + ".txt");
		enderecos.add("/home/felipe/nomes_" + usuarios.get(i) + ".txt");
		enderecos.add("/home/felipe/aniversarios_" + usuarios.get(i)
				+ ".txt");
	}

		AbstractGraph3 graph = new GraphAsList();

		BufferedReader in_ids;
		BufferedReader in_nomes;
		BufferedReader in_aniversarios;

		for (int i = 0; i < enderecos.size();) {

			try {

				in_ids = new BufferedReader(new FileReader(enderecos.get(i++)));
				in_nomes = new BufferedReader(
						new FileReader(enderecos.get(i++)));
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
						Edge edge = new ConcreteEdge(user, graph.searchVertex(vertex.getId()));
						graph.addEdge(edge);
					}
				}

			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		}

	}

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
}
