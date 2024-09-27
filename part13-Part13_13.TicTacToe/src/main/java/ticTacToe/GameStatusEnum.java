/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticTacToe;

/**
 *
 * @author mefferio
 */
public enum GameStatusEnum {
    X(1, "X"), 
    O(-1, "O"), 
    DRAW(0, "DRAW");
    
    private final int value;
    private final String message;

    private GameStatusEnum(int value, String message) {
        this.value = value;
        this.message = message;
    }

    public int getValue() {
        return value;
    }
    
    public String getMessage() {
        return message;
    }        
}
