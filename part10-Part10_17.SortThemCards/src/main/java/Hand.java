
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mefferio
 */
public class Hand implements Comparable<Hand>{
    private List<Card> hand;

    public Hand() {
        this.hand = new ArrayList<>();
    }

    public Hand(List<Card> hand) {
        this.hand = hand;
    }   
    
    public void add(Card card){
        if (card == null){
            return;
        }
        this.hand.add(card);
    }
    
    public void print(){
        this.hand.stream()
                .forEach(System.out::println);
    }
    
    public void sort(){
        this.hand = this.hand.stream()
                .sorted()
                .collect(Collectors.toCollection(ArrayList::new));
    }
    
    public void sortBySuit(){
        Collections.sort(this.hand, new BySuitInValueOrder());
    }
    
    private int sum(){
        return this.hand.stream()
                .map(card -> card.getValue())
                .reduce(0, (previousSum, value) -> previousSum + value);
    }
    
    @Override
    public int compareTo(Hand o) {
        return this.sum() - o.sum();
    }
}
