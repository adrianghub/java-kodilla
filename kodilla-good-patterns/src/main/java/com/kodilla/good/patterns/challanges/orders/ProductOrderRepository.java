package com.kodilla.good.patterns.challanges.orders;

import java.time.LocalDateTime;

public class ProductOrderRepository implements OrderRepository {
    @Override
    public void createOrder(User user, OrderDetails orderDetails) {
        System.out.println("Order for " + user.getNickname() + " successfully created.");
    }
}
