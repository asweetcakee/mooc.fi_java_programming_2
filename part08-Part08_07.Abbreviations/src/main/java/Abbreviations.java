
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author mefferio
 */
public class Abbreviations {

    private final HashMap<String, String> dictionary;

    public Abbreviations() {
        this.dictionary = new HashMap<>();
    }

    public void addAbbreviation(String abbreviation, String explanation) {
        abbreviation = sanitizedString(abbreviation);
        explanation = sanitizedString(explanation);
        if (hasAbbreviation(abbreviation)) {
            System.out.println("Given abbreviation already exists.");
        } else {
            this.dictionary.put(abbreviation, explanation);
        }
    }

    public boolean hasAbbreviation(String abbreviation) {
        abbreviation = sanitizedString(abbreviation);
        return this.dictionary.containsKey(abbreviation);
    }

    public String findExplanationFor(String abbreviation) {
        abbreviation = sanitizedString(abbreviation);
        return this.dictionary.get(abbreviation);
    }

    private String sanitizedString(String string) {
        if (string == null) {
            string = "";
        }
        string = string.toLowerCase();
        return string.trim();
    }

}
