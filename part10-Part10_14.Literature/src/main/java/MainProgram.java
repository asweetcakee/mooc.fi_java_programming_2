
import java.util.Scanner;

public class MainProgram {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BookManager manager = new BookManager();
        UserInterface ui = new UserInterface(scanner, manager);
        ui.start();
        scanner.close();
    }

}
