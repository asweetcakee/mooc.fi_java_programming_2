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

    private final Scanner scanner;
    private final BookManager manager;
    private final String EXIT_COMMAND = "";

    public UserInterface(Scanner scanner, BookManager manager) {
        this.scanner = scanner;
        this.manager = manager;
    }

    public void start() {
        handleInput();
        printAddedBooksDetails();
    }
    
    private void handleInput(){
        while (true) {
            String title = getTitle();
            if (title.equals(EXIT_COMMAND)) {
                break;
            }
            int age = getAge();
            addBookFromInput(title, age);
        }
    }
    
    private void addBookFromInput(String title, int age) {
        this.manager.add(title, age);
    }

    private void printAddedBooksDetails() {
        System.out.println(getQuantityOfAddedBooks()
                + " books in total.\n");
        System.out.println("Books: ");
        this.manager.printBooks();
    }

    private int getQuantityOfAddedBooks() {
        return this.manager.quantityOfAddedBooks();
    }

    private String getTitle() {
        System.out.println("Input the name of the book, empty stops: ");
        return Tools.sanitizedString(this.scanner.nextLine());
    }

    private int getAge() {
        while (true) {
            try {
                System.out.println("Input the age recommendation: ");
                String input = Tools.sanitizedString(this.scanner.nextLine());
                int age = parseAge(input);
                if (Tools.ageIsNotNegative(age)) {
                    return age;
                } else {
                    System.out.println("Age must be positive."
                            + "\nPlease enter again: ");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input: " + e.getMessage()
                        + "\nPlease enter a valid integer for age: ");
            }
        }
    }

    private int parseAge(String input) throws NumberFormatException {
        return Integer.parseInt(input);
    }
}
