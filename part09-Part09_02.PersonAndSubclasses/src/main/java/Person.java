/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mefferio
 */
public class Person {
    private String fullName;
    private String address;

    public Person(String fullName, String address) {
        this.fullName = sanitizedString(fullName);
        this.address = sanitizedString(address);
    }

    public Person() {
        this("", "");
    }    
    
    private String sanitizedString(String string){
        if (string == null){
            string = "";
        }
        return string.trim();
    }

    @Override
    public String toString() {
        return this.fullName + "\n  " + this.address;
    }
    
    
}
