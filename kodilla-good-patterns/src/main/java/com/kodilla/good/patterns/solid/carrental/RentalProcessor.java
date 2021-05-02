package com.kodilla.good.patterns.solid.carrental;

import java.time.LocalDateTime;

public class RentalProcessor {
    private InformationService informationService;
    private RentalService rentalService;
    private RentalRepository rentalRepository;


    public RentalProcessor(final InformationService informationService, final RentalService rentalService, final RentalRepository rentalRepository) {
        this.informationService = informationService;
        this.rentalService = rentalService;
        this.rentalRepository = rentalRepository;
    }

    public RentalDto process(final RentRequest rentRequest) {
        boolean isRented = rentalService.rent(rentRequest.getUser(), rentRequest.getFrom(), rentRequest.getTo());

        if(isRented) {
            informationService.inform(rentRequest.getUser());
            rentalRepository.createRental(rentRequest.getUser(), rentRequest.getFrom(), rentRequest.getTo());
            System.out.println("Car rent successful!");
            return new RentalDto(rentRequest.getUser(), true);
        } else {
            System.out.println("Car rent has been rejected!");
            return new RentalDto(rentRequest.getUser(), false);
        }
    }
}
