
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mefferio
 */
public class DictionaryOfManyTranslations {
    private HashMap<String, ArrayList<String>> dict;

    public DictionaryOfManyTranslations() {
        this.dict = new HashMap<>();
    }
    
    public void add(String word, String translation){
        word = sanitizedString(word);
        translation = sanitizedString(translation);
        
        this.dict.putIfAbsent(word, new ArrayList<>());        
        ArrayList<String> listOfWordTranslations  = this.dict.get(word);
        listOfWordTranslations.add(translation);        
    }
    
    public ArrayList<String> translate(String word){
        word = sanitizedString(word);
        return this.dict.getOrDefault(word, new ArrayList<>());
    }
    
    public void remove(String word){
        word = sanitizedString(word);
        this.dict.remove(word);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (obj == null || obj.getClass() != getClass()){
            return false;
        }
        DictionaryOfManyTranslations compared = (DictionaryOfManyTranslations) obj;
        if (this.dict == null) {
            return compared.dict == null;
        }
        return this.dict.equals(compared.dict);
    }

    @Override
    public int hashCode() {
        return this.dict != null ? this.dict.hashCode() : 0;
    }
    
    
    private String sanitizedString(String string){
        if (string == null){
            string = "";
        }
        return string.trim().toLowerCase();
    }
}
