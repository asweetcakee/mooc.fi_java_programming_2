
import java.util.Scanner;



public class MainProgram {

    public static void main(String[] args) {
        // you can create test code here. Call the methods that you'll implement
        // during the course of this exercise
        Scanner scanner = new Scanner(System.in);
        Checker check = new Checker();
        
        System.out.println("Enter a string: ");
        String string = scanner.nextLine().trim();
        //checkDayOfWeek(check, string);  
        //checkAllVowels(check, string);
        checkTimeOfDay(check, string);
        
    }
    
    private static void checkDayOfWeek(Checker check, String string){
        print(check.isDayOfWeek(string));
    }
    
    private static void checkAllVowels(Checker check, String string){
        print(check.allVowels(string));
    }
    
    private static void checkTimeOfDay(Checker check, String string){
        print(check.timeOfDay(string));
    }
    
    private static void print(boolean flag){
        if (flag){
            System.out.println("The form is correct.");
        } else {
            System.out.println("The form is incorrect.");
        }
    }
}
