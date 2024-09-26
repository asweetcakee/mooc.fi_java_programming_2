package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

// END SOLUTION
public class VocabularyPracticeApplication extends Application {

    private Dictionary dict;

    @Override
    public void init() throws Exception {
        // Creating the dictionary that the application uses
        this.dict = new Dictionary();
        
    }

    public static void main(String[] args) {
        launch(VocabularyPracticeApplication.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
        InputView inputView = new InputView(this.dict);
        PracticeView practiceView = new PracticeView(this.dict);

        stage.setTitle("VocabularyPracticeApplication");

        // Creating a basic layout
        BorderPane layout = new BorderPane();

        // Creating a menu
        HBox menu = setUpMenuLayout();

        // Creating menu components
        Button addTranslation = new Button("Enter new words");
        Button practice = new Button("Practice");

        // Assigning parent-children layouts
        layout.setTop(menu);
        menu.getChildren().addAll(addTranslation, practice);
        layout.setCenter(inputView.getView());

        // Handling button behaviour by click event
        addTranslation.setOnAction((event) -> {
            layout.setCenter(inputView.getView());
        });
        
        // If dictionary is empty, practiceView cannot be displayed
        practice.setOnAction((event) -> {
            if (Utils.isDictionaryNullorEmpty(this.dict)){
                layout.setCenter(new Label("Dictionary is empty. \nPlease fill it first to practice your vocabulary."));
            } else {
                layout.setCenter(practiceView.getView());
            }
        });

        // Creating the scene
        Scene scene = new Scene(layout, 300, 250);
        stage.setScene(scene);
        stage.show();
    }

    private static HBox setUpMenuLayout() {
        HBox layout = new HBox();
        layout.setPadding(new Insets(10, 10, 10, 10));
        layout.setSpacing(10);
        layout.setAlignment(Pos.CENTER);
        return layout;
    }
}
