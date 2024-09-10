
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author mefferio
 */
public class ShoppingCart {

    private final List<Item> items;

    public ShoppingCart() {
        this.items = new ArrayList<>();
    }

    public void add(String product, int price) {
        product = sanitizedString(product);
        Item item = findItemByTitle(product);
        if (item == null) {
            addItem(product, price);
        } else {
            increaseItemQuantity(item);
        }
    }
    
    private void addItem(String product, int price){
        this.items.add(new Item(product, 1, price));
    }
    
    private void increaseItemQuantity(Item item) {
        item.increaseQuantity();
    }

    private Item findItemByTitle(String product) {
        if (!areItemsEmpty()) {
            for (Item item : this.items) {
                if (item.getTitle().equals(product)) {
                    return item;
                }
            }
        }
        return null;
    }

    public int price() {
        int totalPrice = 0;
        if (!areItemsEmpty()) {
            for (Item item : this.items) {
                totalPrice += item.price();
            }
        }
        return totalPrice;
    }

    public void print() {
        if (!areItemsEmpty()) {
            for (Item item : this.items) {
                System.out.println(item);
            }
        }
    }

    private boolean areItemsEmpty() {
        return this.items.isEmpty();
    }

    private String sanitizedString(String string) {
        if (string == null) {
            string = "";
        }
        return string.trim().toLowerCase();
    }
}
