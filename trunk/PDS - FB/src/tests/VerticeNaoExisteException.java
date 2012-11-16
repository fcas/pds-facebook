/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package tests;

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
