
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ReadingFilesPerLine {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // test the method here
        String file = sanitizedString(scanner.nextLine());
        print(read(file));
    }
    
    public static List<String> read(String file){
        try {
            return Files.lines(Paths.get(file))
                    .collect(Collectors.toCollection(ArrayList::new));
        } catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
        return new ArrayList<>();
    }
    
    private static void print(List<String> list){
        list.stream()
                .forEach(row -> System.out.println(row));
    }
    
    private static String sanitizedString(String string){
        if (string == null){
            string = "";
        }
        return string.trim();
    }
}
