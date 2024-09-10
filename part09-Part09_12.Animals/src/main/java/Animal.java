/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mefferio
 */
public abstract class Animal {
    private String name;
    
    public Animal(String name) {
        name = sanitizedString(name);
        this.name = name;
    }
    
    public String getName(){
        return this.name;
    }
    
    public void eat(){
        System.out.println(this.getName() + " eats");
    }
    public void sleep(){
        System.out.println(this.getName() + " sleeps");
    }
    
    private String sanitizedString(String string){
        if(string == null){
            string = "";
        }
        return string.trim();
    }
}
