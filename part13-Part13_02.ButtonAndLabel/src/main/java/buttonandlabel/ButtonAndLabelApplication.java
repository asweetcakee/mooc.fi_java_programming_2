package buttonandlabel;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class ButtonAndLabelApplication extends Application {

    public static void main(String[] args) {
        launch(ButtonAndLabelApplication.class);
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("ButtonAndLabelApplication");

        Button button = new Button("Press me");
        Label label = new Label("Some text");
        
        // Rows container
        FlowPane componentGroup = new FlowPane();
        componentGroup.getChildren().add(button);
        componentGroup.getChildren().add(label);
        
        // Creating the scene
        Scene scene = new Scene(componentGroup, 300, 250);
        stage.setScene(scene);
        stage.show();
    }

}
