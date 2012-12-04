package gui;

import grafo.Vertex;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import tests.ParDeVerticesNaoExistenteException;
import tests.VerticeJaExisteException;

import api.Cliente;

import dao.DaoFactory;
import dao.IDaoUsuario;

import model.IPagina;
import model.IUsuario;
import model.PaginaApi;
import model.UsuarioApi;
import model.rankings.RankingAmigos;

public class Facade {
	
	private IUsuario usuario;
	private IPagina pagina;
	private DaoFactory factory = DaoFactory.createDaoFactory(0);
	private IDaoUsuario daoUsuario = factory.criarDaoUsuario();
	
	public Facade () {
		pagina = new PaginaApi();
	}
	
	public void setUsuario(String usuario) {
		this.usuario = new UsuarioApi(usuario);
	}
	
	public IUsuario getUsuario() {
		return usuario;
	}
	
	public void setToken(String token) {
		Cliente.setToken(token);
	}
	
	public List<Vertex> buscarAmigos (String nome) {
		try {
			return usuario.buscarAmigos(nome);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (VerticeJaExisteException e) {
			e.printStackTrace();
		} catch (ParDeVerticesNaoExistenteException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public RankingAmigos rankingNomes () {
		RankingAmigos ranking = null;
		
		try {
			ranking = daoUsuario.getRankingAmigos();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return ranking;
	}
	
	public List<IPagina> buscarPaginasRecomendadas() {
		try {
			return usuario.recomendarPaginas();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (VerticeJaExisteException e) {
			e.printStackTrace();
		} catch (ParDeVerticesNaoExistenteException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public List<IPagina> buscarPaginasPalavraChave(String palavra) {
		return pagina.buscarPaginasPalavraChave(palavra);
	}
	
	public RankingAmigos getRanking() {
		try {
			return daoUsuario.getRankingAmigos();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public void criarUsuario() {
		try {
			daoUsuario.criarUsuario(usuario);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void criarRankingAmigos() {
		try {
			daoUsuario.criarRankingAmigos(usuario.getRanking());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void criarRankingPaginas() {
		try {
			daoUsuario.criarRankingPaginasRecomendadas(buscarPaginasRecomendadas());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<String> getRankingPaginas() {
		try {
			return daoUsuario.getRankingPaginasRecomendadas();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
