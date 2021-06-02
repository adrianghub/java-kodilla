package com.kodilla.good.patterns.challanges.flights;

import java.time.LocalDateTime;
import java.util.Objects;

public class Flight {

    private String arrivalCity;
    private String destinationCity;
    private String flightThroughCity;
    private LocalDateTime departureTime;
    private LocalDateTime destinationTime;

    public Flight(String arrivalCity, String destinationCity, LocalDateTime departureTime, LocalDateTime destinationTime) {
        this.arrivalCity = arrivalCity;
        this.destinationCity = destinationCity;
        this.departureTime = departureTime;
        this.destinationTime = destinationTime;
    }

    public Flight(String arrivalCity, String destinationCity, LocalDateTime departureTime, LocalDateTime destinationTime, String flightThroughCity) {
        this.arrivalCity = arrivalCity;
        this.destinationCity = destinationCity;
        this.departureTime = departureTime;
        this.destinationTime = destinationTime;
        this.flightThroughCity = flightThroughCity;
    }

    public String getArrivalCity() {
        return arrivalCity;
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    public String getFlightThroughCity() {

        return Objects.requireNonNullElse(flightThroughCity, "Direct flight.");
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public LocalDateTime getDestinationTime() {
        return destinationTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Flight)) return false;
        Flight flight = (Flight) o;
        return Objects.equals(arrivalCity, flight.arrivalCity) && Objects.equals(destinationCity, flight.destinationCity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(arrivalCity, destinationCity);
    }
}
