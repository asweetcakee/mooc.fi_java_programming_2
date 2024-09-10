
import java.util.ArrayList;
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
public class UserInterface {

    private Scanner scanner;
    private List<String> positiveInputs;
    private List<String> negativeInputs;
    private final String STOP_COMMAND = "end";

    public UserInterface(Scanner scanner) {
        this.scanner = scanner;
        this.positiveInputs = new ArrayList<>();
        this.negativeInputs = new ArrayList<>();
    }

    public void start() {
        System.out.println("Input numbers, type \"" + STOP_COMMAND + "\" to stop.");
        inputProcessing();
    }

    private void inputProcessing() {
        while (true) {
            String input = sanitizedString(this.scanner.nextLine());
            if (input.equals(STOP_COMMAND)) {
                break;
            }
            add(input);
        }
        printAverage();
    }

    private void add(String input) {
        if (input.isEmpty()) {
            return;
        }
        if (isPositive(input)) {
            this.positiveInputs.add(input);
        } else {
            this.negativeInputs.add(input);
        }
    }

    private boolean isPositive(String input) {
        return Integer.valueOf(input) > 0;
    }

    private double calculateAverage(List<String> inputs) {
        if (isListEmpty(inputs)) {
            return 0;
        }
        return inputs.stream()
                .mapToInt(num -> Integer.valueOf(num))
                .average()
                .getAsDouble();
    }

    private void printAverage() {
        System.out.println("Print the average of the negative numbers or the positive numbers? (n/p)");
        processAverageInput();
    }

    private void processAverageInput() {
        String input = sanitizedString(this.scanner.nextLine());
        switch (input) {
            case "n":
                printNegativeAverage();
                break;
            case "p":
                printPositiveAverage();
                break;
            default:
                break;
        }
    }

    private void printNegativeAverage() {
        if (isListEmpty(this.negativeInputs)) {
            return;
        }
        System.out.println("Average of the negative numbers: "
                + calculateAverage(this.negativeInputs));
    }

    private void printPositiveAverage() {
        if (isListEmpty(this.positiveInputs)) {
            return;
        }
        System.out.println("Average of the positive numbers: "
                + calculateAverage(this.positiveInputs));
    }

    private boolean isListEmpty(List<String> inputs) {
        return inputs.isEmpty();
    }

    private String sanitizedString(String string) {
        if (string == null) {
            string = "";
        }
        return string.trim().toLowerCase();
    }
}
