
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mefferio
 */
public class MisplacingBox extends Box{
    private ArrayList<Item> items;
    
    public MisplacingBox() {
        this.items = new ArrayList<>();
    }

    @Override
    public void add(Item item) {
        if (item != null){
            this.items.add(item);
        }
    }

    @Override
    public boolean isInBox(Item item) { 
        return !this.items.isEmpty() && 
               !this.items.contains(item);
    }
    
    
}
