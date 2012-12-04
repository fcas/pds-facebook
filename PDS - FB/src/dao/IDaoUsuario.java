package dao;

import java.io.IOException;

import model.IUsuario;
import model.Ranking;

public interface IDaoUsuario {
	public void criarUsuario(IUsuario usuario) throws IOException;
	public void criarRanking (Ranking ranking) throws IOException;
	public Ranking getRanking() throws NumberFormatException, IOException;
}
