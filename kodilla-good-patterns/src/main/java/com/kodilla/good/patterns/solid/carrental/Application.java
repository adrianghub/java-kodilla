package com.kodilla.good.patterns.solid.carrental;

import java.time.LocalDateTime;

public class Application {

    public static void main(String[] args) {

        RentRequestRetriever rentRequestRetriever = new RentRequestRetriever();
        RentRequest rentRequest = rentRequestRetriever.retrieve();

//        User user = new User("John", "Snow");
//        LocalDateTime rentFrom = LocalDateTime.of(2017, 8, 1, 12, 0);
//        LocalDateTime rentTo = LocalDateTime.of(2017, 8, 10, 12, 0);

        RentalProcessor rentalProcessor = new RentalProcessor(new MailService(), new CarRentalService(), new CarRentalRepository());
        rentalProcessor.process(rentRequest);
    }
}
