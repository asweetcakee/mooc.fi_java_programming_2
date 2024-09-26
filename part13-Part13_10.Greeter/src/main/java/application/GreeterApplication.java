package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class GreeterApplication extends Application{


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage){
        
        // Creating components
        Label instructionText = new Label("Enter your name and start.");
        Label greetingText = new Label("Welcome ");
        TextField answer = new TextField();
        Button start = new Button("Start");

        // Creating starter layout
        GridPane starterLayout = new GridPane();
        starterLayout.setPrefSize(300, 180);
        starterLayout.setAlignment(Pos.CENTER);
        starterLayout.setHgap(10);
        starterLayout.setVgap(10);
        starterLayout.setPadding(new Insets(10));
                
        starterLayout.add(instructionText, 1, 0);
        starterLayout.add(answer, 1, 1);
        starterLayout.add(start, 1, 2);
        
        // Creating greeting layout
        StackPane greetingLayout = new StackPane();
        greetingLayout.setPrefSize(300, 180);
        greetingLayout.setAlignment(Pos.CENTER);
        greetingLayout.getChildren().add(greetingText);
        
        // Creating scenes
        Scene starterScene = new Scene(starterLayout, 300, 250);
        Scene greetingScene = new Scene(greetingLayout, 300, 250);
        
        // Assigning the starter scene
        stage.setScene(starterScene);
        stage.show();
        
        start.setOnAction((event) -> {
            stage.setScene(greetingScene);
            StringBuilder updatedText = new StringBuilder();
            updatedText.append(greetingText.getText())
                    .append(answer.getText())
                    .append("!");
            greetingText.setText(updatedText.toString());
        });
    }
}
