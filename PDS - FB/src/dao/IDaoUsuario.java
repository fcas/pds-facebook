package dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import model.IPagina;
import model.IUsuario;
import model.rankings.RankingAmigos;

public interface IDaoUsuario {
	public void criarUsuario(IUsuario usuario) throws IOException;
	public void criarRankingAmigos (RankingAmigos ranking) throws IOException;
	public RankingAmigos getRankingAmigos() throws NumberFormatException, IOException;
	public void criarRankingPaginasRecomendadas(List<IPagina> listaPaginas) throws IOException;
	public List<String> getRankingPaginasRecomendadas() throws FileNotFoundException, IOException;
}
