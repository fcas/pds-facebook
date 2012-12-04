package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


import model.AmigoRanking;
import model.IUsuario;
import model.Ranking;

public class DaoUsuario implements IDaoUsuario {
	
	private final String caminhoArquivo = System.getProperty("user.dir") + System.getProperty("file.separator");
	private BufferedWriter arquivoId;
	private BufferedWriter arquivoNome;
	private BufferedWriter arquivoRanking;
	
	/*método que recebe o usuário para o qual os arquivos serão criados;
	 * Não gostei muito do nome desse método, podemos pensar um melhor depois*/
	public void criarUsuario(IUsuario usuario) throws IOException {
		List<IUsuario> amigos = usuario.getAmigos();
		
		arquivoId = new BufferedWriter(new FileWriter(
					caminhoArquivo + "ids_" + usuario.getUsername() + ".txt"));
		
		arquivoNome = new BufferedWriter(new FileWriter(
				caminhoArquivo + "nomes_" + usuario.getUsername() + ".txt"));
		
		arquivoId.write(usuario.getID() + "\n");
		arquivoNome.write(usuario.getUsername() + "\n");
		
		for (int i=0; i<amigos.size(); i++) {
			//System.out.println("Inserindo no arquivo: " + amigos.get(i).getID() + "   " +  amigos.get(i).getNome());
			arquivoId.write(amigos.get(i).getID() + "\n");
			arquivoNome.write(amigos.get(i).getNome() + "\n");
		}	

		arquivoId.close();
		arquivoNome.close();
	}
	
	public void criarRanking(Ranking ranking) throws IOException {
		arquivoRanking = new BufferedWriter(new FileWriter(
				caminhoArquivo + "ranking.txt"));
		System.out.println("Tamanho do ranking " + ranking.getLista().size());
		for (int i=ranking.getLista().size()-1; i>-1; i--) {
			System.out.println("ESCREVENDO NO ARQUIVO RANKING " + ranking.getLista().get(i).getNome());
			arquivoRanking.write(ranking.getLista().get(i).getNome() + "\n");
			arquivoRanking.write(ranking.getLista().get(i).getPontos() + "\n");
		}
		
		arquivoRanking.close();
	}

	public Ranking getRanking() throws NumberFormatException, IOException {
		Ranking ranking = new Ranking();
		BufferedReader rankingReader = new BufferedReader(new FileReader(caminhoArquivo+"ranking.txt"));
        while(rankingReader.ready()) {
        	AmigoRanking amigo = new AmigoRanking();
        	amigo.setNome(rankingReader.readLine());
        	amigo.setPontos(Integer.parseInt(rankingReader.readLine()));
        	ranking.getLista().add(amigo);
        }
        
        return ranking;
	}

}