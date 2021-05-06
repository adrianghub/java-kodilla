package com.kodilla.good.patterns.challanges.suppliers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class OrderDetails {
    private final List<Product> products;
    LocalDateTime orderDate;
    private final ClientAddress clientAddress;
    private final Enum<PaymentMethod> paymentMethod;
    private final String clientSpecialWish;
    private final String brandName;

    public OrderDetails(
            List<Product> products,
            LocalDateTime orderDate,
            Enum<PaymentMethod> paymentMethod,
            ClientAddress clientAddress,
            String clientSpecialWish,
            String brandName
    ) {
        this.products = products;
        this.orderDate = orderDate;
        this.paymentMethod = paymentMethod;
        this.clientAddress = clientAddress;
        this.clientSpecialWish = clientSpecialWish;
        this.brandName = brandName;
    }

    public List<Product> getAllProducts() {

        return products;
    }

    public double getOrderCost() {
        double total = 0;

        for (Product product: products) {
            total += product.getProductCost() * product.getProductQuantity();
        }

        return total;
    }

    public String getOrderDate() {

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        return orderDate.format(dateFormatter);
    }

    public String getClientAddressDetails() {
        return  "Street: " + clientAddress.getStreet() + " " +
                "Post code: " + clientAddress.getPostCode() + " " +
                "City: " + clientAddress.getCity();
    }

    public Enum<PaymentMethod> getPaymentMethod() {
        return paymentMethod;
    }

    public String getClientSpecialWish() {
        return clientSpecialWish;
    }

    public String getBrandName() {
        return brandName;
    }
}
