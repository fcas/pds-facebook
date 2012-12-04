package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import model.IPagina;
import model.IUsuario;
import model.rankings.Amigos;
import model.rankings.RankingAmigos;

public class DaoUsuario implements IDaoUsuario {
	
	private final String caminhoArquivo = System.getProperty("user.dir") + System.getProperty("file.separator");
	private BufferedWriter arquivoId;
	private BufferedWriter arquivoNome;
	private BufferedWriter arquivoRankingAmigos;
	private BufferedWriter arquivoRankingPaginasRecomendadas;
	
	/*metodo que recebe o usuario para o qual os arquivos serao criados;*/
	public void criarUsuario(IUsuario usuario) throws IOException {
		List<IUsuario> amigos = usuario.getAmigos();
		
		arquivoId = new BufferedWriter(new FileWriter(
					caminhoArquivo + "ids_" + usuario.getUsername() + ".txt"));
		
		arquivoNome = new BufferedWriter(new FileWriter(
				caminhoArquivo + "nomes_" + usuario.getUsername() + ".txt"));
		
		arquivoId.write(usuario.getID() + "\n");
		arquivoNome.write(usuario.getUsername() + "\n");
		
		for (int i=0; i<amigos.size(); i++) {
			arquivoId.write(amigos.get(i).getID() + "\n");
			arquivoNome.write(amigos.get(i).getNome() + "\n");
		}	

		arquivoId.close();
		arquivoNome.close();
	}
	
	public void criarRankingAmigos(RankingAmigos ranking) throws IOException {
		arquivoRankingAmigos = new BufferedWriter(new FileWriter(
				caminhoArquivo + "ranking.txt"));
		System.out.println("Tamanho do ranking " + ranking.getLista().size());
		for (int i=ranking.getLista().size()-1; i>-1; i--) {
			System.out.println("ESCREVENDO NO ARQUIVO RANKING " + ranking.getLista().get(i).getNome());
			arquivoRankingAmigos.write(ranking.getLista().get(i).getNome() + "\n");
			arquivoRankingAmigos.write(ranking.getLista().get(i).getPontos() + "\n");
		}
		
		arquivoRankingAmigos.close();
	}

	public RankingAmigos getRankingAmigos() throws NumberFormatException, IOException {
		RankingAmigos ranking = new RankingAmigos();
		BufferedReader rankingReader = new BufferedReader(new FileReader(caminhoArquivo+"ranking.txt"));
        while(rankingReader.ready()) {
        	Amigos amigo = new Amigos();
        	amigo.setNome(rankingReader.readLine());
        	amigo.setPontos(Integer.parseInt(rankingReader.readLine()));
        	ranking.getLista().add(amigo);
        }
        
        rankingReader.close();
        return ranking;
	}

	@Override
	public void criarRankingPaginasRecomendadas(List<IPagina> listaPaginas) throws IOException {
		arquivoRankingPaginasRecomendadas = new BufferedWriter(new FileWriter(
				caminhoArquivo + "rankingPaginas.txt"));
		for (int i=listaPaginas.size()-1; i>-1; i--) {
			arquivoRankingPaginasRecomendadas.write(listaPaginas.get(i).getNome() + "\n");
		}
		
		arquivoRankingPaginasRecomendadas.close();
		
	}

	@Override
	public List<String> getRankingPaginasRecomendadas() throws IOException {
		List<String> paginasRecomendadas = new ArrayList<String>();
		BufferedReader rankingReader = new BufferedReader(new FileReader(caminhoArquivo+"rankingPaginas.txt"));
        while(rankingReader.ready()) {
        	paginasRecomendadas.add(rankingReader.readLine());
        }
        
        rankingReader.close();
        return paginasRecomendadas;
	}

}