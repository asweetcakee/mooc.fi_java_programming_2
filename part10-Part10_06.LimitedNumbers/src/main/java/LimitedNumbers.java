
import java.util.ArrayList;
import java.util.Scanner;

public class LimitedNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        start(scanner);
        scanner.close();
    }
    
    private static void start(Scanner scanner){
        ArrayList<Integer> numbers = new ArrayList<>();
        while (true){
            int number = Integer.valueOf(sanitizedString(scanner.nextLine()));
            if (number < 0){
                break;
            }
            numbers.add(number);
        }
        print(numbers);
    }
   
    private static void print(ArrayList<Integer> inputs){
        inputs.stream()
                .filter(value -> value > 0 && value < 6)
                .forEach(number -> System.out.println(number));
    }
    
    private static String sanitizedString(String string){
        if (string == null){
            string = "";
        }
        return string.trim();
    }
}
