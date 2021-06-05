package com.kodilla.good.patterns.challanges.flights;

import java.time.LocalDateTime;
import java.util.List;

public class FlightRepository {

    public List<Flight> retrieveListOfFlights() {

        Flight flight1 = new Flight(
                "Kazakhstan",
                "Jamaica",
                LocalDateTime.of(2017, 1, 12, 10, 50),
                LocalDateTime.of(2017, 1, 12, 14, 20)
        );
        Flight flight2 = new Flight(
                "Warsaw",
                "Mallorca",
                LocalDateTime.of(2017, 1, 12, 10, 50),
                LocalDateTime.of(2017, 1, 12, 14, 20),
                "Berlin"
        );
        Flight flight3 = new Flight(
                "Mallorca",
                "Warsaw",
                LocalDateTime.of(2017, 1, 12, 10, 50),
                LocalDateTime.of(2017, 1, 12, 14, 20)
        );


        FlightRepositoryController flightRepositoryController = new FlightRepositoryController();
        flightRepositoryController.addFlight(flight1);
        flightRepositoryController.addFlight(flight2);
        flightRepositoryController.addFlight(flight3);

        return flightRepositoryController.getFlights();
    }
}
