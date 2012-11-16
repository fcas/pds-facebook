package apifb;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import tests.ParDeVerticesNaoExistenteException;
import tests.VerticeJaExisteException;
import visitor.VisitorAniversario;
import visitor.Visitor;

import graph.*;

public class NomeNiver {

	public static void main(String[] args) throws IOException,
			ParDeVerticesNaoExistenteException, VerticeJaExisteException {

		List<String> usuarios = new ArrayList<>();
		GerarGrafo gerador = new GerarGrafo();

		CriarArquivoAniversarios arq_aniversario = new CriarArquivoAniversarios();
		CriarArquivoIds arq_ids = new CriarArquivoIds();
		CriarArquivoNomes arq_nomes = new CriarArquivoNomes();
		Visitor visitor = new VisitorAniversario();

		usuarios.add("felipecordeiroalves");
		usuarios.add("larissabatistaleite");
		usuarios.add("showrodrigues");

		for (int i = 0; i < usuarios.size(); i++) {
			// arq_ids.criarArquivoIds(usuarios.get(i));
			// arq_nomes.criarArquivoNomes(usuarios.get(i));
			// arq_aniversario.criarArquivoAniversarios(usuarios.get(i));

		}
		AbstractGraph graph = gerador.getGraph();
		
		
		
		

		// graph.depthFirstTraversal(visitor, 0);
		//graph.breadthFirstTraversal(visitor, 0);   /**colocar o parametro list**/

	}
}
