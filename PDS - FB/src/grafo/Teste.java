package grafo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import model.IUsuario;
import model.UsuarioApi;


import tests.ParDeVerticesNaoExistenteException;
import tests.VerticeJaExisteException;

public class Teste {
	
	@SuppressWarnings("unused")
	private static GerarGrafo gerarGrafo;

	private static IUsuario usuario;

	public static void main(String[] args) throws FileNotFoundException,
			IOException, VerticeJaExisteException,
			ParDeVerticesNaoExistenteException {
		
		usuario = new UsuarioApi("larissabatistaleite");

		gerarGrafo = new GerarGrafo();
		
		List<Vertex> list = usuario.sugerirAmigos("Larissa Batista Leite");

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getName());
		}
	}

}
