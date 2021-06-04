package com.kodilla.good.patterns.challanges.flights;

import java.util.ArrayList;
import java.util.List;

public class FlightRepository {

    public List<Flight> flights = new ArrayList<>();

    public void addFlight(Flight flight) {
        flights.add(flight);
    }

    public List<Flight> getFlights() {
        return flights;
    }
}
