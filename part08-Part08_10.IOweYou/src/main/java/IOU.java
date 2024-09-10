
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mefferio
 */
public class IOU {
    private final HashMap<String, Double> map;

    public IOU() {
        this.map = new HashMap<>();
    }
    
    public void setSum(String toWhom, double amount){
        toWhom = sanitizedString(toWhom);
        this.map.put(toWhom, amount);
    }
    
    public double howMuchDoIOweTo(String toWhom){
        toWhom = sanitizedString(toWhom);
        double amount = this.map.getOrDefault(toWhom, 0.0);
        return amount;
    }
    
    private String sanitizedString(String string){
        if (string == null){
            string = "";
        }
        return string.toLowerCase().trim();
    }
    
}
