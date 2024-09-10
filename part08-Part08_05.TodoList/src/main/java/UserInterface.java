
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
    private TodoList list;
    private final Scanner scanner;
    private final String STOP_COMMAND = "stop";
    private final String ADD_COMMAND = "add";
    private final String LIST_COMMAND = "list";
    private final String REMOVE_COMMAND = "remove";

    public UserInterface(TodoList list, Scanner scanner) {
        this.list = list;
        this.scanner = scanner;
    }
    
    public void start(){
        inputProcessing();
    }
    
    private void inputProcessing(){
        while (true){
            System.out.println("Command: ");
            String command = scanner.nextLine().trim().toLowerCase();
            if (command.equals(STOP_COMMAND)){
                break;
            }
            
            commandsProcessing(command);
        }
    }
    
    private void commandsProcessing(String command){
        switch (command){
            case ADD_COMMAND:
                addCommand();
                break;
            case LIST_COMMAND:
                listCommand();
                break;
            case REMOVE_COMMAND:
                removeCommand();
                break;
            default:
                System.out.println("Given command does not exist.");
                break;
        }
    }
    
    private void addCommand(){
        System.out.println("To add: ");
        String task = scanner.nextLine().trim();
        this.list.add(task);
    }
    
    private void listCommand(){
        this.list.print();
    }
    
    private void removeCommand(){
        System.out.println("Which one is removed? ");
        int taskNumToRemove = Integer.valueOf(scanner.nextLine().trim());
        this.list.remove(taskNumToRemove);
    }
}
