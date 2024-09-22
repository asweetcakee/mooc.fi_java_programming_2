package textstatistics;

import java.util.Arrays;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TextStatisticsApplication extends Application {
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage stage) {
        stage.setTitle("TextStatisticsApplication");

        // Creating labels
        Label letters = new Label("Letters: 0");
        Label words = new Label("Words: 0");
        Label longestWord = new Label("The longest word is: ");

        // Creating a basic layout
        BorderPane layout = new BorderPane();
        layout.setPadding(new Insets(10));

        // Creting a text field
        TextArea text = new TextArea();

        // Events handling
        handleLettersEvent(text, letters, words, longestWord);

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
    
    private static void handleLettersEvent(TextArea text, Label letters, Label words, Label longestWord) {
        text.textProperty().addListener((change, oldVal, newVal) -> {
            int lettersLength = newVal.length();
            //String regex = "[ ,.'\\\\|/><?^&!@#$%*()_+;:\\s]+";
            String[] parts = newVal.split(" ");
            int wordsLength = (int) Arrays.stream(parts)
                    .filter(part -> !part.isEmpty()) // Filters out empty strings
                    .count();

            // Sorts each part by comparing their lengths
            // Natural order comparison (descending order) 
            // Retrieves the first element from the sorted stream
            String longest = Arrays.stream(parts)
                    .filter(part -> !part.isEmpty())
//                    .sorted((s1, s2) -> {
//                        int lengthComparison = s2.length() - s1.length();
//                        if (lengthComparison == 0){
//                            return s1.compareTo(s2); // If lengths are the same, sorts naturall
//                        }
//                        return lengthComparison;
//                    })
                    .sorted((s1, s2) -> s2.length() - s1.length())
                    .findFirst()
                    .orElse("");

            // Adding event changes to the Labels
            letters.setText("Letters: " + lettersLength);
            words.setText("Words: " + wordsLength);
            longestWord.setText("The longest word is: " + longest);
        });
    }
    
}
