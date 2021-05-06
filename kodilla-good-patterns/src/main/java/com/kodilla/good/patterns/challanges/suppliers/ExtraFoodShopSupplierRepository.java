package com.kodilla.good.patterns.challanges.suppliers;

public class ExtraFoodShopSupplierRepository implements SupplierRepository {
        @Override
        public void sendOrder(Client client, OrderDetails orderDetails) {
            System.out.println("Order for " + client.getNickname() + "has been sent successfully by" + orderDetails.getBrandName() + ".");
        }
}
