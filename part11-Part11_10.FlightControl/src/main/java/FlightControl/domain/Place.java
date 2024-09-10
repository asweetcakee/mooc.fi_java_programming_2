/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FlightControl.domain;

/**
 *
 * @author mefferio
 */
public class Place {
    private final InternationalAirport id;

    public Place(InternationalAirport id) {
        this.id = id;
    }

    public InternationalAirport getId() {
        return id;
    }

    @Override
    public String toString() {
        return this.id.toString();
    }    
}
