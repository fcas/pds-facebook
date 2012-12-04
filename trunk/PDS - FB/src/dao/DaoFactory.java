package dao;

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
