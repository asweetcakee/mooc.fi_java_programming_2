/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mefferio
 */
public class Book implements Packable{
    private String author;
    private String title;
    private double weight;

    public Book(String author, String title, double weight) {
        this.author = sanitizedString(author);
        this.title = sanitizedString(title);
        if (weight > 0){
            this.weight = weight;
        }
    }

    public String getAuthor() {
        //return capitalazeFirstLetter(this.author);
        return this.author;
    }
    
    public String getTitle() {
        //return capitalazeFirstLetter(this.title);
        return this.title;
    }
    
    @Override
    public double weight() {
        return this.weight;
    }
    
    private String sanitizedString(String string){
        if (!isStringEmpty(string)){
            return string.trim();
        }
        return "";
    }
    
//    private String capitalazeFirstLetter(String string){
//        if (!isStringEmpty(string)){
//            return string.substring(0, 1).toUpperCase() + string.substring(1);
//        }
//        return "";
//    }
    
    private boolean isStringEmpty(String string){
        return string == null || string.isEmpty();
    }

    @Override
    public String toString() {
        return this.getAuthor() + ": " + this.getTitle();
    }    
}
