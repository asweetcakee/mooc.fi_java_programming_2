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
    private int[][] referenceArray;

    public ButtonClickManager(int tilesSize) {
        this.tilesSize = tilesSize;
        this.turn = true;
        this.referenceArray = new int[tilesSize / 3][tilesSize / 3];
    }

    public boolean turnStatus() {
        return this.turn;
    }

    public String getTurnSymbol() {
        return this.turn ? "X" : "O";
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

    // Swaps old turn value to opposite
    public boolean updateTurn() {
        this.turn = !this.turn;
        return this.turn;
    }

    // CHECK if IllegalArgumentException works correctly
    public void setTileOccupied(int column, int row) {
        if (!isTileOccupied(column, row)) {
            this.referenceArray[row][column] = getTurnNumberBySymbol(getTurnSymbol());
        } else {
            throw new IllegalArgumentException(String.format("The tile at [%s, %s] is already occupied", row, column));
        }
    }

    private int getTurnNumberBySymbol(String turnSymbol) {
        return turnSymbol.equals("X") ? 1 : -1;
    }

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
