
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mefferio
 */
public class UserInterface {
    private Scanner scanner;
    private List<String> inputs;
    private final String STOP_COMMAND = "end";

    public UserInterface(Scanner scanner) {
        this.scanner = scanner;
        this.inputs = new ArrayList<>();
    }
    
    public void start(){
        System.out.println("Input numbers, type \"" + STOP_COMMAND + "\" to stop.");
        inputProcessing();
    }
    
    private void inputProcessing(){
        while(true){
            String input = sanitizedString(this.scanner.nextLine());
            if (input.equals(STOP_COMMAND)){
                break;
            }
            add(input);            
        }
        printAverage();
    }
    
    private void add(String input){
        if (input.isEmpty()){
            return;
        }
        this.inputs.add(input);
    }
    
    private double calculateAverage(){
        if (isListEmpty()){
            return 0;
        }
        return this.inputs.stream()
                .mapToInt(num -> Integer.valueOf(num))
                .average()
                .getAsDouble();
    }
    
    private void printAverage(){
        System.out.println("average of the numbers:" 
                + calculateAverage());
    }
    
    private boolean isListEmpty(){
        return this.inputs.isEmpty();
    }
    
    private String sanitizedString(String string){
        if (string == null){
            string = "";
        }
        return string.trim().toLowerCase();
    }
}
