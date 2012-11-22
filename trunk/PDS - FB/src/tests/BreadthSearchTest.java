package tests;

import static org.junit.Assert.*;
import graph.AbstractGraph;
import graph.ConcreteVertex;
import graph.Vertex;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import visitor.Visitor;
import visitor.VisitorTeste;
import apifb.GerarGrafo;

public class BreadthSearchTest {

	GerarGrafo gerador; // gerador de grafo
	AbstractGraph graph; // grafo concreto
	Visitor visitor; // visitor vazio. Apenas para a busca iterar.
	List<Vertex> list; // lista vazia. A busca preenche a lista com os v�rtices
						// percorridos.
	List<Vertex> list2;

	@Before
	public void setUp() throws Exception {
		gerador = new GerarGrafo(); // inicializa o gerador
		graph = gerador.getGraph(); // gera o grafo concreto
		visitor = new VisitorTeste();// inicializa o visitor do tipo teste
		list = new ArrayList<Vertex>(); // inicializa a lista.
		list2 = new ArrayList<Vertex>();
	}

	@Test
	public void test() throws VerticeJaExisteException,
			ParDeVerticesNaoExistenteException {


		ConcreteVertex vertex1 = new ConcreteVertex("Felipe Cordeiro", null,
				"1471562174");
		ConcreteVertex vertex2 = new ConcreteVertex("Camila Franco", null,
				"508160420");
		ConcreteVertex vertex3 = new ConcreteVertex("Cezar Taurion", null,
				"519889171");
		ConcreteVertex vertex4 = new ConcreteVertex("Tanaê Murr", null,
				"524374587");
		ConcreteVertex vertex5 = new ConcreteVertex("Adriano Pescada", null,
				"528026247");
		
		list2.add(vertex1); 
		list2.add(vertex2);
		list2.add(vertex3);
		list2.add(vertex4);
		list2.add(vertex5);
		
		// run
		graph.breadthFirstTraversal(visitor, 0, list);
		
		// assert
		for (int i = 0; i < list2.size(); i++) {
			assertEquals(list.get(i).getName(), list2.get(i).getName());
		}

	}

}
