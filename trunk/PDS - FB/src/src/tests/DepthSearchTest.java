package src.tests;

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

public class DepthSearchTest {

	GerarGrafo gerador;
	AbstractGraph graph;
	Visitor visitor;
	List<Vertex> list;
	
	@Before
	public void setUp() throws Exception {
		gerador = new GerarGrafo(); //criador do grafo a partir do diretório
		graph = gerador.getGraph(); //grafo concreto
		visitor = new VisitorTeste(); //visitor vazio. Necessário para a busca
		list = new ArrayList<Vertex>(); //
	}
	
	@Test
	public void testBuscaDepth() {
		
		//run
		graph.depthFirstTraversal(visitor, 0, list);
		
		//assert
//		for (int i = 0; i< list.size(); i++){
//			System.out.println(list.get(i).getName());
//		}
		assertEquals(true,!list.isEmpty());
	}
}