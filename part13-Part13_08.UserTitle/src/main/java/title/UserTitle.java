package title;

import javafx.application.Application;
import javafx.application.Application.Parameters;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;


public class UserTitle extends Application{

    @Override
    public void start(Stage stage) throws Exception {
        
        // Retrieving app parameters sent via launch()
        Parameters params = getParameters();
        String title = params.getNamed().get("title");
        
        // Setting the title from the recieved parameter        
        stage.setTitle(title);
        
        //  Creating an empty layout
        FlowPane layout = new FlowPane();
        
        // Creating the scene
        Scene scene = new Scene(layout, 300, 250);
        stage.setScene(scene);
        stage.show();
        
    }

}
