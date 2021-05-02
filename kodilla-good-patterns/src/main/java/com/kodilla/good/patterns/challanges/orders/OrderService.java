package com.kodilla.good.patterns.challanges.orders;

import java.time.LocalDateTime;

public interface OrderService {

    boolean takeOrder(User user, OrderDetails orderDetails);
}
