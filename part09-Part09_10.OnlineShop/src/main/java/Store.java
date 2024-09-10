/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mefferio
 */
import java.util.Scanner;

public class Store {

    private Warehouse warehouse;
    private Scanner scanner;

    public Store(Warehouse warehouse, Scanner scanner) {
        this.warehouse = warehouse;
        this.scanner = scanner;
    }

    // the method that handles the customers visit to the store.
    public void shop(String customer) {
        ShoppingCart cart = new ShoppingCart();
        System.out.println("Welcome to the store " + customer);
        System.out.println("our selection:");

        for (String product : this.warehouse.products()) {
            System.out.println(product);
        }

        while (true) {
            System.out.print("What to put in the cart (press enter to go to the register): ");
            String product = scanner.nextLine();
            product = sanitizedString(product);
            if (product.isEmpty()) {
                break;
            }
            // Add code here that adds the product to the cart,
            // If there is any in the warehouse, and reduces the stock in the warehouse
            // Don't touch any of the other code!
            if (isProductOutOfStock(product)){
                System.out.println("Product out of stock!");
                continue;
            }
            if (isProductInWarehouse(product)){
                cartProcessing(cart, product);
            }
        }

        System.out.println("your shoppingcart contents:");
        cart.print();
        System.out.println("total: " + cart.price());
    }
    
    private void cartProcessing(ShoppingCart cart, String product) {
        addToCart(cart, product);
        updateProductQuantityInWarehouse(product);
        cart.print();
    }
    
    private boolean isProductOutOfStock(String product){
        return this.warehouse.stock(product) <= 0;        
    }
    
    private void updateProductQuantityInWarehouse(String product){
        this.warehouse.take(product);
    }
    
    private void addToCart(ShoppingCart cart, String product){
        int price = getSingleProductPrice(product);
        cart.add(product, price);
    }
    
    private int getSingleProductPrice(String product){
        return this.warehouse.price(product);
    }
    
    private boolean isProductInWarehouse(String product){
        if (!isWarehouseEmpty()){
            for (String item : this.warehouse.products()){
                if (item.equals(product)){
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean isWarehouseEmpty(){
        return this.warehouse.products().isEmpty();
    }
    
    private String sanitizedString(String string){
        if (string == null){
            string = "";
        }
        return string.trim().toLowerCase();
    }
}
