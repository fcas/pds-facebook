package dao;

import java.io.IOException;



import model.IUsuario;
import model.rankings.RankingAmigos;

public abstract class DaoFactory {

	public static final int Arquivo = 0;
	
	public abstract IDaoUsuario criarDaoUsuario();
	
	public static DaoFactory createDaoFactory(int factoryType) {
		
		switch (factoryType) {
			case Arquivo:
				return DaoArquivo.getInstance();
		}
		
		return null;
	}

}
