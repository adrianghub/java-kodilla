package com.kodilla.exception.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FlightSearchExceptionTestSuite {

    @Test
    void testFindFlight() {
        //given
        Flight flight1 = new Flight("Mexico", "Warsaw");
        Flight flight2 = new Flight("Detroit", "Barcelona");
        Flight flight3 = new Flight("Bromberg", "Munich");
        Flight flight4 = null;
        FlightSearch flightSearch = new FlightSearch();

        //when & then
        assertAll(
                () ->  assertThrows(RouteNotFoundException.class, () -> flightSearch.findFlight(flight3)),
                () ->  assertThrows(RouteNotFoundException.class, () -> flightSearch.findFlight(flight4)),
                () -> assertDoesNotThrow(() -> flightSearch.findFlight(flight1)),
                () -> assertDoesNotThrow(() -> flightSearch.findFlight(flight2))
        );
    }
}
