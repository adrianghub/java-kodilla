package com.kodilla.good.patterns.challanges.orders;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class OrderDetails {

    private String productName;
    private int orderCost;
    LocalDateTime orderDate;
    private DeliveryLocation deliveryLocation;
    private Enum<PaymentMethod> paymentMethod;

    public OrderDetails(String productName, int orderCost, LocalDateTime orderDate, Enum<PaymentMethod> paymentMethod, DeliveryLocation deliveryLocation) {
        this.productName = productName;
        this.orderCost = orderCost;
        this.orderDate = orderDate;
        this.paymentMethod = paymentMethod;
        this.deliveryLocation = deliveryLocation;
    }

    public String getProductName() {
        return productName;
    }

    public int getOrderCost() {
        return orderCost;
    }

    public String getOrderDate() {

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        return orderDate.format(dateFormatter);
    }

    public String getDeliveryLocation() {
        return  "Street: " + deliveryLocation.getStreet() + " " +
                "Post code: " + deliveryLocation.getPostCode() + " " +
                "City: " + deliveryLocation.getCity();
    }

    public Enum<PaymentMethod> getPaymentMethod() {
        return paymentMethod;
    }
}
