

public class Main {

    public static void main(String[] args) {
        // Use this main program for testing your classes!
        Suitcase c1 = new Suitcase(12);
        Suitcase c2 = new Suitcase(4);
        Suitcase c3 = new Suitcase(30);
        Suitcase c4 = new Suitcase(9);
        Suitcase c5 = new Suitcase(2);
        
        for (int i = 1; i < 32; i++){
            c1.addItem(new Item("Item in the suitcase 1, #: " + i, i));
            c2.addItem(new Item("Item in the suitcase 2, #: " + i, i));
            c3.addItem(new Item("Item in the suitcase 3, #: " + i, i));
            c4.addItem(new Item("Item in the suitcase 4, #: " + i, i));
            c5.addItem(new Item("Item in the suitcase 5, #: " + i, i));
        }
        System.out.println("Case 1: \nWeight: " + c1.totalWeight());
        c1.printItems();
        System.out.println("Case 2: \nWeight: " + c2.totalWeight());
        c2.printItems();
        System.out.println("Case 3: \nWeight: " + c3.totalWeight());
        c3.printItems();
        System.out.println("Case 4: \nWeight: " + c4.totalWeight());
        c4.printItems();
        System.out.println("Case 5: \nWeight: " + c5.totalWeight());
        c5.printItems();
        System.out.println("-------------------------------");
        
        Hold suitcases = new Hold(46);
        suitcases.addSuitcase(c1);
        suitcases.addSuitcase(c2);
        suitcases.addSuitcase(c3);
        suitcases.addSuitcase(c4);
        suitcases.addSuitcase(c5);
        
        suitcases.printItems();
    }

}
