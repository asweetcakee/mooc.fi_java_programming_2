
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BooksFromFile {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // test your method here
        String file = sanitizedString(scanner.nextLine());
        print(readBooks(file));
    }
    
    public static List<Book> readBooks(String file){
        try{
            return Files.lines(Paths.get(file))
                    .map(row -> row.split(","))
                    .filter(parts -> parts.length >= 2)
                    .map(parts -> new Book(sanitizedString(parts[0])
                            ,Integer.valueOf(parts[1])
                            ,Integer.valueOf(parts[2])
                            ,sanitizedString(parts[3])))
                    .collect(Collectors.toCollection(ArrayList::new));
        } catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
        return new ArrayList<>();
    }
    
    private static void print(List<Book> list){
        list.stream()
                .forEach(book -> System.out.println(book + "\n"));
    }
    
    private static String sanitizedString(String string){
        if (string == null){
            string = "";
        }
        return string.trim();
    }
}
