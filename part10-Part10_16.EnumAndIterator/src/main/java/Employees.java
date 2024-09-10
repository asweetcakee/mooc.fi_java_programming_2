
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mefferio
 */
public class Employees {
    private List<Person> employees;

    public Employees() {
        this.employees = new ArrayList<>();
    }
    
    public void add(Person personToAdd){
        if (personToAdd == null){
            return;
        }
        this.employees.add(personToAdd);
    }
    
    public void add(List<Person> peopleToAdd){
        if (peopleToAdd.isEmpty() || this.employees == null){
            return;
        }
        this.employees.addAll(peopleToAdd);
    }
    
    public void print(){
        this.employees.stream()
                .forEach(el -> System.out.println(el));
    }
    
    public void print(Education education){
        Iterator<Person> iterator = this.employees.iterator();
        while (iterator.hasNext()){
            Person person = iterator.next();
            if (person.getEducation().equals(education)){
                System.out.println(person);
            }
        }
    }
    
    public void fire(Education education){
        Iterator<Person> iterator = this.employees.iterator();
        while(iterator.hasNext()){
            Person person = iterator.next();
            if (person.getEducation().equals(education)){
                iterator.remove();
            }
        }
    }
}
