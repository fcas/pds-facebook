//package graph;
//
//import java.util.LinkedList;
//
//public class Main {
//
//	/**
//	 * @param args
//	 */
//	public static void main(String[] args) {
//		AbstractGraph graph = new GraphAsList(10);
//		Vertex v1 = new ConcreteVertex("Larissa", "12/07", "1");
//		Vertex v2 = new ConcreteVertex("Sérgio", "08/01","2");
//		Vertex v3 = new ConcreteVertex("Felipe", "04/02","3");
//		Vertex v4 = new ConcreteVertex("Jair", "06/08","3");
//		Vertex v5 = new ConcreteVertex("Thais", "20/08", "4");
//		Vertex v6 = new ConcreteVertex("Cristina", "21/01", "5");
//		Vertex v7 = new ConcreteVertex("João", "22/05", "6");
//		Vertex v8 = new ConcreteVertex("José", "15/04", "7");
//		graph.addVertex(v1);
//		graph.addVertex(v2);
//		graph.addVertex(v3);
//		graph.addVertex(v4);
//		graph.addVertex(v5);
//		graph.addVertex(v6);
//		graph.addVertex(v7);
//		graph.addVertex(v8);
//		
//		graph.addEdge(v1, v2);
//		graph.addEdge(v1, v3);
//		graph.addEdge(v1, v4);
//		graph.addEdge(v1, v5);
//		graph.addEdge(v1, v6);
//		graph.addEdge(v2, v4);
//		graph.addEdge(v2, v5);
//		graph.addEdge(v2, v6);
//		graph.addEdge(v3, v7);
//		graph.addEdge(v3, v8);
//		graph.addEdge(v4, v5);
//		graph.addEdge(v5, v6);
//		graph.addEdge(v6, v4);
//		
//		System.out.println("Amigos de Jair");
//		LinkedList<Vertex> lista;
//		lista = v4.getVizinhos();
//		for (int i = 0; i < lista.size(); i++) {
//			System.out.println(lista.get(i).getName());
//		}
//
//	}
//
//}
