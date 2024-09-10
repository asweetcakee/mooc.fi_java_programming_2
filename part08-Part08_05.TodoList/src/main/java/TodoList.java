
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mefferio
 */
public class TodoList {
    private ArrayList<String> todoList;
    private final String ERROR_NULL_MESSAGE = " can not be null or empty.";

    public TodoList() {
        this.todoList = new ArrayList<>();
    }
    
    public void add(String task){
        if (task.isEmpty()){
            System.out.println("Given task" + ERROR_NULL_MESSAGE);
            return;
        }
        this.todoList.add(task);
    }

    public void print(){
        if (this.todoList.isEmpty() || this.todoList == null){
            System.out.println("Todo list" + ERROR_NULL_MESSAGE);
            return;
        }
        
        int taskNumber = 1;
        for (String task : this.todoList){
            System.out.println(taskNumber + ": " + task);
            taskNumber++;
        }
    }
    
    public void remove(int number){
        if (number > 0){
            String removedTask = this.todoList.get(number-1);
            this.todoList.remove(removedTask);
        }
    }
    
}
