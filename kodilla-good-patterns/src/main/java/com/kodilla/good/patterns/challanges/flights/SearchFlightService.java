package com.kodilla.good.patterns.challanges.flights;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class SearchFlightService {

    List<Flight> arrivalFlights = new ArrayList<>();
    List<Flight> destinationFlights = new ArrayList<>();
    List<Flight> throughCityFlights = new ArrayList<>();

    public boolean find(String arrivalCity, String destinationCity) {
        System.out.println("Finding flight...");

        FlightRepository flightRepository = new FlightRepository();

        arrivalFlights = flightRepository.retrieveListOfFlights()
                .stream().filter(flight -> flight.getArrivalCity().equals(arrivalCity)).collect(Collectors.toList());

        destinationFlights = flightRepository.retrieveListOfFlights()
                .stream().filter(flight -> flight.getDestinationCity().equals(destinationCity)).collect(Collectors.toList());

        if (arrivalFlights.size() <= 0 && destinationFlights.size() <= 0) {
            return false;
        }

        System.out.println("Flight found: ");

        return true;
    }

    public boolean find(String arrivalCity, String destinationCity, String throughCity) {
        System.out.println("Finding flight...");

        FlightRepository flightRepository = new FlightRepository();

        arrivalFlights = flightRepository.retrieveListOfFlights()
                .stream().filter(flight -> flight.getArrivalCity().equals(arrivalCity)).collect(Collectors.toList());

        destinationFlights = flightRepository.retrieveListOfFlights()
                .stream().filter(flight -> flight.getDestinationCity().equals(destinationCity)).collect(Collectors.toList());

        throughCityFlights = flightRepository.retrieveListOfFlights()
                .stream().filter(flight -> flight.getFlightThroughCity().equals(throughCity)).collect(Collectors.toList());

        return arrivalFlights.size() > 0 || destinationFlights.size() > 0 || throughCityFlights.size() > 0;
    }

    public void createResponse() {

        HashSet<Flight> combinedFlights = new HashSet<>();
        combinedFlights.addAll(arrivalFlights);
        combinedFlights.addAll(destinationFlights);
        combinedFlights.addAll(throughCityFlights);


        combinedFlights
                .forEach(flight -> System.out.println(
                        "Departure city: " + flight.getArrivalCity() +
                                " | Destination city: " + flight.getDestinationCity() +
                                " | Flight through: " + flight.getFlightThroughCity() +
                                " | Departure time: " + flight.getDepartureTime() +
                                " | Destination time: " + flight.getDestinationTime()
                ));


    }
}
