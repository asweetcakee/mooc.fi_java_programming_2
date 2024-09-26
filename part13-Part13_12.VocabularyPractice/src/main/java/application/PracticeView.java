/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 *
 * @author mefferio
 */
public class PracticeView {

    private Dictionary dict;
    private String word;

    public PracticeView(Dictionary dict) {
        // If dictionary is empty, a random word cannot be retrieved
        this.dict = dict;
    }

    public Parent getView() {
        // Creating view layout
        GridPane layout = setUpLayout();
        
        // Since dictionary is empty once the program is executed
        // the first value of 'word' is null
        // But practice view cannot be displayed 
        // until dictionary has at least one Key-Value pair
        // Hence the 'word' must be updated from null to an existing value
        updateWord();
        
        // Creating layout components
        TextField translationTxtFld = new TextField();
        Label command = new Label(getCommandText());
        Label feedback = new Label("");
        Button btnCheck = new Button("Check");

        // Assigning parent-children layouts
        layout.add(command, 0, 0);
        layout.add(translationTxtFld, 0, 1);
        layout.add(btnCheck, 0, 2);
        layout.add(feedback, 0, 3);

        // Checking the correctnes of an entered translation by click event
        buttonClickEvent(btnCheck, translationTxtFld, feedback);

        return layout;
    }

    private GridPane setUpLayout() {
        GridPane layout = new GridPane();
        layout.setPrefSize(300, 180);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(10));
        layout.setHgap(10);
        layout.setVgap(10);
        return layout;
    }

    private void buttonClickEvent(Button btn, TextField translation, Label feedback) {
        btn.setOnMouseClicked((event) -> {

            // Sanitizing data
            String retrievedTranslation = Utils.sanitizedString(translation.getText());
            
            // Updates feedback Label depending on the correctness of the entered translation 
            if (isTranslationCorrect(retrievedTranslation)) {
                feedback.setText("Correct!");
            } else {
                feedback.setText("Incorrect! The translation of the word '"
                        + this.word
                        + "' is '"
                        + this.dict.getTranslation(this.word)
                        + "'.");
            }

            // Updates current word to a random word
            updateWord();
            translation.clear();
        });
    }

    private boolean isTranslationCorrect(String translation) {
        // Retrieves correct translation by current word
        String correctTranslation = this.dict.getTranslation(this.word);

        // Compares translation entered by a user
        // with the correct translation
        return translation.equals(correctTranslation);
    }

    private void updateWord() {
        this.word = dict.getRandomWord();
    }

    private String getCommandText() {
        return "Translate the word '" + this.word + "'";
    }
}
