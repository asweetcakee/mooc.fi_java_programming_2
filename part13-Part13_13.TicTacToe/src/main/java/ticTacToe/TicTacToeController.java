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

    private final ButtonClickManager manager;
    private boolean isGameOver;
    private GameStatusEnum winner;

    public TicTacToeController(ButtonClickManager manager) {
        this.manager = manager;
        this.isGameOver = false;
        this.winner = null;
    }

    public void updateTile(Button btn, int column, int row) {
        // Prevents further moves after the game is over
        if (isGameOver()) {
            return;
        }

        // X is always TRUE
        // O is always FALSE
        // Retrieves current Enum symbol
        GameStatusEnum currentTurnSymbol = this.manager.getTurnSymbol();

        // Counts clicks, used specifically for DRAW triggering
        this.manager.updateClickCounter();

        // If tile is not occupied, sets correct turn symbol on a pressed Button
        // Registers tile in the referenceArray as occupied 
        // by setting 0 to 1 or -1 (Check GameStatusEnum)
        // Changes current turn's symbol to the different, 
        // once the button was clicked
        // TRUE (X) becomes FALSE (O) and vice versa
        if (!this.manager.isTileOccupied(column, row)) {
            btn.setText(currentTurnSymbol.getMessage());
            this.manager.setTileOccupied(column, row);
            // Once current symbol is set, it's value is updated
            this.manager.updateTurn();

            // Checks game status after each move
            calculateWinner(column, row);
            updateGameStatus();
        }
    }

    // Checks game status each time a button is pressed
    public GameStatusEnum getGameResult() {
        return this.winner;
    }

    public boolean isGameOver() {
        return this.isGameOver;
    }

    // Updates game status each time a button is pressed
    private void updateGameStatus() {
        if (this.winner != null) {
            System.out.println(this.winner); // Winner or DRAW
            this.isGameOver = true;  // Stops the game after win/draw
        }
    }

    // Calculates winner each time the Button is pressed
    private void calculateWinner(int column, int row) {
        // Checks for draw first if all tiles are occupied
        if (this.manager.getClickCounter() >= this.manager.getTilesSize()) {
            this.winner = GameStatusEnum.DRAW;  // It's a draw
            return;
        }

        // Checks if current row or column has a winner
        GameStatusEnum potentialWinner = checkRowAndColumnWinner(column, row);
        assignWinner(potentialWinner);

        // Checks diagonals only if necessary
        if (potentialWinner == null) {
            potentialWinner = checkDiagonalWinner(column, row);
            assignWinner(potentialWinner);
        }
    }

    private GameStatusEnum checkRowAndColumnWinner(int column, int row) {
        // Calculates row and column sums for the current move
        int rowSum = calculateSingleRow(row);
        int columnSum = calculateSingleColumn(column);

        return checkWinner(rowSum, columnSum);
    }

    private GameStatusEnum checkDiagonalWinner(int column, int row) {
        if (row == column || row + column == this.manager.getReferenceArraySize() - 1) {
            int mainDiagonalSum = calculateMainDiagonal();
            int secondaryDiagonalSum = calculateSecondaryDiagonal();

            // Checks if either diagonal has a winner
            return checkWinner(mainDiagonalSum, secondaryDiagonalSum);
        }
        return null;
    }

    private void assignWinner(GameStatusEnum potentialWinner) {
        if (potentialWinner != null) {
            this.winner = potentialWinner;
        }
    }

    // Checks for a winner based on the sum
    private GameStatusEnum checkWinner(int sum1, int sum2) {
        if (sum1 == 3 || sum2 == 3) {
            return GameStatusEnum.X; // X wins
        } else if (sum1 == -3 || sum2 == -3) {
            return GameStatusEnum.O; // O wins
        }
        return null; // No winner
    }

    private int calculateSingleRow(int row) {
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

    private int calculateSingleColumn(int column) {
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
