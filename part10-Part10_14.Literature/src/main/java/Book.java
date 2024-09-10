/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mefferio
 */
public class Book {
    private final String title;
    private final int age;

    public Book(String title, int age) {
        this.title = Tools.sanitizedString(title);
        if (Tools.ageIsNotNegative(age)){
            this.age = age;
        } else {
            throw new IllegalArgumentException("Age must be positive");
        }
    }

    public String getTitle() {
        return title;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return this.title + " (recommended for " 
                + this.age 
                + " year-olds or older)";
    }    
}
