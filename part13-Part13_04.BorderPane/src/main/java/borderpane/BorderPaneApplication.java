package borderpane;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class BorderPaneApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("BorderPaneApplication");

        // Creating labels
        Label txt1 = new Label("NORTH");
        Label txt2 = new Label("WEST");
        Label txt3 = new Label("EAST");
        Label txt4 = new Label("SOUTH");

//        // Creating rows container
//        FlowPane container = new FlowPane(Orientation.VERTICAL);
//        container.setHgap(10); // Horizontal padding
//        container.setVgap(10); // Vertical padding
//        container.setPrefWidth(200); // Container width
//        container.setPrefHeight(100); // Container height
//        container.getChildren().addAll(txt1, txt2);

        // Creating a layout
        BorderPane layout = new BorderPane();
        layout.setTop(txt1);
        layout.setRight(txt3);
        layout.setLeft(txt2);
        layout.setBottom(txt4);

        // Creating the scene
        Scene scene = new Scene(layout, 300, 250);
        stage.setScene(scene);
        stage.show();
        
    }

}
