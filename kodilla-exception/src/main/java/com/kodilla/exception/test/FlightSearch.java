package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightSearch {

    public void findFlight(Flight flight) throws RouteNotFoundException {
        Map<String, Boolean> airports = new HashMap<>();
        airports.put("Mexico", false);
        airports.put("Detroit", true);
        airports.put("Barcelona", false);
        airports.put("Warsaw", true);

        if (flight != null) {
            if (airports.containsKey(flight.getArrivalAirport()) || airports.containsKey(flight.getDepartureAirport())) {
                System.out.println(airports.get(flight.getArrivalAirport()) ?
                        "Airport " + '\u0022' + flight.getArrivalAirport()  + '\u0022' + " is available for arrival"
                        : "Airport " + '\u0022' + flight.getArrivalAirport()  + '\u0022' + " is available only for departure");
            } else {
                throw new RouteNotFoundException("No available airports found");
            }
        } else {
            throw new RouteNotFoundException("Provided flight object is not valid");
        }
    }
}
