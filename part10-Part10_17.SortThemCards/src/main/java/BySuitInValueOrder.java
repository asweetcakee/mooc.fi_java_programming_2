
import java.util.Comparator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mefferio
 */
public class BySuitInValueOrder implements Comparator<Card>{

    @Override
    public int compare(Card o1, Card o2) {
        int suitComparison = o1.getSuit().ordinal() - o2.getSuit().ordinal();
        
        if (suitComparison == 0){
            return o1.getValue() - o2.getValue();
        }
        
        return suitComparison;
    }    
}
