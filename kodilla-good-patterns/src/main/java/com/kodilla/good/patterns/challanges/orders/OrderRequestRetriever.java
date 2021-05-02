package com.kodilla.good.patterns.challanges.orders;

import java.time.LocalDateTime;

public class OrderRequestRetriever {

    public OrderRequest retrieve() {
        User user = new User("Krzysztof", "Krawczyk", "krzykra1", 525622323);

        String productName = "Gitara basowa VOLTAGE";
        LocalDateTime orderDate = LocalDateTime.of(2021, 5, 1, 7, 55);

        int orderCost = 3000;
        Enum<PaymentMethod> paymentMethod = PaymentMethod.BLIK;
        DeliveryLocation deliveryLocation = new DeliveryLocation("Kozłowska 4/13", 74200, "Białystok");

        OrderDetails orderDetails = new OrderDetails(productName, orderCost, orderDate, paymentMethod, deliveryLocation);

        return new OrderRequest(user, orderDetails);
    }
}