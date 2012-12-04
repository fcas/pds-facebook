package dao;

import java.io.IOException;


import model.IUsuario;
import model.Ranking;

public class DaoArquivo extends DaoFactory{
	private static DaoArquivo instance = null;
	
	private DaoArquivo(){}
	
	@Override
	public IDaoUsuario criarDaoUsuario(){
		return new DaoUsuario();
		
	}
	
	public static DaoArquivo getInstance() {
		if (instance == null)
			instance = new DaoArquivo();
		
		return instance;
	}

}
