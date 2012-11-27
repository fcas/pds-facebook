package api;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import model.IUsuario;

public class DaoUsuario extends DaoFactory {
	
	private static DaoUsuario instance = null;
	
	private final String caminhoArquivo = "/home/larissa/workspace2/";
	private BufferedWriter arquivoId;
	private BufferedWriter arquivoNome;
	
	private DaoUsuario() {}
	
	/*método que recebe o usuário para o qual os arquivos serão criados;
	 * Não gostei muito do nome desse método, podemos pensar um melhor depois*/
	public void criarUsuario(IUsuario usuario) throws IOException {
		List<IUsuario> amigos = usuario.getAmigos();
		
		//ACRESCENTAR ListaIds e ListaNomes
		
		arquivoId = new BufferedWriter(new FileWriter(
					caminhoArquivo + "ids_" + usuario.getUsername() + ".txt"));
		
		arquivoNome = new BufferedWriter(new FileWriter(
				caminhoArquivo + "nomes_" + usuario.getUsername() + ".txt"));
		
		arquivoId.write(usuario.getID() + "\n");
		arquivoNome.write(usuario.getUsername() + "\n");
		
		for (int i=0; i<amigos.size(); i++) {
			System.out.println("Inserindo no arquivo: " + amigos.get(i).getID() + "   " +  amigos.get(i).getNome());
			arquivoId.write(amigos.get(i).getID() + "\n");
			arquivoNome.write(amigos.get(i).getNome() + "\n");
		}	

		arquivoId.close();
		arquivoNome.close();
	}
	
	public static DaoUsuario getInstance () {
		if (instance == null)
			instance = new DaoUsuario();
		
		return instance;
		
	}

}
