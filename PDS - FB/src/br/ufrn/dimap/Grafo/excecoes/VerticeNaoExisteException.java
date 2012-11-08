/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufrn.dimap.Grafo.excecoes;

/**
 *
 * @author Anthonini
 */
public class VerticeNaoExisteException extends Exception {
    int id;

    public VerticeNaoExisteException( int id ){
        this.id = id;
    }

    public int getId(){
        return id;
    }
}
