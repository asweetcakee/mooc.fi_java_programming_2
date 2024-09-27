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
public class ButtonClickManager {

    private final int tilesSize;
    private boolean turn;
    private final int[][] referenceArray;
    private int clickCounter;

    public ButtonClickManager(int tilesSize) {
        this.tilesSize = tilesSize;
        this.turn = true;
        this.referenceArray = new int[tilesSize / 3][tilesSize / 3];
        this.clickCounter = 0;
    }

    public boolean turnStatus() {
        return this.turn;
    }
    
    // TRUE = X
    // FALSE = O
    public GameStatusEnum getTurnSymbol() {
        return this.turn ? GameStatusEnum.X : GameStatusEnum.O;
    }

    public int getTilesSize() {
        return this.tilesSize;
    }

    public int[][] getReferenceArray() {
        return this.referenceArray;
    }

    public int getReferenceArraySize() {
        return this.referenceArray.length;
    }

    // Used specifically to trigger DRAW
    public int getClickCounter() {
        return this.clickCounter;
    }
    
    // Swaps old turn value to opposite 
    public boolean updateTurn() {
        this.turn = !this.turn;
        return this.turn;
    }
    
    public void updateClickCounter(){
        this.clickCounter++;
    }

    // Sets pressed title as occupied in the reference array
    public void setTileOccupied(int column, int row) {
        if (!isTileOccupied(column, row)) {
            this.referenceArray[row][column] = getTurnNumberBySymbol(getTurnSymbol());
        } else {
            throw new IllegalArgumentException(String.format("The tile at [%s, %s] is already occupied", row, column));
        }
    }
    
    // X = 1; O = -1; DRAW = 0
    private int getTurnNumberBySymbol(GameStatusEnum turnSymbol) {
        return turnSymbol.getValue();
    }
    
    // TRUE means Occupied
    public boolean isTileOccupied(int column, int row) {
        return this.referenceArray[row][column] != 0;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int row = 0; row < this.referenceArray.length; row++) {
            for (int col = 0; col < this.referenceArray[row].length; col++) {
                result.append(this.referenceArray[row][col]).append("\t");
            }
            result.append("\n");
        }

        return result.toString();
    }
}
