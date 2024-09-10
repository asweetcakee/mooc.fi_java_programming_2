/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mefferio
 */
public class CD implements Packable{
    private String artist;
    private String title;
    private int pyblicationYear;
    private double weight;

    public CD(String artist, String title, int pyblicationYear) {
        this.artist = sanitizedString(artist);
        this.title = sanitizedString(title);
        if (pyblicationYear > 0){
            this.pyblicationYear = pyblicationYear;
        }
        this.weight = 0.1; // KG
    }

    public String getArtist() {
        //return capitalazeFirstLetter(this.artist);
        return this.artist;
    }

    public String getTitle() {
        //return capitalazeFirstLetter(this.title);
        return this.title;
    }

    public int getPyblicationYear() {
        return pyblicationYear;
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
        return this.getArtist() + ": " + this.getTitle() + " (" + this.getPyblicationYear() + ")";
    }  
}
