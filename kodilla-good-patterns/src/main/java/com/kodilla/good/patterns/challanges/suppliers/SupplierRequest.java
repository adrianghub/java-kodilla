package com.kodilla.good.patterns.challanges.suppliers;


public class SupplierRequest {

    private Client client;
    private OrderDetails orderDetails;

    public SupplierRequest(final Client client, OrderDetails orderDetails) {
        this.client = client;
        this.orderDetails = orderDetails;
    }

    public Client getUser() {
        return client;
    }

    public OrderDetails getOrderDetails() {
        return orderDetails;
    }
}
