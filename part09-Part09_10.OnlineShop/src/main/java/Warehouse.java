
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author mefferio
 */
public class Warehouse {

    private Map<String, Integer> prices;
    private Map<String, Integer> stocks;

    public Warehouse() {
        this.prices = new HashMap<>();
        this.stocks = new HashMap<>();
    }

    public void addProduct(String product, int price, int stock) {
        product = sanitizedString(product);
        if (isPriceAndStockValid(price, stock)) {
            this.prices.put(product, price);
            this.stocks.put(product, stock);
        }
    }

    private boolean isPriceAndStockValid(int price, int stock) {
        return price > 0 && stock > 0;
    }

    public int price(String product) {
        product = sanitizedString(product);
        return this.prices.getOrDefault(product, -99);
    }

    public int stock(String product) {
        product = sanitizedString(product);
        return this.stocks.getOrDefault(product, 0);
    }
    
    public Set<String> products(){
        Set<String> keys = this.prices.keySet();
        return keys;
    }
    
    public boolean take(String product) {
        product = sanitizedString(product);
        if (canTakeProduct(product)) {
            reduceStock(product);
            return true;
        }
        return false;
    }

    private boolean canTakeProduct(String product) {
        return stock(product) > 0;
    }
    
    private void reduceStock(String product){
        this.stocks.put(product, stock(product) - 1);
    }

    private String sanitizedString(String string) {
        if (string == null) {
            string = "";
        }
        return string.trim().toLowerCase();
    }
}
