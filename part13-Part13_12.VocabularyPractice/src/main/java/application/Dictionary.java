/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author mefferio
 */
public class Dictionary {

    private List<String> words;
    private Map<String, String> translations;

    public Dictionary() {
        this.words = new ArrayList<>();
        this.translations = new HashMap<>();
    }

    public void add(String word, String translation) throws Exception {
        // Sanitizing data
        word = Utils.sanitizedString(word);
        translation = Utils.sanitizedString(translation);
        
        // Data cannot be empty
        if (word.isEmpty() || translation.isEmpty()) {
            throw new IllegalArgumentException("Entered word or translation cannot be empty.");
        }
        
        // Doesn't add same word to the words List
        if (!doesSuchWordExist(word)) {
            this.words.add(word);
        }
        
        // Puts Key-Value pair to the translations Map
        // Rewrites Value of the existing Key
        this.translations.put(word, translation);
    }

    private boolean doesSuchWordExist(String word) {
        if (isEmpty()) {
            return false;
        }
        return this.words.contains(word);
    }

    public String getTranslation(String word) {
        return this.translations.getOrDefault(word, null);
    }

    public String getRandomWord() {
        if (isEmpty()) {
            throw new IllegalStateException("No words available in the dictionary.");
        }
        Random rand = new Random();
        return this.words.get(rand.nextInt(this.words.size()));
    }

    public boolean isEmpty() {
        return this.words.isEmpty();
    }

}
