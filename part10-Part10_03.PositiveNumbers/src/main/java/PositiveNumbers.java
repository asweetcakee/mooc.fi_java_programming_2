
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PositiveNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // test your method here
        List<Integer> numbers = new ArrayList<>();
        numbers.add(2);
        numbers.add(1);
        numbers.add(-5);
        numbers.add(0);
        numbers.add(32);
        numbers.add(-1);
        numbers.add(-8);
        numbers.add(22);
        
        System.out.println("Positive list: " + positive(numbers).toString());
    }
    
    public static List<Integer> positive(List<Integer> numbers){
        if (numbers.isEmpty()){
            return null;
        }
        List<Integer> positiveNumbers = numbers.stream()
                .filter(num -> num > 0)
                .collect(Collectors.toCollection(ArrayList::new));
        return positiveNumbers;
    }
}
