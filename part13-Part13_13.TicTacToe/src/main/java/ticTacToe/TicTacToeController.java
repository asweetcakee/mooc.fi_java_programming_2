/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticTacToe;

import javafx.scene.control.Button;

/**
 *
 * @author mefferio
 */
public class TicTacToeController {

    private ButtonClickManager manager;
    private int updateCounter;
    private boolean isGameOver;

    public TicTacToeController(ButtonClickManager manager) {
        // X always makes the first turn
        this.manager = manager;
        this.isGameOver = false;
        this.updateCounter = 0;
    }

    public void updateTile(Button btn, int column, int row) {
        if (isGameOver) {
            return; // Prevents further moves after the game is over
        }
        // X is always TRUE
        // O is always FALSE
        String currentTurnSymbol = this.manager.getTurnSymbol();
        this.updateCounter++;

        // If tile is not occupied, sets turn text
        // Registers tile in the referenceArray as occupied by setting 0 to 1
        // Changes current turn's turn to opposite
        // TRUE becomes FALSE and vice versa
        if (!this.manager.isTileOccupied(column, row)) {
            btn.setText(currentTurnSymbol);
            this.manager.setTileOccupied(column, row);
            this.manager.updateTurn();

            // Checks game status after each move
            String status = checkGameStatus(column, row);
            if (status != null) {
                System.out.println(status); // Winner or DRAW
                this.isGameOver = true;  // Stops the game after win/draw
            }
        }
    }

    // GOTTA REWORK checkGameStatus() and getWinner()
    public String checkGameStatus(int column, int row) {
        String winner = getWinner(column, row);
        return winner;
    }

    private String getWinner(int column, int row) {
        int rowSum = calculateSingleRowSum(row);
        int columnSum = calculateSingleColumnSum(column);

        // Only checks diagonals if the move is on a diagonal
        int mainDiagonalSum = (row == column) ? calculateMainDiagonal() : 0;
        int secondaryDiagonalSum = (row + column == this.manager.getReferenceArraySize() - 1) ? calculateSecondaryDiagonal() : 0;

        if (rowSum == 3 || columnSum == 3 || mainDiagonalSum == 3 || secondaryDiagonalSum == 3) {
            return "X wins!";
        } else if (rowSum == -3 || columnSum == -3 || mainDiagonalSum == -3 || secondaryDiagonalSum == -3) {
            return "O wins!";
        }

        // Checks for draw
        if (this.updateCounter >= this.manager.getTilesSize()) {
            return "DRAW";
        }

        return null;
    }

    private int calculateSingleRowSum(int row) {
        int sum = 0;
        int size = this.manager.getReferenceArraySize();
        for (int i = row; i < size; i++) {
            for (int j = 0; j < size; j++) {
                sum += this.manager.getReferenceArray()[i][j];
            }
            break;
        }
        return sum;
    }

    private int calculateSingleColumnSum(int column) {
        int sum = 0;
        int size = this.manager.getReferenceArraySize();
        for (int i = 0; i < size; i++) {
            sum += this.manager.getReferenceArray()[i][column];
        }
        return sum;
    }

    private int calculateMainDiagonal() {
        int sum = 0;
        int size = this.manager.getReferenceArraySize();
        for (int i = 0; i < size; i++) {
            sum += this.manager.getReferenceArray()[i][i];
        }
        return sum;
    }

    private int calculateSecondaryDiagonal() {
        int sum = 0;
        int size = this.manager.getReferenceArraySize();
        for (int i = 0; i < size; i++) {
            sum += this.manager.getReferenceArray()[i][size - 1 - i];
        }
        return sum;
    }

    // For Testing purposes, delete once program is finished
    public ButtonClickManager getManager() {
        return this.manager;
    }

}
