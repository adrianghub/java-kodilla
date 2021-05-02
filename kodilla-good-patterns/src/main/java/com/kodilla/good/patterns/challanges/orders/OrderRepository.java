package com.kodilla.good.patterns.challanges.orders;

public interface OrderRepository {
    void createOrder(User user, OrderDetails orderDetails);
}
