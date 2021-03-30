package com.kodilla.exception.test;

public class FlightSearchRunner {
    public static void main(String[] args) {
        Flight flight1 = new Flight("Mexico", "Warsaw");
        Flight flight2 = new Flight("Detroit", "Barcelona");
        Flight flight3 = new Flight("Bromberg", "Munich");
        Flight flight4 = null;
        FlightSearch flightSearch = new FlightSearch();


        try {
            flightSearch.findFlight(flight1);
            flightSearch.findFlight(flight2);

            flightSearch.findFlight(flight4);

            flightSearch.findFlight(flight3);
        } catch (RouteNotFoundException e) {
            System.out.println("Exception " + '\u0022' + e + '\u0022' + " was executed but my program still running very well!");
        }

        System.out.println("\nTo be continued...");
    }
}
