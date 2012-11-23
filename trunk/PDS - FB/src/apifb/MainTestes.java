package apifb;

import java.io.FileNotFoundException;
import java.io.IOException;
//import java.util.LinkedList;

import tests.ParDeVerticesNaoExistenteException;
import tests.VerticeJaExisteException;
import graph.AbstractGraph;
//import graph.Vertex;

public class MainTestes {
	
	public static void main(String[] args) throws FileNotFoundException, IOException, VerticeJaExisteException, ParDeVerticesNaoExistenteException {
		GerarGrafo gerador = new GerarGrafo();
		AbstractGraph graph = gerador.getGraph();
		graph.imprimir();
		
	//	Vertex v = graph.searchVertex("1471562174");
	//	System.out.println(v);

//		LinkedList<Vertex> lista;
//		lista = graph.searchVertex("1471562174").getVizinhos(); 
//
//		
//		for (int i = 0; i < lista.size(); i++) {
//			System.out.println(lista.get(i).getName());
//		}
	}
	

}
