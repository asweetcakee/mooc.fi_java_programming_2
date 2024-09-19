
import java.util.Random;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        int size = scanner.nextInt();
        while (size > 0){
            System.out.println(rand.nextInt(11));
            size--;
        }
    }

}
