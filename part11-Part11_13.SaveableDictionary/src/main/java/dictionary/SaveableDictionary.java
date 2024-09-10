/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author mefferio
 * Comments-recommendations below are my own observations 
 * that I left after I finished the program.
 */
public class SaveableDictionary {

    private Map<String, String> translations;
    private String file;

    public SaveableDictionary() {
        this.translations = new HashMap<>();
    }

    public SaveableDictionary(String file) {
        this.file = sanitizedString(file);
        this.translations = new HashMap<>();
    }

    public boolean load() {
        // Consider using a better exceptions hadling instead of e.getMessage()
        try {
            Files.lines(Paths.get(this.file))
                    .filter(row -> row != null && row.contains(":")) // format word:translation
                    .map(row -> row.split(":"))
                    .filter(parts -> parts.length >= 2)
                    .forEach(parts -> {
                        String word = sanitizedString(parts[0]);
                        String translation = sanitizedString(parts[1]);
                        this.add(word, translation);
                    });
            return true;
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return false;
    }

    public void add(String words, String translation) throws IllegalArgumentException {
        words = sanitizedString(words);
        translation = sanitizedString(translation);

        if (words.isEmpty() || translation.isEmpty()) {
            throw new IllegalArgumentException("Both words and translation must be non-empty.");
        }
        
        if (isReversedTranslationPresent(words, translation)){
            return;
        }
        
        if (this.translations.containsKey(words)) {
            updateExistingTranslation(words, translation);
        } else {
            this.translations.put(words, translation);
        }
    }

    public String translate(String word) {
        String directTranslation = this.translations.getOrDefault(word, null);

        if (directTranslation != null) {
            return directTranslation;
        }

        String reverseTranslation = getWordByTranslation(word);
        return reverseTranslation;
    }

    public void delete(String word) {
        if (this.translations.containsKey(word)) {
            this.translations.remove(word);
        } else {
            deleteByTranslation(word);
        }
    }
    
    public boolean save(){
        // Consider using a better exceptions hadling instead of e.getMessage()
        List<String> lines = this.translations.entrySet().stream()
                .map(entry -> entry.getKey() + ":" + entry.getValue())
                .collect(Collectors.toCollection(ArrayList::new));
        try {
            Files.write(Paths.get(this.file), lines, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            return true;
        } catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }
        return false;
    }
    
    private boolean isReversedTranslationPresent(String word, String translation){
        // Words and translation are swapped.
        // it's important to note that 'word' is treated as a translation,
        // and 'translation' is treated as the word in the map
        // It's better to well document or refactor this approach.
        // Bi-Directional Map Solution is more concise
        // more in getWordByTranslation() comments
        String matchedTranslation = getWordByTranslation(word);        
        if (matchedTranslation == null || matchedTranslation.isEmpty()){
            return false;
        }
        return matchedTranslation.equals(translation);
    }
    
    private void deleteByTranslation(String translation) {
        // A single value in the map may contain mupltiple translations
        // separated by a delimiter (e.g., "a; b; c")
        // Current code doesn't handle such cases
        // Instead of deleting a specific translation within the value
        // It deletes entire value if it matches
        // Needs to be refactored, logic doesn't work as intended.
        // For example, if the value is "a; b; c", and we want to delete "b",
        // this code would delete the whole value, not just "b"
        // Consider reusing buildTranslation() after a specific one was deleted
        // Also think over of deleting mupltiple translations.
        Iterator<String> iterator = this.translations.values().iterator();
        while (iterator.hasNext()) {
            String element = iterator.next();
            if (element.equals(translation)) {
                iterator.remove();
            }
        }
    }

    private String getWordByTranslation(String word) {
        // Non-optimized, requiers refactoring, O(n^2)
        // Currently it iterates through the whole map and
        // for each value it separates them into possibleTranslations
        // That are also iterating over the resulted array
        // It's better to use a reverseTranslations Map<translation:word>
        // Refactoring this method to use such a map 
        // would reduce the complexity to O(1) for lookups
        Map<String, String> reverseLookup = new HashMap<>();
        
        this.translations.forEach((key, value) -> {
            if (value != null) {
                String[] possibleTranslations = value.split(";\\s*");
                for (String possibleTranslation : possibleTranslations) {
                    reverseLookup.put(possibleTranslation, key);
                }
            }
        });        
        return reverseLookup.getOrDefault(word, null);
    }

    private void updateExistingTranslation(String words, String translation) {
        String currentTranslation = this.translations.get(words);
        currentTranslation = sanitizedString(currentTranslation);

        StringBuilder updatedTranslation = buildTranslation(currentTranslation, translation);

        this.translations.put(words, updatedTranslation.toString());
    }

    private StringBuilder buildTranslation(String currentTranslation, String translation) throws IllegalArgumentException {
        // Well made, no need to change anything 
        // until parameters are not "safe for work" (sanitized)
        if (translation.isEmpty()) {
            throw new IllegalArgumentException("New translation cannot be empty.");
        }

        StringBuilder builder = new StringBuilder(currentTranslation);
        
        if (currentTranslation.contains(translation)){
            return builder;
        }
        
        if (!currentTranslation.isEmpty()) {
            builder.append("; ");
        }
        builder.append(translation);

        return builder;
    }

    public void print() {
        System.out.println("KEYS: ");
        this.translations.keySet().stream()
                .forEach(System.out::println);
        System.out.println("----------------------");
        System.out.println("VALUES: ");
        this.translations.values().stream()
                .forEach(System.out::println);
    }

    private String sanitizedString(String string) {
        if (string == null) {
            string = "";
        }
        return string.trim().toLowerCase();
    }
}
