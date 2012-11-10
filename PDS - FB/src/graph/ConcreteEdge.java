package graph;

public class ConcreteEdge implements Edge {
	
	private Vertex origem;
    private Vertex destino;

    public ConcreteEdge( Vertex origem, Vertex destino ){
        this.origem = origem;
        this.destino = destino;
    }

    public Vertex getDestino() {
        return destino;
    }

    public void setDestino(Vertex destino) {
        this.destino = destino;
    }

    public Vertex getOrigem() {
        return origem;
    }

    public void setOrigem(Vertex origem) {
        this.origem = origem;
    }
}
