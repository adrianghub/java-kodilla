package com.kodilla.good.patterns.challanges.flights;

import java.time.LocalDateTime;

public class App {

    // Iterate through flights using Stream
    // Use Equals & Hashcode contract

    public static void main(String[] args) {
        Flight flight = new Flight(
                "Warsaw",
                "Mallorca",
                LocalDateTime.of(2017, 1, 12, 10, 50),
                LocalDateTime.of(2017, 1, 12, 14, 20)
        );

    }
}
