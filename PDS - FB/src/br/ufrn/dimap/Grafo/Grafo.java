/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufrn.dimap.Grafo;

import br.ufrn.dimap.Grafo.excecoes.*;
import java.util.Iterator;

/**
 *
 * @author Anthonini
 */
public interface Grafo {
    Vertice buscarVertice(int id);
    int buscarPosicaoVertice(int id);
    boolean existeVertice(int id);
    void inserirVertice(Vertice vertice) throws VerticeJaExisteException, ListaDeVerticesCheiaException;
    void inserirAresta(Aresta aresta)throws ParDeVerticesNaoExistenteException;
    Aresta removerAresta(int origemId, int destinoId)throws ParDeVerticesNaoExistenteException;
    Vertice removerVertice(int id) throws VerticeNaoExisteException;
    Iterator<Aresta> obterArestas();
}
