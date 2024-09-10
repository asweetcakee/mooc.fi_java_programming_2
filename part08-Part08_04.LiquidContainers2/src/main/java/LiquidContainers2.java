
import java.util.Scanner;

public class LiquidContainers2 {

    private static Scanner scan;
    private static Container first;
    private static Container second;
    private static final String ADD_COMMAND = "add";
    private static final String QUIT_COMMAND = "quit";
    private static final String REMOVE_COMMAND = "remove";
    private static final String MOVE_COMMAND = "move";

    public static void main(String[] args) {
        initializeObjects();
        inputProcessing();
    }

    private static void initializeObjects() {
        scan = new Scanner(System.in);
        first = new Container();
        second = new Container();
    }

    private static void inputProcessing() {
        while (true) {
            printContainer();

            String input = scan.nextLine().trim().toLowerCase();
            if (input.equals(QUIT_COMMAND)) {
                break;
            }
            
            handleCommand(input);
        }
    }

    private static void printContainer() {
        System.out.println("First: " + first.toString());
        System.out.println("Second: " + second.toString());
    }

    private static void handleCommand(String input) {
        String[] parts = input.split(" ");
        String command = parts[0];
        int amount = Integer.valueOf(parts[1]);
        
        switch (command) {
            case ADD_COMMAND:
                first.add(amount);
                break;
            case REMOVE_COMMAND:
                second.remove(amount);
                break;
            case MOVE_COMMAND:
                first = second.move(amount, first);
                break;
            default:
                System.out.println("Given command does not exist.");
                break;
        }
    }
}
