
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
public class Box implements Packable {
    private double capacity;
    private final ArrayList<Packable> box;

    public Box(double capacity) {
        if (capacity > 0) {
            this.capacity = capacity;
        }
        this.box = new ArrayList<>();
    }
    
    public void add(Packable item) {
        if (canItemBeAdded(item)) {
            this.box.add(item);
            weight();
        }
    }
    
    private boolean canItemBeAdded(Packable item) {
        return isItemValid(item) && 
                this.capacity >= this.weight() + item.weight();
    }
        
    private boolean isItemValid(Packable item) {
        return item != null;
    }
    
    public int boxSize(){
        return this.box.size();
    }
    
    @Override
    public double weight() {
        double weight = 0;
        for (Packable item : this.box){
            weight += item.weight();
        }
        return weight;
    }

    @Override
    public String toString() {
        int size = this.boxSize();
//        String itemLabel = (size > 1) ? "items" : "item";
//        return String.format("Box: %d %s, total weight %.2f kg", size, itemLabel, this.weight());
        return String.format("Box: %d items, total weight %.1f kg", size, this.weight());
    }
    
    
}
