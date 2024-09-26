package title;

import java.util.Scanner;
import javafx.application.Application;


public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please name the program: ");
        String title = "--title=" + scan.nextLine().trim();
        // Launching the app and passing --title parameter (Key=Value)
        Application.launch(UserTitle.class, title);
    }

}
