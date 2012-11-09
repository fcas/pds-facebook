package apifb;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
		process();

	}

	public static void main(String[] args) throws IOException {
		process();
	}

	public static void process() throws IOException {

		BufferedReader in_aniversarios;
		String aux;

		Data data = new Data();

		try {

			in_aniversarios = new BufferedReader(new FileReader(
					"/home/felipe/aniversario.txt"));

			while (in_aniversarios.ready()) {
				aux = in_aniversarios.readLine();
				if (!aux.equals("null")) {
					data.setDia(aux.substring(0, 2));
					data.setMes(aux.substring(3, 5));
					if (!aux.substring(5).equals("")) {
						System.out.println(aux);
						data.setAno(aux.substring(6, 10));
					}

				}
			}

		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

	}
}
