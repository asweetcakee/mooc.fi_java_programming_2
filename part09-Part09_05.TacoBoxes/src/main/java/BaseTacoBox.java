/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mefferio
 */
public abstract class BaseTacoBox implements TacoBox{
    protected int tacos;

    public BaseTacoBox(int tacos) {
        this.tacos = tacos;
    }

    @Override
    public void eat(){
        this.tacos--;
    }

    @Override
    public int tacosRemaining() {
        if (this.tacos < 0){
            this.tacos = 0;
        }
        return this.tacos;
    }
    
    
}
