package tests;

import static org.junit.Assert.*;
import graph.AbstractGraph;
import graph.Vertex;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import visitor.Visitor;
import visitor.VisitorTeste;
import apifb.GerarGrafo;

public class BreadthSearchTest {
	
	GerarGrafo gerador; //criador do grafo
	AbstractGraph graph; //grafo concreto
	Visitor visitor; //visitor vazio. Apenas para a busca iterar.
	List<Vertex> list; //lista vazia. A busca preenche a lista com os vértices percorridos.

	@Before
	public void setUp() throws Exception {
		gerador = new GerarGrafo(); //inicializa o gerador
		graph = gerador.getGraph(); //gera o grafo concreto
		visitor = new VisitorTeste();
		list = new ArrayList<Vertex>();
	}

	@Test
	public void test() {
		//run
		graph.breadthFirstTraversal(visitor, 0, list);
		
		//assert
		for (int i = 0; i< list.size(); i++){
			System.out.println(list.get(i).getName());
		}
		assertEquals(true,!list.isEmpty());
	}

}
