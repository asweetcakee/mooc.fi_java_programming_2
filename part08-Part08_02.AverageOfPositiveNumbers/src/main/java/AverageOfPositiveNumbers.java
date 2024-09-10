
import java.util.Scanner;

public class AverageOfPositiveNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        int counter = 0;
        while (true) {
            try {
                int number = Integer.valueOf(scanner.nextLine().trim());

                if (number == 0) {
                    break;
                }

                if (number > 0) {
                    sum += number;
                    counter++;
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        if (sum == 0) {
            System.out.println("Cannot calculate the average");
        } else {
            System.out.println(1.0 * sum / counter);
        }
        
    }
}
