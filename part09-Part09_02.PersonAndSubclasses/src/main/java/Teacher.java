/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mefferio
 */
public class Teacher extends Person{
    private int salary;

    public Teacher(String fullName, String address, int salary) {
        super(fullName, address);
        if (salary > 0){
            this.salary = salary;
        }
    }

    @Override
    public String toString() {
        return super.toString() + "\n  salary " + this.salary + " euro/month";
    }
    
}
