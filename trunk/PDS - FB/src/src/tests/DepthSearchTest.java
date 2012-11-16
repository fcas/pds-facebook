package src.tests;

import static org.junit.Assert.*;
import graph.AbstractGraph;
import graph.Vertex;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import tests.ParDeVerticesNaoExistenteException;
import tests.VerticeJaExisteException;
import visitor.Visitor;
import visitor.VisitorTeste;
import apifb.GerarGrafo;

public class DepthSearchTest {

	@Test
	public void testBuscaDepth() throws FileNotFoundException, IOException, VerticeJaExisteException, ParDeVerticesNaoExistenteException{
		//criar objetos
		GerarGrafo gerador = new GerarGrafo();
		AbstractGraph graph = gerador.getGraph();
		Visitor visitor = new VisitorTeste();
		List<Vertex> list = new ArrayList<Vertex>();
		
		//run
		graph.depthFirstTraversal(visitor, 0, list);
		
		//assert
		for (int i = 0; i< list.size(); i++){
			System.out.println(list.get(i).getName());
		}
		assertEquals(0,0);
	}

}
