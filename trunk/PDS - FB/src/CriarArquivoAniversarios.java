import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CriarArquivoAniversarios {

	public void criarArquivoAniversarios(String[] args) throws IOException {

		String name = "felipecordeiroalves";

		IUsuario usuario = new Usuario();
		IListaIDs listaIDs = new ListaIDs();

		List<String> lista = listaIDs.buscarIDs(name);
		List<String> aniversarios = new ArrayList<>();

		BufferedWriter out = new BufferedWriter(new FileWriter(
				"/home/felipe/aniversarios.txt"));

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
