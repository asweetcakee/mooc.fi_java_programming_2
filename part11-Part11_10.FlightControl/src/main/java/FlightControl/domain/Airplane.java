/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FlightControl.domain;

import FlightControl.tools.Utils;
/**
 *
 * @author mefferio
 */
public class Airplane {
    private final String id;
    private final int capacity;

    public Airplane(String id, int capacity) {
        this.id = Utils.sanitizedID(id);
        if (capacity > 0){
            this.capacity = capacity;
        } else {
            this.capacity = 1;
        }
    }

    public String getId() {
        return id;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append(this.id)
                .append(" (")
                .append(this.capacity)
                .append(" capacity)")
                .toString();
    }    
}
