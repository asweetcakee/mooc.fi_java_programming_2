package buttonandtextfield;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;


public class ButtonAndTextFieldApplication extends Application{


    public static void main(String[] args) {
        launch(ButtonAndTextFieldApplication.class);
    }

    @Override
    public void start(Stage stage){
        stage.setTitle("ButtonAndTextFieldApplication");
        
        Button button = new Button("Press me");
        TextField txtField = new TextField();
        
        // Rows container
        FlowPane container = new FlowPane(Orientation.VERTICAL);
        container.getChildren().add(button);
        container.getChildren().add(txtField);
        
        // Creating the scene
        Scene scene = new Scene(container, 300, 250);
        stage.setScene(scene);
        stage.show();
    }

}
