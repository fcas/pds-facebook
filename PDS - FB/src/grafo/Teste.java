package grafo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import api.Cliente;

import com.restfb.Connection;
import com.restfb.types.Page;

import model.IPagina;
import model.IUsuario;
import model.UsuarioApi;


import tests.ParDeVerticesNaoExistenteException;
import tests.VerticeJaExisteException;

public class Teste {

	private static GerarGrafo gerarGrafo;
	private static IUsuario usuarioFelipe;

	public static void main(String[] args) throws FileNotFoundException,
			IOException, VerticeJaExisteException,
			ParDeVerticesNaoExistenteException {
		
		usuarioFelipe = new UsuarioApi("showrodrigues");
		gerarGrafo = new GerarGrafo(); 

		@SuppressWarnings("static-access")
		AbstractGraph graph = gerarGrafo.getInstance();

//		List<Vertex> list = graph.sugerirAmigos("Dalay Almeida");
//
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i).getName());
//		}
		
		List<IPagina> list = usuarioFelipe.recomendarPaginas();

//		for (int i = 0; i < list.size(); i++){
//			System.out.println(list.get(i).getNome());
//		}
	}

}
