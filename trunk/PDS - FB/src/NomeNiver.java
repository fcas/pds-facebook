import java.util.List;
import graph.*;

public class NomeNiver {

	public static void main(String[] args) {

		String name = "felipecordeiroalves";

		IUsuario usuario = new Usuario();
		IListaIDs listaIDs = new ListaIDs();
	
		List<String> lista = listaIDs.buscarIDs(name);
		 
		 
		String niver;

		for (int i = 0; i < lista.size(); i++) {
			niver = usuario.getBirthday((lista.get(i)));
			System.out.println(niver);
		}

	}
}
