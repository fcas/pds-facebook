package tests;


import static org.junit.Assert.assertEquals;
import grafo.AbstractGraph;
import grafo.ConcreteEdge;
import grafo.ConcreteVertex;
import grafo.Edge;
import grafo.GraphAsList;
import grafo.Vertex;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import visitor.Visitor;
import visitor.VisitorTeste;

public class GenericTraversalTest {
	AbstractGraph graph2; // grafo concreto
	Visitor visitor; // visitor vazio. Apenas para a busca iterar.
	List<Vertex> list; // lista vazia. A busca preenche a lista com os v�rtices
						// percorridos.
	List<Vertex> list2;
	
	//vertices utilizados no teste
	ConcreteVertex vertex0;
	ConcreteVertex vertex1;
	ConcreteVertex vertex1111;
	ConcreteVertex vertex111;
	ConcreteVertex vertex2222;
	ConcreteVertex vertex22;
	ConcreteVertex vertex33;
	ConcreteVertex vertex222;
	ConcreteVertex vertex3333;
	ConcreteVertex vertex55;
	ConcreteVertex vertex44;
	ConcreteVertex vertex11;

	@Before
	public void setUp() throws Exception {
		
		graph2 = new GraphAsList(); // gera o grafo concreto
		visitor = new VisitorTeste();// inicializa o visitor do tipo teste
		list = new ArrayList<Vertex>(); // inicializa a lista.
		list2 = new ArrayList<Vertex>(); //instancia a lista de expectativa.
		
	//construcao do grafo conhecido
		//construcao dos vertices
		vertex0 = new ConcreteVertex("0", null,
				"0");
		vertex1 = new ConcreteVertex("1", null,
				"1");
		vertex1111 = new ConcreteVertex("1111", null,
				"1111");
		vertex111 = new ConcreteVertex("111", null,
				"111");
		vertex2222 = new ConcreteVertex("2222", null,
				"2222");
		vertex22 = new ConcreteVertex("22", null,
				"22");
		vertex33 = new ConcreteVertex("33", null,
				"33");
		vertex222 = new ConcreteVertex("222", null,
				"222");
		vertex3333 = new ConcreteVertex("3333", null,
				"3333");
		vertex55 = new ConcreteVertex("55", null,
				"55");
		vertex44 = new ConcreteVertex("44", null,
				"44");
		vertex11 = new ConcreteVertex("11", null,
				"11");
		
		//adicao dos vertices
		graph2.addVertex(vertex0);
		graph2.addVertex(vertex1);
		graph2.addVertex(vertex1111);
		graph2.addVertex(vertex111);
		graph2.addVertex(vertex2222);
		graph2.addVertex(vertex22);
		graph2.addVertex(vertex33);
		graph2.addVertex(vertex222);
		graph2.addVertex(vertex3333);
		graph2.addVertex(vertex55);
		graph2.addVertex(vertex44);
		graph2.addVertex(vertex11);
		
		//construcao das arestas
		Edge edge0 = new ConcreteEdge(vertex0, vertex1);
		Edge edge1 = new ConcreteEdge(vertex0, vertex11);
		Edge edge2 = new ConcreteEdge(vertex0, vertex111);
		Edge edge3 = new ConcreteEdge(vertex0, vertex1111);
		Edge edge4 = new ConcreteEdge(vertex11, vertex22);
		Edge edge5 = new ConcreteEdge(vertex111, vertex222);
		Edge edge6 = new ConcreteEdge(vertex2222, vertex3333);
		Edge edge7 = new ConcreteEdge(vertex22, vertex33);
		Edge edge8 = new ConcreteEdge(vertex33, vertex44);
		Edge edge9 = new ConcreteEdge(vertex44, vertex55);
		Edge edge10 = new ConcreteEdge(vertex1111, vertex2222);
		
		//adicao das arestas
		graph2.addEdge(edge0);
		graph2.addEdge(edge1);
		graph2.addEdge(edge2);
		graph2.addEdge(edge3);
		graph2.addEdge(edge4);
		graph2.addEdge(edge5);
		graph2.addEdge(edge6);
		graph2.addEdge(edge7);
		graph2.addEdge(edge8);
		graph2.addEdge(edge9);
		graph2.addEdge(edge10);
	}

	@Test
	public void depthTest() throws VerticeJaExisteException,
			ParDeVerticesNaoExistenteException {
		
		//construcao da lista de expectativa
		list2.add(vertex0);
		list2.add(vertex1);
		list2.add(vertex11);
		list2.add(vertex22);
		list2.add(vertex33);
		list2.add(vertex44);
		list2.add(vertex55);
		list2.add(vertex111);
		list2.add(vertex222);
		list2.add(vertex1111);
		list2.add(vertex2222);
		list2.add(vertex3333);
		
		//run
		graph2.depthFirstTraversal(visitor, 0, list);
		
		//assert
		assertEquals(list2, list);
			

	}
	
	@Test
	public void breadthTest() throws VerticeJaExisteException,
			ParDeVerticesNaoExistenteException {
		
		//construcao da lista de expectativa
		list2.add(vertex0);
		list2.add(vertex1);
		list2.add(vertex11);
		list2.add(vertex111);
		list2.add(vertex1111);
		list2.add(vertex22);
		list2.add(vertex222);
		list2.add(vertex2222);
		list2.add(vertex33);
		list2.add(vertex3333);
		list2.add(vertex44);
		list2.add(vertex55);
		
		//run
		graph2.breadthFirstTraversal(visitor, 0, list);
		
		//assert
		assertEquals(list2, list);

	}

}
