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
    private String name;
    private Education education;

    public Person(String name, Education education) {
        this.name = name;
        this.education = education;
    }
    
    public Education getEducation(){
        return this.education;
    }
    
    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();
        result.append(this.name);
        result.append(", ");
        result.append(this.education);
        return result.toString();
    }
}
