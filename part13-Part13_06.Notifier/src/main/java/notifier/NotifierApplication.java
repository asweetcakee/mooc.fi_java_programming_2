package notifier;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class NotifierApplication extends Application{


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage){
        stage.setTitle("NotifierApplication");
        
        // Creating necessary components
        Button button = new Button("Copy");
        TextField txt1 = new TextField();
        Label txt2 = new Label();
        
        // Custom event handling
        // copies data from txt1 to txt2
        button.setOnAction((event) -> {
            txt2.setText(txt1.getText());
            txt1.clear();
        });
        
        // Creating a basic layout
        VBox layout = new VBox();
        layout.setPadding(new Insets(10));
        layout.setAlignment(Pos.CENTER);
        
        // Adding components to the layout
        layout.getChildren().addAll(txt1, button, txt2);
        
        // Creating the scene
        Scene scene = new Scene(layout, 300, 250);
        stage.setScene(scene);
        stage.show();
    }

}
