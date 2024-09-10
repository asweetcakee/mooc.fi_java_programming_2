
import java.util.HashMap;

public class Program {

    public static void main(String[] args) {
        HashMap<String, String> hashmap = new HashMap<>();
        hashmap.put("f.e", "for example");
        hashmap.put("etc.", "and so on");
        hashmap.put("i.e", "more precisely");

        printKeys(hashmap);
        System.out.println("---");
        printKeysWhere(hashmap, "i");
        System.out.println("---");
        printValuesOfKeysWhere(hashmap, ".e");
    }

    public static void printKeys(HashMap<String, String> hashmap) {
        if (isHashMapEmpty(hashmap)) {
            return;
        }

        for (String key : hashmap.keySet()) {
            System.out.println(key);
        }
    }

    public static void printKeysWhere(HashMap<String, String> hashmap, String text) {
        if (isHashMapEmpty(hashmap)) {
            return;
        }
        text = sanitizedString(text);
        for (String key : hashmap.keySet()) {
            if (key.contains(text)) {
                System.out.println(key);
            }
        }
    }

    public static void printValuesOfKeysWhere(HashMap<String, String> hashmap, String text) {
        if (isHashMapEmpty(hashmap)) {
            return;
        }
        text = sanitizedString(text);
        for (String key : hashmap.keySet()) {
            if (key.contains(text)) {
                System.out.println(hashmap.get(key));
            }
        }
    }

    public static boolean isHashMapEmpty(HashMap<String, String> hashmap) {
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
        string = string.toLowerCase();
        return string.trim();
    }
}
