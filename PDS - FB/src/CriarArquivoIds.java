import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CriarArquivoIds {

	public void criarArquivoNomes (String[] args) throws IOException {

		String name = "felipecordeiroalves";

		IUsuario usuario = new Usuario();
		IListaIDs listaIDs = new ListaIDs();

		List<String> lista = listaIDs.buscarIDs(name);
		List<String> ids = new ArrayList<>();

		BufferedWriter out = new BufferedWriter(new FileWriter(
				"/home/felipe/ids.txt"));

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
