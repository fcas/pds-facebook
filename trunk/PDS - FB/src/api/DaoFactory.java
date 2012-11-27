package api;

import java.io.IOException;

import model.IUsuario;

public abstract class DaoFactory {

	public static final int Arquivo = 0;
	
	public abstract void criarUsuario(IUsuario usuario) throws IOException;
	
	public static DaoFactory createDaoFactory(int factoryType) {
		
		switch (factoryType) {
			case Arquivo:
				return DaoUsuario.getInstance();
		}
		
		return null;
	}
}
