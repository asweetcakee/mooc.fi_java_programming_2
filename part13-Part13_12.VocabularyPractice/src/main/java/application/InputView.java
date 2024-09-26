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
public class InputView {
    private Dictionary dict;

    public InputView(Dictionary dict) {
        this.dict = dict;
    }
        
    public Parent getView(){
        // Creating view layout
        GridPane layout = setUpLayout();
        
        // Creating layout components
        Label wordLbl = new Label("Word");
        TextField wordTxtFld = new TextField();
        Label translationLbl = new Label("Translation");
        TextField translationTxtFld = new TextField();
        Button btnAdd = new Button("Add the word pair");
        
        // Assigning parent-children layouts
        layout.add(wordLbl, 0, 0);
        layout.add(wordTxtFld, 0, 1);
        layout.add(translationLbl, 0, 2);
        layout.add(translationTxtFld, 0, 3);
        layout.add(btnAdd, 0, 4);
        
        // Adding word and translation by click event
        buttonClickEvent(btnAdd, wordTxtFld, translationTxtFld);
        
        return layout;
    }
    
    private GridPane setUpLayout(){
        GridPane layout = new GridPane();
        layout.setPrefSize(300, 180);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(10));
        layout.setHgap(10);
        layout.setVgap(10);
        return layout;
    }
    
    private void buttonClickEvent(Button btn, TextField word, TextField translation){
        btn.setOnAction((event) -> {
            
            // Sanitizing data
            String retrievedWord = Utils.sanitizedString(word.getText());
            String retrievedTranslation = Utils.sanitizedString(translation.getText());
            
            // Entered word or translation cannot be empty, IllegalArgumentException
            // Throws by this.dict.add()
            try {
                this.dict.add(retrievedWord, retrievedTranslation);
            } catch (Exception ex){
                System.out.println("Error: " + ex.getLocalizedMessage());
            }
            word.clear();
            translation.clear();
        });
    }
}
