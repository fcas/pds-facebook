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
		ConcreteVertex vertex0 = new ConcreteVertex("0", null,
				"0");
		ConcreteVertex vertex1 = new ConcreteVertex("1", null,
				"1");
		ConcreteVertex vertex2 = new ConcreteVertex("2", null,
				"2");
		ConcreteVertex vertex3 = new ConcreteVertex("3", null,
				"3");
		ConcreteVertex vertex4 = new ConcreteVertex("4", null,
				"4");
		ConcreteVertex vertex5 = new ConcreteVertex("5", null,
				"5");

		graph2.addVertex(vertex0);
		graph2.addVertex(vertex1);
		graph2.addVertex(vertex2);
		graph2.addVertex(vertex3);
		graph2.addVertex(vertex4);
		graph2.addVertex(vertex5);
		
		Edge edge0 = new ConcreteEdge(vertex0, vertex2);
		Edge edge1 = new ConcreteEdge(vertex0, vertex1);
		Edge edge2 = new ConcreteEdge(vertex0, vertex5);
		Edge edge3 = new ConcreteEdge(vertex1, vertex2);
		Edge edge4 = new ConcreteEdge(vertex2, vertex3);
		Edge edge5 = new ConcreteEdge(vertex2, vertex4);
		Edge edge6 = new ConcreteEdge(vertex3, vertex4);
		Edge edge7 = new ConcreteEdge(vertex3, vertex5);
		
		
		graph2.addEdge(edge0);
		graph2.addEdge(edge1);
		graph2.addEdge(edge2);
		graph2.addEdge(edge3);
		graph2.addEdge(edge4);
		graph2.addEdge(edge5);
		graph2.addEdge(edge6);
		graph2.addEdge(edge7);

		graph2.setAdjacencyList(graph2.getEdges());

		// run
//		graph.breadthFirstTraversal(visitor, 0, list);
//		graph2.depthFirstTraversal(visitor, 0, list);
		graph2.breadthFirstTraversal(visitor, 0, list);

		// assert
//		for (int i = 0; i < list2.size(); i++) {
//			assertEquals(list.get(i).getName(), list2.get(i).getName());
//		}

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getName());
		}
		
		
	}

}
