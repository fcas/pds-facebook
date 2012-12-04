package grafo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import visitor.Visitor;

public abstract class AbstractGraph implements Graph {

	protected List<Vertex> listVertex;

	public AbstractGraph() {
		listVertex = new ArrayList<Vertex>();
	}

	/** Cria um boolean[] auxiliar e chama o metodo concreto de percorrimento **/
	public void depthFirstTraversal(Visitor visitor, int start,
			List<Vertex> list) {

		boolean[] visited = new boolean[listVertex.size()];
		for (int i = 0; i < listVertex.size(); ++i) {
			visited[i] = false;
		}
		depthFirstTraversal(visitor, listVertex.get(start), visited, list);
	}
	
	public List<Vertex> getListVertex() {
		return this.listVertex;
	}

	/**
	 * Percorre o grafo em profundidade chamando o metodo accept de todos os
	 * vertices e adiciona numa lista ligada todos os vertices que percorre
	 **/
	private void depthFirstTraversal(Visitor visitor, Vertex v,
			boolean[] visited, List<Vertex> list) {
		
		((ConcreteVertex) v).accept(visitor);
		visited[searchPositionVertex(v.getId())] = true;
		list.add(v);
		
		LinkedList<Vertex> iter = v.getVizinhos();
		Vertex to; 
		for (int i = 0; i < iter.size(); i++) {
			to = iter.get(i);
			if(!visited[searchPositionVertex(to.getId())])
				depthFirstTraversal(visitor, to, visited, list);
			
		}
	
	}

	/**
	 * Percorre o grafo em largura chamando o metodo accept de todos os vertices
	 * e adiciona numa lista ligada todos os vertices que percorre
	 **/
	public void breadthFirstTraversal(Visitor visitor, int start,
			List<Vertex> list) {
		//inicia variaveis de auxilio
		boolean enqueued[] = new boolean[listVertex.size()];
		Vertex v = listVertex.get(start);
		Queue<Vertex> queue = new LinkedList<Vertex>();

		//enfileira primeiro elemento
		enqueued[searchPositionVertex(v.getId())] = true;
		queue.add(v);

		//enquanto fila nao vazia, prossegue
		while (!queue.isEmpty()) {
			Vertex vertex = queue.remove();//remove o primeiro da fila
			((ConcreteVertex) vertex).accept(visitor);//visita
			list.add(vertex);//lista auxiliar

			//pega os proximos e cria um auxiliar
			LinkedList<Vertex> successors = vertex.getVizinhos();
		
			// Enfileira os sucessores
			for (int i = 0; i < successors.size(); i++) {
				Vertex next = successors.get(i);
				if(!enqueued[searchPositionVertex(next.getId())]){
					enqueued[searchPositionVertex(next.getId())] = true;
					queue.add(next);
				}
				
			}
		}
	}
	
	/**Classe para propositos de testes**/
	public void imprimir(){ 
		
//		for (int i = 0; i < listVertex.size(); i++) {
//			System.out.println(listVertex.get(i).getName());
//		}
		
	//	System.out.println(searchPositionVertex(listVertex.get(0).getId()));
		
		System.out.println(listVertex.size());
		for (int i = 0; i < listVertex.size(); i++) {
				System.out.println(listVertex.get(i).getVizinhos().size());
			//for (int j = 0; j < listVertex.get(i).getVizinhos().size(); j++) {
			//	System.out.println(listVertex.get(i).getVizinhos().get(j).getName());
		//	}
		}
	}

}