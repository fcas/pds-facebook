package graph;

import java.util.Iterator;
import java.util.LinkedList;

public class GraphAsMatrix extends AbstractGraph3 {

	private Edge[][] matrix;
	private Vertex[] listVertex;
	private int quantideDeVertexs = 0;

	public GraphAsMatrix(int size) {
		this.listVertex = new Vertex[size];
		this.matrix = new Edge[size][size];
	}

	@Override
	public Vertex searchVertex(String id) {
		Vertex retorno = null;
		for (int i = 0; i < quantideDeVertexs; i++) {
			if (id == listVertex[i].getId()) {
				retorno = listVertex[i];
			}
		}
		return retorno;
	}

	@Override
	public int searchPositionVertex(String id) {
		int retorno = -1;
		for (int i = 0; i < quantideDeVertexs; i++) {
			if (id == listVertex[i].getId()) {
				retorno = i;
			}
		}
		return retorno;
	}

	@Override
	public boolean existVertex(String id) {
		return (searchVertex(id) != null);
	}

	@Override
	public void addVertex(Vertex v) {
		if (quantideDeVertexs < listVertex.length) {
			if (!existVertex(v.getId())) {
				listVertex[quantideDeVertexs] = v;
				quantideDeVertexs++;
			} else {
				System.out.println("Vértice já existe");
			}
		} else {
			System.out.println("Lista de vértices cheia");
		}
	}

	@Override
	public void addEdge(Edge Edge) {
		if (existVertex(Edge.getOrigem().getId())
				&& existVertex(Edge.getDestino().getId())) {

			int linha = searchPositionVertex(Edge.getOrigem().getId());
			int coluna = searchPositionVertex(Edge.getDestino().getId());

			matrix[linha][coluna] = Edge;
		} else {
			System.out.println("Par de vértices não existe");
		}
	}

	@Override
	public Edge removeEdge(String origemId, String destinoId) {
		Edge retorno = null;
		int posicaoOrigem = searchPositionVertex(origemId);
		int posicaoDestino = searchPositionVertex(destinoId);
		if (posicaoOrigem != -1 && posicaoDestino != -1) {
			retorno = matrix[posicaoOrigem][posicaoDestino];
			matrix[posicaoOrigem][posicaoDestino] = null;
		} else {
			System.out.println("Par de vértices não existe");
		}
		return retorno;
	}

	@Override
	public Vertex removeVertex(String id) {
		Vertex retorno = null;
		int posicaoVertex = searchPositionVertex(id);
		if (posicaoVertex != -1) {
			// remoção dos vértices
			for (int i = posicaoVertex; i < quantideDeVertexs - 1; i++) {
				listVertex[i] = listVertex[i + 1];
			}
			// remoção das Edges que chegam ou saem do vértice.
			for (int i = posicaoVertex; i < quantideDeVertexs - 1; i++) {
				for (int j = 0; j < quantideDeVertexs; j++) {
					if (i == j) {
						matrix[i][j] = matrix[i + 1][j + 1];
					} else {
						matrix[i][j] = matrix[i + 1][j];
						matrix[j][i] = matrix[j][i + 1];
					}
				}
			}
			quantideDeVertexs--;
		} else {
			System.out.println("Vértice com Id = " + id + " não Existe");
		}
		return retorno;
	}

	@Override
	public Iterator<Edge> getEdges() {
		LinkedList<Edge> Edges = new LinkedList();
		for (int i = 0; i < quantideDeVertexs; i++) {
			for (int j = 0; j < quantideDeVertexs; j++) {
				if (matrix[i][j] != null) {
					Edges.add(matrix[i][j]);
				}
			}
		}
		return Edges.iterator();
	}

	@Override
	public int getNumberOfEdges() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isDirected() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void depthFirstTraversal(int startVertex) {
		// TODO Auto-generated method stub

	}

	@Override
	public void breadthFirstTraversal(int startVertex) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isEdge(Vertex v, Vertex w) {
		// TODO Auto-generated method stub
		return false;
	}
}
