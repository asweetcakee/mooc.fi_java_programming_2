
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
public class BoxWithMaxWeight extends Box {

    private int capacity;
    private int balance;
    private final ArrayList<Item> items;

    public BoxWithMaxWeight(int capacity) {
        if (capacity > 0) {
            this.capacity = capacity;
        }
        this.balance = 0;
        this.items = new ArrayList<>();
    }

    @Override
    public void add(Item item) {
        if (isItemValid(item)) {
            updateBalance(item);
            if (hasSpaceForItem(item)) {
                this.items.add(item);
            }
        }
    }

    @Override
    public boolean isInBox(Item item) {
        return this.items != null && this.items.contains(item);
    }

    private boolean isItemValid(Item item) {
        return item != null;
    }

    private void updateBalance(Item item) {
        adjustBalanceIfNeeded();
        addWeightToBalance(item);
    }

    private void adjustBalanceIfNeeded() {
        if (this.balance > this.capacity) {
            this.balance = this.capacity;
        }
    }

    private void addWeightToBalance(Item item) {
        this.balance += item.getWeight();
    }

    private boolean hasSpaceForItem(Item item) {
        int spaceLeft = this.capacity - this.balance;
        return spaceLeft >= 0;
    }
}
