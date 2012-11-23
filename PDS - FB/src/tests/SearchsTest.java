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

public class SearchsTest {

	GerarGrafo gerador; // criador do grafo
	AbstractGraph graph; // grafo concreto
	Visitor visitor; // visitor vazio. Apenas para a busca iterar.
	List<Vertex> list; // lista vazia. A busca preenche a lista com os v�rtices
						// percorridos.
	List<Vertex> list2;

	@Before
	public void setUp() throws Exception {
		gerador = new GerarGrafo(); // inicializa o gerador
		graph = gerador.getGraph(); // gera o grafo concreto
		visitor = new VisitorTeste();
		list = new ArrayList<Vertex>();
		list2 = new ArrayList<Vertex>();
	}

	@Test
	public void testBuscaDepth() {

		//construcao da lista de expectativa
		list2.add(graph.searchVertex("1471562174"));
		list2.add(graph.searchVertex("508160420"));
		list2.add(graph.searchVertex("519889171"));
		list2.add(graph.searchVertex("524374587"));
		list2.add(graph.searchVertex("528026247"));
		list2.add(graph.searchVertex("530202349"));
		list2.add(graph.searchVertex("531894228"));
		list2.add(graph.searchVertex("536058525"));
		list2.add(graph.searchVertex("512295667"));
		list2.add(graph.searchVertex("512694538"));
		list2.add(graph.searchVertex("513227708"));
		
		// run
		graph.depthFirstTraversal(visitor, 0, list);

		// assert
		for (int i = 0; i < list2.size(); i++) {
			assertEquals(list.get(i).getName(), list2.get(i).getName());
		}
	}
	
	@Test
	public void testBuscaBreadth() {

		//construcao da lista de expectativa
		list2.add(graph.searchVertex("1471562174"));
		list2.add(graph.searchVertex("508160420"));
		list2.add(graph.searchVertex("519889171"));
		list2.add(graph.searchVertex("524374587"));
		list2.add(graph.searchVertex("528026247"));
		list2.add(graph.searchVertex("530202349"));
		list2.add(graph.searchVertex("531894228"));
		list2.add(graph.searchVertex("536058525"));
		list2.add(graph.searchVertex("544621508"));
		
		// run
		graph.breadthFirstTraversal(visitor, 0, list);

		// assert
		for (int i = 0; i < list2.size(); i++) {
			assertEquals(list.get(i).getName(), list2.get(i).getName());
		}
	}
}