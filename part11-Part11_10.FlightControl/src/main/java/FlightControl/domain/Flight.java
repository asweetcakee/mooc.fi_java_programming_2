/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FlightControl.domain;

import java.util.Objects;

/**
 *
 * @author mefferio
 */
public class Flight {

    private final Airplane airplane;
    private final Place departureAirport;
    private final Place destinationAirport;

    public Flight(Airplane airplane, Place departureAirport, Place destinationAirport) {
        this.airplane = Objects.requireNonNull(airplane, "Airplane cannot be NULL.");
        this.departureAirport = Objects.requireNonNull(departureAirport, "Departure airport cannot be NULL.");
        this.destinationAirport = Objects.requireNonNull(destinationAirport, "Destination airport cannot be NULL.");
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public Place getDepartureAirport() {
        return departureAirport;
    }

    public Place getDestinationAirport() {
        return destinationAirport;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append(this.airplane.toString())
                .append(" (")
                .append(this.departureAirport.getId().name())
                .append("-")
                .append(this.destinationAirport.getId().name())
                .append(")")
                .toString();
    }
}
