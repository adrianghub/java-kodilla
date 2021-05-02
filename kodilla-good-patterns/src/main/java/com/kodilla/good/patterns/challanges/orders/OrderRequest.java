package com.kodilla.good.patterns.challanges.orders;

public class OrderRequest {

    private User user;
    private OrderDetails orderDetails;

    public OrderRequest(final User user, final OrderDetails orderDetails) {
        this.user = user;
        this.orderDetails = orderDetails;
    }

    public User getUser() {
        return user;
    }

    public OrderDetails getOrderDetails() {
        return orderDetails;
    }
}