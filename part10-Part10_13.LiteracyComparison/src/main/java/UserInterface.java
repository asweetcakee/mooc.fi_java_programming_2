
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
public class UserInterface{
    private final Scanner scanner;
    private final LiteracyDataManager manager;

    public UserInterface(Scanner scanner, LiteracyDataManager manager) {
        this.scanner = scanner;
        this.manager = manager;
    }
    
    public void start(){
        String file = getFileName();
        if (!isFileNameEmpty(file)){
            this.manager.read(file);
            List<Literacy> sortedData = this.manager.sortByLiteracyPercentage();
            printData(sortedData);
        }        
                
    }
    
    private String getFileName(){
        String fileName = sanitizedString(this.scanner.nextLine());
        return fileName;
    }

    private boolean isFileNameEmpty(String input){
        return input.equals("") 
                || input.isEmpty();
    }
    
    private void printData(List<Literacy> data){
        data.stream()
                .forEach(el -> System.out.println(el));
    }
    
    private String sanitizedString(String string){
        if (string == null){
            string = "";
        }
        return string.trim();
    }
}
