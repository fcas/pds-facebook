package tests;

import static org.junit.Assert.*;
import graph.AbstractGraph;
import graph.ConcreteEdge;
import graph.ConcreteVertex;
import graph.Edge;
import graph.GraphAsList;
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
	Visitor visitor2;
	List<Vertex> list; // lista vazia. A busca preenche a lista com os v�rtices
						// percorridos.
	List<Vertex> list2;

	@Before
	public void setUp() throws Exception {
		gerador = new GerarGrafo(); // inicializa o gerador
		graph = gerador.getGraph(); // gera o grafo concreto
		visitor = new VisitorTeste();
		visitor2 = new VisitorTeste();// inicializa o visitor do tipo teste
		list = new ArrayList<Vertex>(); // inicializa a lista.
		list2 = new ArrayList<Vertex>();
	}

	@Test
	public void test() throws VerticeJaExisteException,
			ParDeVerticesNaoExistenteException {

		AbstractGraph graph2 = new GraphAsList();
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

		graph2.addVertex(vertex1);
		graph2.addVertex(vertex2);
		graph2.addVertex(vertex3);
		graph2.addVertex(vertex4);
		graph2.addVertex(vertex5);

		Edge edge1 = new ConcreteEdge(vertex1, vertex2);
		Edge edge2 = new ConcreteEdge(vertex1, vertex3);
		Edge edge3 = new ConcreteEdge(vertex1, vertex4);
		Edge edge4 = new ConcreteEdge(vertex1, vertex5);

		graph2.addEdge(edge1);
		graph2.addEdge(edge2);
		graph2.addEdge(edge3);
		graph2.addEdge(edge4);

		graph2.setAdjacencyList(graph2.getEdges());

		// run
		graph.breadthFirstTraversal(visitor, 0, list);
		graph2.breadthFirstTraversal(visitor2, 0, list2);

		// assert
		for (int i = 0; i < list2.size(); i++) {
			assertEquals(list.get(i).getName(), list2.get(i).getName());
		}

	}

}
