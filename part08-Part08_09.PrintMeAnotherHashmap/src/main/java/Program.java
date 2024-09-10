
import java.util.HashMap;

public class Program {

    public static void main(String[] args) {
        HashMap<String, Book> hashmap = new HashMap<>();
        hashmap.put("sense", new Book("Sense and Sensibility", 1811, "..."));
        hashmap.put("prejudice", new Book("Pride and prejudice", 1813, "...."));

        printValues(hashmap);
        System.out.println("---");
        printValueIfNameContains(hashmap, "prejud");
    }

    public static void printValues(HashMap<String, Book> hashmap) {
        if (isHashMapEmpty(hashmap)) {
            return;
        }
        for (String title : hashmap.keySet()) {
            if (hashmap.containsKey(title)) {
                System.out.println(hashmap.get(title).toString());
            }
        }
    }

    public static void printValueIfNameContains(HashMap<String, Book> hashmap, String text) {
        if (isHashMapEmpty(hashmap)) {
            return;
        }
        text = sanitizedString(text);
        for (Book book : hashmap.values()) {
            if (book.getName().contains(text)) {
                System.out.println(book.toString());
            }
        }
    }

    private static boolean isHashMapEmpty(HashMap<String, Book> hashmap) {
        if (hashmap.isEmpty()) {
            System.out.println("Given HashMap can not be empty.");
            return true;
        }
        return false;
    }

    private static String sanitizedString(String string) {
        if (string == null) {
            string = "";
        }
        return string.toLowerCase().trim();
    }
}
