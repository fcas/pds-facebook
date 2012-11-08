/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufrn.dimap.Grafo;

/**
 *
 * @author Anthonini
 */
public class Aresta {
    private Vertice origem;
    private Vertice destino;

    public Aresta( Vertice origem, Vertice destino ){
        this.origem = origem;
        this.destino = destino;
    }

    public Vertice getDestino() {
        return destino;
    }

    public void setDestino(Vertice destino) {
        this.destino = destino;
    }

    public Vertice getOrigem() {
        return origem;
    }

    public void setOrigem(Vertice origem) {
        this.origem = origem;
    }
}
