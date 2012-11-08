/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.dimap.Grafo;

import br.ufrn.dimap.Grafo.excecoes.ParDeVerticesNaoExistenteException;
import br.ufrn.dimap.Grafo.excecoes.VerticeJaExisteException;
import br.ufrn.dimap.Grafo.excecoes.VerticeNaoExisteException;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author Anthonini
 */
public class GrafoLista implements Grafo {

    LinkedList<Vertice> listaVertices;
    LinkedList<LinkedList<Aresta>> listaDeAdjacencias;

    public GrafoLista() {
        listaVertices = new LinkedList();
        listaDeAdjacencias = new LinkedList();
    }

    public Vertice buscarVertice(int id) {
        Vertice retorno = null;
        for (int i = 0; i < listaVertices.size(); i++) {
            if (id == listaVertices.get(i).getId()) {
                retorno = listaVertices.get(i);
            }
        }
        return retorno;
    }

    public int buscarPosicaoVertice(int id) {
        int retorno = -1;
        for (int i = 0; i < listaVertices.size(); i++) {
            if (id == listaVertices.get(i).getId()) {
                retorno = i;
            }
        }
        return retorno;
    }

    public boolean existeVertice(int id) {
        return (buscarVertice(id) != null);
    }

    public void inserirVertice(Vertice vertice) throws VerticeJaExisteException {
        if (!existeVertice(vertice.getId())) {
            listaVertices.add(vertice);
            listaDeAdjacencias.add(new LinkedList());
        } else {
            //System.out.println("Vértice já existe");
            throw new VerticeJaExisteException();
        }
    }

    public void inserirAresta(Aresta aresta) throws ParDeVerticesNaoExistenteException {
        int posicaoOrigem = buscarPosicaoVertice(aresta.getOrigem().getId());
        int posicaoDestino = buscarPosicaoVertice(aresta.getDestino().getId());
        if (posicaoOrigem != -1 && posicaoDestino != -1) {
            listaDeAdjacencias.get(posicaoOrigem).add(aresta);
        } else {
            System.out.println("Par de vértices não existe");
            throw new ParDeVerticesNaoExistenteException();
        }
    }

    public Aresta removerAresta(int origemId, int destinoId) throws ParDeVerticesNaoExistenteException {
        Aresta retorno = null;
        int posicaoOrigem = buscarPosicaoVertice(origemId);
        int posicaoDestino = buscarPosicaoVertice(destinoId);
        Iterator<Aresta> arestaIterador = listaDeAdjacencias.get(posicaoOrigem).iterator();
        Aresta arestaAux;
        if (posicaoOrigem != -1 && posicaoDestino != -1) {
            while (arestaIterador.hasNext() && retorno == null) {
                arestaAux = arestaIterador.next();
                if (arestaAux.getDestino().getId() == destinoId) {
                    listaDeAdjacencias.get(posicaoOrigem).remove(arestaAux);
                    retorno = arestaAux;
                }
            }
        } else {
            //System.out.println("Par de vértices não existe");
            throw new ParDeVerticesNaoExistenteException();
        }
        return retorno;
    }

    public Vertice removerVertice(int id) throws VerticeNaoExisteException {
        Vertice retorno = null;
        int posicaoVertice = buscarPosicaoVertice(id);
        if (posicaoVertice != -1) {
            listaVertices.remove(posicaoVertice);
            listaDeAdjacencias.remove(posicaoVertice);
        } else {
            //System.out.println("Vértice com Id = " + id + " não Existe");
            throw new VerticeNaoExisteException(id);
        }
        return retorno;
    }

    public Iterator<Aresta> obterArestas() {
        LinkedList<Aresta> arestas = new LinkedList();
        Iterator<Aresta> arestasIterador;
        for (int i = 0; i < listaVertices.size(); i++) {
            arestasIterador = listaDeAdjacencias.get(i).iterator();
            while (arestasIterador.hasNext()) {
                arestas.add(arestasIterador.next());
            }
        }
        return arestas.iterator();
    }
}
