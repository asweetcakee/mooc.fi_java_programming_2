package ticTacToe;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class TicTacToeApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("TicTacToeApplication");

        // Creating a basic layout
        BorderPane layout = new BorderPane();

        // Creating main layout
        GridPane main = setUpMainLayout();

        // Creating layout components
        Label turnTxt = new Label("Turn: X");

        // Styling components
        turnTxt.setFont(Font.font("Monospaced", 40));
        turnTxt.setPadding(new Insets(20, 20, 20, 20));

        // Filling main layout with 9 buttons and changing the Label text accordingly
        main = fillWithTiles(main, turnTxt);

        // Assigning parent-children components
        layout.setTop(turnTxt);
        layout.setCenter(main);

        // Creating the scene
        Scene scene = new Scene(layout, 300, 350);
        stage.setScene(scene);
        stage.show();
    }

    private static GridPane setUpMainLayout() {
        GridPane layout = new GridPane();
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(10));
        layout.setHgap(10);
        layout.setVgap(10);
        return layout;
    }

    // Fills main layout with 9 buttons (tiles)
    private static GridPane fillWithTiles(GridPane layout, Label turnTxt) {
        int tiles = 9;
        int rows = 0;
        int columns = 0;

        // Creates tiles click manager, that tracks click events 
        // Creates TicTacToe controller, that is responsible for game logic
        ButtonClickManager manager = new ButtonClickManager(tiles);
        TicTacToeController controller = new TicTacToeController(manager);

        for (int i = 1; i <= tiles; i++) {
            Button btn = createTileButton(controller, turnTxt, columns, rows);
            layout.add(btn, columns, rows);
            columns++;
            if (i % 3 == 0) {
                columns = 0;
                rows++;
            }
        }

        return layout;
    }

    // Creates button and attaches click event
    private static Button createTileButton(TicTacToeController controller, Label turnTxt, int column, int row) {
        Button btn = new Button(" ");
        btn.setFont(Font.font("Monospaced", 40));
        // Sets turn symbol(X or O) on a button, when the button is clicked
        buttonClickEvent(controller, btn, turnTxt, column, row);
        return btn;
    }

    private static void buttonClickEvent(TicTacToeController controller, Button btn, Label turnTxt, int column, int row) {
        btn.setOnAction((event) -> {
            // Once a button is clicked
            controller.updateTile(btn, column, row);
            updateLabel(turnTxt, controller);
        });
    }

    private static void updateLabel(Label turnTxt, TicTacToeController controller) {
        if (controller.isGameOver()) {
            showGameResult(turnTxt, controller);
            //turnTxt.setText("The end!");
        } else {
            turnTxt.setText("Turn: " + controller.getManager().getTurnSymbol());
        }
    }

    private static void showGameResult(Label turnTxt, TicTacToeController controller) {
        GameStatusEnum gameResult = controller.getGameResult();

        switch (gameResult) {
            case X:
                turnTxt.setText(gameResult.getMessage() + " wins!");
                break;
            case O:
                turnTxt.setText(gameResult.getMessage() + " wins!");
                break;
            case DRAW:
                turnTxt.setText(gameResult.getMessage());
                break;
            default:
                break;
        }
    }
}
