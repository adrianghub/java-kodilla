package com.kodilla.good.patterns.challanges.carrental;

import java.time.LocalDateTime;

public interface RentalRepository {

    void createRental(User user, LocalDateTime from, LocalDateTime to);
}
