package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MultipleViews extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("First view!");

        // Creating the first view layout and adding content to it
        Button firstViewBtn = new Button("To the second view!");
        BorderPane firstLayout = createFirstView(new BorderPane(), firstViewBtn);
        
        // Creating the second view layout
        Button secondViewBtn = new Button("To the third view!");
        VBox secondLayout = createSecondView(new VBox(), secondViewBtn);
        
        // Creating the third view layout
        Label text = new Label("Third view!");
        Button thirdViewBtn = new Button("To the first view!");
        GridPane thirdLayout = createThirdView(new GridPane(), thirdViewBtn, text);

        // Creating scene views
        Scene firstScene = new Scene(firstLayout, 300, 250);
        Scene secondScene = new Scene(secondLayout, 300, 250);
        Scene thirdScene = new Scene(thirdLayout, 300, 250);

        // Assigning the first scene to the stage and show it
        stage.setScene(firstScene);
        stage.show();

        // MoveViews
        firstViewBtn.setOnAction((event) -> {
            moveView(secondScene, "Second view!" , stage);
        });

        secondViewBtn.setOnAction((event) -> {
            moveView(thirdScene, "Third view!" , stage);
        });

        thirdViewBtn.setOnAction((event) -> {
            moveView(firstScene, "First view!" , stage);
        });
    }

    private static void moveView(Scene newScene, String title, Stage stage) {
        stage.setScene(newScene);
        stage.setTitle(title);
    }
    
    private static BorderPane createFirstView(BorderPane layout, Button btn){
        layout.setTop(new Label("First view!"));
        layout.setCenter(btn);
        return layout;
    }
    
    private static VBox createSecondView(VBox layout, Button btn){
        layout.setPadding(new Insets(10));
        layout.getChildren().addAll(btn, new Label("Second view!"));
        return layout;
    }
    
    private static GridPane createThirdView(GridPane layout, Button btn, Label text){
        layout.setPadding(new Insets(10));
        GridPane.setRowIndex(text, 0);
        GridPane.setColumnIndex(text, 0);
        GridPane.setRowIndex(btn, 1);
        GridPane.setColumnIndex(btn, 1);
        layout.getChildren().addAll(text, btn);
        return layout;
    }
}
