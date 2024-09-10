
import java.util.ArrayList;
import java.util.Scanner;

public class PrintingUserInput {
        
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        start(scanner);
        scanner.close();
    }
    
    private static void start(Scanner scanner){
        ArrayList<String> inputs = new ArrayList<>();
        while (true){
            String input = sanitizedString(scanner.nextLine());
            if (input.equals("") || input.isEmpty()){
                break;
            }
            inputs.add(input);
        }
        print(inputs);
    }
   
    private static void print(ArrayList<String> inputs){
        inputs.stream()
                .forEach(string -> System.out.println(string));
    }
    
    private static String sanitizedString(String string){
        if (string == null){
            string = "";
        }
        return string.trim();
    }
}
