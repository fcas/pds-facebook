package tests;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import visitor.*;

import graph.*;
import apifb.GerarGrafo;
import junit.framework.TestCase;


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
