package com.kodilla.good.patterns.challanges.flights;

public class App {

    // Iterate through flights using Stream
    // Use Equals & Hashcode contract

    public static void main(String[] args) {

        SearchFlightService searchFlightService = new SearchFlightService();

//        boolean isFound = searchFlightService.find("Jamaica", "Kazakhstan");
        boolean isFound = searchFlightService.find("Kazakhstan", "Jamaica", "Grudziądz");
//        boolean isFound = searchFlightService.find("Stockholm", "Helsinki", "Berlin");

        if (isFound) {
            searchFlightService.createResponse();
        } else {
            System.out.println("Flight not found.");
        }
    }
}
