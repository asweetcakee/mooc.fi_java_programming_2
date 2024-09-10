/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mefferio
 */
public class ProductWarehouse extends Warehouse{
    private String productName;

    public ProductWarehouse(String productName, double capacity) {
        super(capacity);
        this.productName = sanitizedString(productName);
    }
    
    public String getName(){
        return this.productName;
    }
    
    public void setName(String newName){
        newName = sanitizedString(newName);
        this.productName = newName;
    }
    
    private String sanitizedString(String string){
        if (string == null){
            string = "";
        }
        return string.trim();        
    }

    @Override
    public String toString() {
        return this.productName + ": balance = " + super.getBalance() + ", space left " + super.howMuchSpaceLeft(); 
    }
    
    
}
