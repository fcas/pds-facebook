package apifb;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.restfb.types.User;

public class CriarArquivoAniversarios {

	public void criarArquivoAniversarios(String name) throws IOException {

		IUsuario usuario = new Usuario();
		IListaIDs listaIDs = new ListaIDs();
		User usuario_name = new User();

		BuscarUsuario buscarUsuario = new BuscarUsuario();
		usuario_name = buscarUsuario.getUser(name);

		List<String> lista = listaIDs.buscarIDs(name);
		List<String> aniversarios = new ArrayList<>();

		BufferedWriter out = new BufferedWriter(new FileWriter(
				"/home/felipe/aniversarios_" + name + ".txt"));

		out.write(usuario_name.getBirthday() + "\n");// o usuario name é o
														// primeiro do arquivo

		for (int i = 0; i < lista.size(); i++) {
			aniversarios.add(usuario.getBirthday(lista.get(i)));
			System.out.println(i + "\n");
		}

		for (int i = 0; i < aniversarios.size(); i++) {
			try {
				out.write(aniversarios.get(i) + "\n");
			} catch (IOException e) {
			}
		}
		out.close();
	}

}