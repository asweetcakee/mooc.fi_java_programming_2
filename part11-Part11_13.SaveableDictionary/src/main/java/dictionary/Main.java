package dictionary;

public class Main {

    public static void main(String[] args) {
        // You can test your dictionary here
//        SaveableDictionary dictionary = new SaveableDictionary("word.txt");
//        boolean wasSuccessful = dictionary.load();
//
//        if (wasSuccessful) {
//            System.out.println("Successfully loaded the dictionary from file");
//        }
//
//        dictionary.print();
//        System.out.println("======================");
//        
//        
//        System.out.println("======================");
//        System.out.println(dictionary.translate("apina"));
//        System.out.println(dictionary.translate("ohjelmointi"));
//        System.out.println(dictionary.translate("alla oleva"));
//        System.out.println(dictionary.translate("monkey"));
//        System.out.println(dictionary.translate("apfe"));
        
        SaveableDictionary dictionary = new SaveableDictionary();
        dictionary.add("a", "b");
        dictionary.add("a", "c");
        dictionary.add("a", "b");
        dictionary.add("b", "a");
        dictionary.add("b", "d");
        dictionary.add("d", "b");
        dictionary.print();
        
    }
}
