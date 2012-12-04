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
import model.Ranking;
import model.UsuarioApi;

public class Facade {
	
	private IUsuario usuario;
	private DaoFactory factory = DaoFactory.createDaoFactory(0);
	private IDaoUsuario daoUsuario = factory.criarDaoUsuario();
	
	public Facade () {
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
	
	public Ranking rankingNomes () {
		Ranking ranking = null;
		
		try {
			ranking = daoUsuario.getRanking();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return ranking;
	}
	
	public List<IPagina> buscarPaginasRecomendadas() {
		return null;
	}

	public List<IPagina> buscarPaginasPalavraChave(String palavra) {
		return usuario.buscarPaginasPalavraChave(palavra);
	}
	
	public Ranking getRanking() {
		try {
			return daoUsuario.getRanking();
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
	
	public void criarRanking() {
		try {
			daoUsuario.criarRanking(usuario.getRanking());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
