/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FlightControl.logic;

import FlightControl.domain.Airplane;
import FlightControl.domain.Flight;
import FlightControl.domain.InternationalAirport;
import FlightControl.domain.Place;
import FlightControl.tools.Utils;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author mefferio
 */
public class FlightControl {

    private Map<String, Airplane> airplanes;
    private Map<String, Flight> flights;
    private Map<InternationalAirport, Place> airports;

    public FlightControl() {
        this.airplanes = new HashMap<>();
        this.airports = new HashMap<>();
        this.flights = new HashMap<>();
    }

    public void addAirplane(String id, int capacity) {
        id = Utils.sanitizedID(id);
        this.airplanes.put(id, new Airplane(id, capacity));
    }

    public void addFlight(Airplane airplane, InternationalAirport departureID, InternationalAirport destinationID) {
        this.airports.putIfAbsent(departureID, new Place(departureID));
        this.airports.putIfAbsent(destinationID, new Place(destinationID));

        Flight flight = new Flight(airplane, this.airports.get(departureID), this.airports.get(destinationID));
        this.flights.put(flight.toString(), flight);
    }

    public Collection<Airplane> getAirplanes() {
        return this.airplanes.values();
    }

    public Collection<Place> getAirports() {
        return this.airports.values();
    }

    public Collection<Flight> getFlights() {
        return this.flights.values();
    }

    public Flight getFlightByAirplaneId(Airplane airplane) {
        for (String key : this.flights.keySet()) {
            String[] parts = key.split(" "); // Split the key by space
            String keyAirplaneId = parts[0]; // The first part is the airplane ID

            if (keyAirplaneId.equals(airplane.getId())) {
                return this.flights.get(key); // Return the matching flight 
            }
        }
        return null;
    }

    public Airplane getAirplane(String ID) {
        return this.airplanes.get(ID);
    }

}
