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
        Label turnTxt = new Label("Turn: ");

        // Styling components
        turnTxt.setFont(Font.font("Monospaced", 40));
        turnTxt.setPadding(new Insets(10));
        
        // Filling main layout with 9 buttons
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
            Button btn = new Button(" ");
            btn.setFont(Font.font("Monospaced", 40));

            // Captures current button location
            final int currentRow = rows;
            final int currentColumn = columns;
            
            // Sets turn symbol(X or O) on a button, when the button is clicked
            buttonClickEvent(btn, turnTxt, currentColumn, currentRow, controller);
            
            layout.add(btn, columns, rows);
            columns++;
            if (i % 3 == 0) {
                columns = 0;
                rows++;
            }
        }
        
        return layout;
    }

    private static void buttonClickEvent(Button btn, Label turnTxt, int column, int row, TicTacToeController controller) {
        btn.setOnAction((event) -> {
            //System.out.println("Button clicked at \ncolumn: " + column + "\nrow: " + row);
            controller.updateTile(btn, column, row);
            System.out.println(controller.getManager());
            if (controller.checkGameStatus(column, row) != null){
               turnTxt.setText(controller.checkGameStatus(column, row));
            }
        });
    }
}
