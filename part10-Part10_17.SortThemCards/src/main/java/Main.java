
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // test your code here
        checkHowCardsAndHandAdd();
        System.out.println("------------------");

        checkTwoHandsComparison();
        System.out.println("------------------");
        
        checkHandCardsSort();
    }

    private static void print(List<Card> list) {
        list.stream()
                .forEach(System.out::println);
    }

    private static void checkHowCardsAndHandAdd() {
        Card first = new Card(2, Suit.DIAMOND);
        Card second = new Card(14, Suit.SPADE);
        Card third = new Card(12, Suit.HEART);
        Card fourth = new Card(2, Suit.CLUB);
        Card fifth = new Card(14, Suit.DIAMOND);
        Card sixth = new Card(12, Suit.SPADE);
        Card seventh = new Card(10, Suit.HEART);
        Card eigth = new Card(10, Suit.SPADE);

        List<Card> cards = new ArrayList<>();
        cards.add(first);
        cards.add(second);
        cards.add(third);
        cards.add(fourth);
        cards.add(fifth);
        cards.add(sixth);
        cards.add(seventh);
        cards.add(eigth);

        Hand hand = new Hand();
        hand.add(first);
        hand.add(second);
        hand.add(third);
        hand.add(fourth);
        hand.add(fifth);
        hand.add(sixth);
        hand.add(seventh);
        hand.add(eigth);

        System.out.println("CARDS: ");
        print(cards);
        System.out.println("------------------");
        System.out.println("HAND SORTED: ");
        hand.sort();
        hand.print();
    }

    private static void checkTwoHandsComparison() {
        Hand hand1 = new Hand();

        hand1.add(new Card(2, Suit.DIAMOND));
        hand1.add(new Card(14, Suit.SPADE));
        hand1.add(new Card(12, Suit.HEART));
        hand1.add(new Card(2, Suit.SPADE));

        Hand hand2 = new Hand();

        hand2.add(new Card(11, Suit.DIAMOND));
        hand2.add(new Card(11, Suit.SPADE));
        hand2.add(new Card(11, Suit.HEART));

        int comparison = hand1.compareTo(hand2);

        if (comparison < 0) {
            System.out.println("better hand is");
            hand2.print();
        } else if (comparison > 0) {
            System.out.println("better hand is");
            hand1.print();
        } else {
            System.out.println("hands are equal");
        }
    }

    private static void checkHandCardsSort() {
        ArrayList<Card> newCards = new ArrayList<>();

        newCards.add(new Card(3, Suit.SPADE));
        newCards.add(new Card(2, Suit.DIAMOND));
        newCards.add(new Card(14, Suit.SPADE));
        newCards.add(new Card(12, Suit.HEART));
        newCards.add(new Card(2, Suit.SPADE));
        
        // Sort #1
        firstWayOfSort(newCards);
        
        // Sort #2
        secondWayOfSort(newCards);
        
        // Sort #3
        thirdWayOfSort(newCards);
        
        // Sort #4
        Hand hand = createHandInstance();
        fourthWayOfSort(hand);

    }

    private static void firstWayOfSort(List<Card> newCards) {
        // Sotring by using class SortBySuit that implements Comparator
        // compares by Suit only
        System.out.println("SORT 1:");
        SortBySuit sortBySuitSorter = new SortBySuit();
        Collections.sort(newCards, sortBySuitSorter);
        print(newCards);
        System.out.println("");
    }

    private static void secondWayOfSort(List<Card> newCards) {
        // Sorting by lamda expression
        // compares by Suit only
        System.out.println("SORT 2:");
        Collections.sort(newCards, (c1, c2) -> c1.getSuit().ordinal() - c2.getSuit().ordinal());
        print(newCards);
        System.out.println("");
    }

    private static void thirdWayOfSort(List<Card> newCards) {
        // Sorting by Comparator without any class       
        // compares by Suit only
        System.out.println("SORT 3:");
        Comparator<Card> comparator = Comparator
                .comparing(Card::getSuit);
        Collections.sort(newCards, comparator);
        print(newCards);
        System.out.println("");
    }

    private static Hand createHandInstance() {
        Hand hand = new Hand();

        hand.add(new Card(12, Suit.HEART));
        hand.add(new Card(4, Suit.SPADE));
        hand.add(new Card(2, Suit.DIAMOND));
        hand.add(new Card(14, Suit.SPADE));
        hand.add(new Card(7, Suit.HEART));
        hand.add(new Card(2, Suit.SPADE));

        return hand;
    }

    private static void fourthWayOfSort(Hand hand) {
        // Sotring by using class BySuitInValueOrder that implements Comparator
        // compares by Suit and then Value
        System.out.println("SORT 4:");
        hand.sortBySuit();
        hand.print();
        System.out.println("");
    }
}
