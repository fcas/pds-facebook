/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.dimap.Grafo;

import br.ufrn.dimap.Grafo.excecoes.ListaDeVerticesCheiaException;
import br.ufrn.dimap.Grafo.excecoes.ParDeVerticesNaoExistenteException;
import br.ufrn.dimap.Grafo.excecoes.VerticeJaExisteException;
import br.ufrn.dimap.Grafo.excecoes.VerticeNaoExisteException;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author Anthonini
 */
public class GrafoMatriz implements Grafo {

    private Aresta[][] matrizArestas;
    private Vertice[] listaVertices;
    private int quantideDeVertices = 0;

    public GrafoMatriz(int tamanho) {
        this.listaVertices = new Vertice[tamanho];
        this.matrizArestas = new Aresta[tamanho][tamanho];
    }

    public Vertice buscarVertice(int id) {
        Vertice retorno = null;
        for (int i = 0; i < quantideDeVertices; i++) {
            if (id == listaVertices[i].getId()) {
                retorno = listaVertices[i];
            }
        }
        return retorno;
    }

    public int buscarPosicaoVertice(int id) {
        int retorno = -1;
        for (int i = 0; i < quantideDeVertices; i++) {
            if (id == listaVertices[i].getId()) {
                retorno = i;
            }
        }
        return retorno;
    }

    public boolean existeVertice(int id) {
        return (buscarVertice(id) != null);
    }

    public void inserirVertice(Vertice vertice) throws VerticeJaExisteException, ListaDeVerticesCheiaException {
        if (quantideDeVertices < listaVertices.length) {
            if (!existeVertice(vertice.getId())) {
                listaVertices[quantideDeVertices] = vertice;
                quantideDeVertices++;
            } else {
                //System.out.println("Vértice já existe");
                throw new VerticeJaExisteException();
            }
        } else {
            //System.out.println("Lista de vértices cheia");
            throw new ListaDeVerticesCheiaException();
        }
    }

    public void inserirAresta(Aresta aresta) throws ParDeVerticesNaoExistenteException {
        if (existeVertice(aresta.getOrigem().getId())
                && existeVertice(aresta.getDestino().getId())) {

            int linha = buscarPosicaoVertice(aresta.getOrigem().getId());
            int coluna = buscarPosicaoVertice(aresta.getDestino().getId());

            matrizArestas[linha][coluna] = aresta;
        } else {
            //System.out.println("Par de vértices não existe");
            throw new ParDeVerticesNaoExistenteException();
        }
    }

    public Aresta removerAresta(int origemId, int destinoId) throws ParDeVerticesNaoExistenteException {
        Aresta retorno = null;
        int posicaoOrigem = buscarPosicaoVertice(origemId);
        int posicaoDestino = buscarPosicaoVertice(destinoId);
        if (posicaoOrigem != -1 && posicaoDestino != -1) {
            retorno = matrizArestas[posicaoOrigem][posicaoDestino];
            matrizArestas[posicaoOrigem][posicaoDestino] = null;
        } else {
            //System.out.println("Par de vértices não existe");
            throw new ParDeVerticesNaoExistenteException();
        }
        return retorno;
    }

    public Vertice removerVertice(int id) throws VerticeNaoExisteException{
        Vertice retorno = null;
        int posicaoVertice = buscarPosicaoVertice(id);
        if (posicaoVertice != -1) {
            //remoção dos vértices
            for (int i = posicaoVertice; i < quantideDeVertices - 1; i++) {
                listaVertices[i] = listaVertices[i + 1];
            }
            //remoção das Arestas que chegam ou saem do vértice.
            for (int i = posicaoVertice; i < quantideDeVertices-1; i++) {
                for (int j = 0; j < quantideDeVertices; j++) {
                    if (i == j) {
                        matrizArestas[i][j] = matrizArestas[i + 1][j + 1];
                    } else {
                        matrizArestas[i][j] = matrizArestas[i + 1][j];
                        matrizArestas[j][i] = matrizArestas[j][i + 1];
                    }
                }
            }
            quantideDeVertices--;
        } else {
            //System.out.println("Vértice com Id = " + id + " não Existe");
            throw new VerticeNaoExisteException( id );
        }
        return retorno;
    }

    public Iterator<Aresta> obterArestas(){
        LinkedList<Aresta> arestas = new LinkedList();
        for( int i = 0; i < quantideDeVertices; i++ ){
            for( int j = 0; j < quantideDeVertices; j++ ){
                if( matrizArestas[i][j] != null ){
                    arestas.add(matrizArestas[i][j]);
                }
            }
        }
        return arestas.iterator();
    }
}
