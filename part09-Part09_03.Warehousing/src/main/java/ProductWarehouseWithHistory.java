/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mefferio
 */
public class ProductWarehouseWithHistory extends ProductWarehouse{
    private ChangeHistory log;

    public ProductWarehouseWithHistory(String productName, double capacity, double initialBalance) {
        super(productName, capacity);
        super.addToWarehouse(initialBalance);
        this.log = new ChangeHistory();
        this.log.add(super.getBalance());
    }
    
    @Override
    public void addToWarehouse(double amount){
        super.addToWarehouse(amount);
        this.log.add(super.getBalance());
    }
    
    @Override
    public double takeFromWarehouse(double amount){
        double changedState = super.takeFromWarehouse(amount);
        this.log.add(super.getBalance());
        return changedState;
    }
    
    public void printAnalysis(){
        System.out.println("Product: " + this.getName());
        System.out.println("History: " + history());
        System.out.println("Largest amount of product: " + this.log.maxValue());
        System.out.println("Smallest amount of product: " + this.log.minValue());
        System.out.println("Average: " + this.log.average());
    }
    
    public String history() {
        return this.log.toString();
    }
    
    
}
