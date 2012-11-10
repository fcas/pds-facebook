package apifb;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.restfb.types.User;

public class CriarArquivoIds {

	public void criarArquivoNomes(String name) throws IOException {

		IUsuario usuario = new Usuario();
		IListaIDs listaIDs = new ListaIDs();
		BuscarUsuario buscarUsuario = new BuscarUsuario();
		User usuario_name = buscarUsuario.getUser(name);

		List<String> lista = listaIDs.buscarIDs(name);
		List<String> ids = new ArrayList<>();

		BufferedWriter out = new BufferedWriter(new FileWriter(
				"/home/felipe/ids_" + name + ".txt"));

		out.write(usuario_name.getId() + "\n");

		for (int i = 0; i < lista.size(); i++) {
			ids.add(usuario.getName(lista.get(i)));
			System.out.println(i + "\n");
		}

		for (int i = 0; i < ids.size(); i++) {
			try {
				out.write(ids.get(i) + "\n");
			} catch (IOException e) {
			}
		}

		out.close();

	}
}
