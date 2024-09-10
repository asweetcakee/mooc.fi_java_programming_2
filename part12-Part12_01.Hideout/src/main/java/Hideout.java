/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mefferio
 */
public class Hideout<T> {
    private T state;
    
    public void putIntoHideout(T toHide){
        this.state = toHide;
    }
    
    public T takeFromHideout(){
        T lastState = this.state;
        this.state = null;
        return lastState;
    }
    
    public boolean isInHideout(){
        return this.state != null;
    }
}
