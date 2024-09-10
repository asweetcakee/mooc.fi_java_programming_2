/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FlightControl.ui;

import FlightControl.domain.Flight;
import FlightControl.domain.Airplane;
import FlightControl.domain.InternationalAirport;
import FlightControl.logic.FlightControl;
import FlightControl.tools.Utils;
import java.util.Scanner;

/**
 *
 * @author mefferio
 */
public class TextUI {

    private Scanner scanner;
    private FlightControl flightControl;

    public TextUI(Scanner scanner, FlightControl flightControl) {
        this.scanner = scanner;
        this.flightControl = flightControl;
    }

    public void start() {
        startAssetControl();
        System.out.println();
        startFlightControl();
        System.out.println();
    }

    private void startAssetControl() {
        System.out.println("Airport Asset Control");
        System.out.println("--------------------");
        System.out.println();

        OUTER:
        while (true) {
            System.out.println("Choose an action:");
            System.out.println("[1] Add an airplane");
            System.out.println("[2] Add a flight");
            System.out.println("[x] Exit Airport Asset Control");
            System.out.println("> ");
            String answer = scanner.nextLine();
            switch (answer) {
                case "1":
                    addAirplane();
                    break;
                case "2":
                    addFlight();
                    break;
                case "x":
                    break OUTER;
                default:
                    break;
            }
        }
    }

    private void addAirplane() {
        System.out.println("Give the airplane id: ");
        String id = scanner.nextLine();
        System.out.println("Give the airplane capacity: ");
        int capacity = Integer.parseInt(scanner.nextLine());

        this.flightControl.addAirplane(id, capacity);
    }

    private void addFlight() {
        System.out.println("Give the airplane id: ");
        Airplane airplane = askForAirplane();
        System.out.println("Give the departure airport id: ");
        String departureID = scanner.nextLine();
        System.out.println("Give the target airport id: ");
        String destinationID = scanner.nextLine();

        InternationalAirport departureAirport = null;
        InternationalAirport destinationAirport = null;
        
        try {
            departureAirport = InternationalAirport.valueOf(Utils.sanitizedID(departureID));
            destinationAirport = InternationalAirport.valueOf(Utils.sanitizedID(destinationID));
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        this.flightControl.addFlight(airplane, departureAirport, destinationAirport);
    }

    private void startFlightControl() {
        System.out.println("Flight Control");
        System.out.println("------------");
        System.out.println();

        OUTER:
        while (true) {
            System.out.println("Choose an action:");
            System.out.println("[1] Print airplanes");
            System.out.println("[2] Print flights");
            System.out.println("[3] Print airplane details");
            System.out.println("[4] Print airports details");
            System.out.println("[5] Print airport details by airplain");
            System.out.println("[x] Quit");
            System.out.println("> ");
            String answer = scanner.nextLine();
            switch (answer) {
                case "1":
                    printAirplanes();
                    break;
                case "2":
                    printFlights();
                    break;
                case "3":
                    printAirplaneDetails();
                    break;
                case "4":
                    printAirportDetails();
                    break;
                case "5":
                    printAirportDetailsByPlaneID();
                    break;
                case "x":
                    break OUTER;
                default:
                    break;
            }
        }
    }

    private void printAirplanes() {
        this.flightControl.getAirplanes().stream()
                .forEach(System.out::println);
    }

    private void printFlights() {
        this.flightControl.getFlights().stream()
                .forEach(flight -> {
                    System.out.println(flight);
                    System.out.println();
                });
    }

    private void printAirportDetails() {
        this.flightControl.getAirports().stream()
                .forEach(System.out::println);
    }

    private void printAirportDetailsByPlaneID() {
        System.out.println("Give the airplane id: ");
        Airplane airplane = askForAirplane();

        Flight flight = this.flightControl.getFlightByAirplaneId(airplane);
        
        System.out.println();
        System.out.println(flight);
        System.out.println("Full description: ");
        System.out.println("Departure - " + flight.getDepartureAirport());
        System.out.println("Destination - " + flight.getDestinationAirport());
        System.out.println();
    }

    private void printAirplaneDetails() {
        System.out.println("Give the airplane id: ");
        Airplane plane = askForAirplane();
        System.out.println(plane);
        System.out.println();
    }

    private Airplane askForAirplane() {
        Airplane airplane = null;
        while (airplane == null) {
            String id = scanner.nextLine();
            id = Utils.sanitizedID(id);
            airplane = flightControl.getAirplane(id);

            if (airplane == null) {
                System.out.println("No airplane with the id " + id + ".");
            }
        }
        return airplane;
    }

}
