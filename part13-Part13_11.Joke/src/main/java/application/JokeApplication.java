package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class JokeApplication extends Application{


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("JokeApplication");
        
        // Creating a basic layout
        BorderPane layout = new BorderPane();
        
        // Creating a menu layout
        HBox menu = setUpMenuLayout();
        
        // Creating menu components
        Button jokeLine = new Button("Joke");
        Button jokeAnswer = new Button("Answer");
        Button jokeExplanation = new Button("Explanation");
        
        // Creating joke view
        StackPane view = setUpView();
        
        // Creating view components
        Label text = new Label("What do you call a bear with no teeth?");
                
        // Assigning parent-children layouts
        layout.setTop(menu);
        layout.setCenter(view);
        menu.getChildren().addAll(jokeLine, jokeAnswer, jokeExplanation);
        view.getChildren().add(text);
        
        jokeLine.setOnAction((event) -> {
            text.setText("What do you call a bear with no teeth?");
        });
        
        jokeAnswer.setOnAction((event) -> {
            text.setText("A gummy bear.");
        });
        
        jokeExplanation.setOnAction((event) -> {
            text.setText("Cuz a gummy bear cannot have teeth.");
        });
        
        // Creating the scene and assigning it to the stage 
        Scene scene = new Scene(layout, 300, 250);
        stage.setScene(scene);
        stage.show();
    }
    
    private static HBox setUpMenuLayout(){
        HBox layout = new HBox();
        layout.setPadding(new Insets(10, 10, 10, 10));
        layout.setSpacing(10);
        layout.setAlignment(Pos.CENTER);
        return layout;
    }
    
    private static StackPane setUpView(){
        StackPane view = new StackPane();
        view.setPadding(new Insets(10, 10, 10, 10));
        view.setAlignment(Pos.CENTER);
        return view;
    }
}
