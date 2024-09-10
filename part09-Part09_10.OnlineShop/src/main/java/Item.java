/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mefferio
 */
public class Item {
    private String title;
    private int quantity;
    private int price;

    public Item(String product, int qty, int unitPrice) {
        this.title = product;
        if (qty > 0 && unitPrice > 0) {
            this.quantity = qty;
            this.price = unitPrice;
        }
    }
    
    public int price(){
        return this.price * this.quantity;
    }
    
    public void increaseQuantity(){
        this.quantity++;
    }

    public String getTitle() {
        return this.title;
    }

    @Override
    public String toString() {
        return this.title + ": " + this.quantity;
    }
    
    
}
