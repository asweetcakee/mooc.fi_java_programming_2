package textstatistics;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class TextStatisticsApplication extends Application{


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage){
        stage.setTitle("TextStatisticsApplication");
        
        int quantity = 0;
        String word = "";
        
        // Creating labels
        Label letters = new Label("Letters: " + quantity);
        Label words = new Label("Words: " + quantity);
        Label longestWord = new Label("The longest word is: " + word);
        
        // Creating a basic layout
        BorderPane layout = new BorderPane();
        layout.setPadding(new Insets(10));
        
        // Creting a text field
        TextArea text = new TextArea();
        
        // Creating a horizontal container
        HBox horizontalContr = new HBox();
        horizontalContr.setSpacing(10);
        
        // Adding components to the HBox container
        horizontalContr.getChildren().addAll(letters, words, longestWord);
                
        // Adding containers to the layout
        layout.setCenter(text);
        layout.setBottom(horizontalContr);
        
        // Creating the scene
        Scene scene = new Scene(layout, 300, 250);
        stage.setScene(scene);
        stage.show();
    }

}
