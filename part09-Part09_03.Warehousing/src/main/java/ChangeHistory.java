
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
public class ChangeHistory {

    private ArrayList<Double> inventoryChangeLog;

    public ChangeHistory() {
        this.inventoryChangeLog = new ArrayList<>();
    }

    public void add(double status) {
        this.inventoryChangeLog.add(status);
    }

    public void clear() {
        this.inventoryChangeLog.clear();
    }

    public double maxValue() {
        if (this.inventoryChangeLog.isEmpty()) {
            return 0;
        }
        double max = Double.NEGATIVE_INFINITY;
        for (Double el : this.inventoryChangeLog){
            if (max < el){
                max = el;
            }
        }
        return max;
    }
    
    public double minValue(){
        if (this.inventoryChangeLog.isEmpty()) {
            return 0;
        }
        double min = Double.POSITIVE_INFINITY;
        for (Double el : this.inventoryChangeLog){
            if (min > el){
                min = el;
            }
        }
        return min;
    }
    
    public double average(){
        if (this.inventoryChangeLog.isEmpty()) {
            return 0;
        }
        double sum = 0.0;
        for (Double el : this.inventoryChangeLog){
            sum += el;
        }
        return sum > 0 ? sum/this.inventoryChangeLog.size() : 0.0;
    }
    
    @Override
    public String toString() {
        return this.inventoryChangeLog.toString();
    }

}
