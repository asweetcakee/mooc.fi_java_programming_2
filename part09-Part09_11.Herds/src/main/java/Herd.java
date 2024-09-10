
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
public class Herd implements Movable{
    private List<Movable> movableList;

    public Herd() {
        this.movableList = new ArrayList<>();
    }
    
    public void addToHerd(Movable movable){
        if (movable == null){
            return;
        }
        this.movableList.add(movable);
    }
    
    @Override
    public void move(int dx, int dy) {
        for (Movable entity : this.movableList){
            entity.move(dx, dy);
        }
    }

    @Override
    public String toString() {
        String result = "";
        int size = this.movableList.size();
        int counter = 0;
        for (Movable entity : this.movableList){
            result += entity.toString();
            if (counter < size - 1){               
                result += "\n";
            }
            counter++;
        }
        return result;
    }
    
    
}
