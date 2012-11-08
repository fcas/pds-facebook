import java.util.List;
import br.ufrn.dimap.Grafo.*;

public class NomeNiver {

	public static void main(String[] args) {

		String name = "felipecordeiroalves";

		IUsuario usuario = new Usuario();
		IListaIDs listaIDs = new ListaIDs();
	
		List<String> lista = listaIDs.buscarIDs(name);
		 
		GrafoLista grafo = new GrafoLista();
		
		String niver;
		
		for (int i = 0; i < lista.size(); i++) {
			Vertice vertice = new Vertice(lista.get(i));
			vertice.setAniversario(usuario.getBirthdayAsDate((lista.get(i))));
			vertice.setNome(usuario.getName(lista.get(i)));
		}

		for (int i = 0; i < lista.size(); i++) {
			niver = usuario.getBirthdayAsDate(((lista.get(i))));
			System.out.println(niver);
		}

	}
}
