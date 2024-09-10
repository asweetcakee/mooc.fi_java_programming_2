
import java.util.ArrayList;
import java.util.List;


public class mainProgram {

    public static void main(String[] args) {
        // test your method here
        List<String> names = new ArrayList<>();
        names.add("First");
        names.add("Second");
        names.add("Third");

        System.out.println(returnSize(names));
    }

    // Implement here a method returnSize
    // which returns the size of the list given to it
    //as a parameter
    private static int returnSize(List<String> list) {
        if (list.isEmpty() || list == null){
            return 0;
        }
        return list.size();
    }
}
