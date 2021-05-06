package com.kodilla.good.patterns.challanges.suppliers;

public class ExtraFoodShopSupplierService implements SupplierService {
    @Override
    public boolean collectOrder(Client client, OrderDetails orderDetails) {
        System.out.println("Order details:\n" +
                "Client: " + client.getFirstName() + " " + client.getLastName() +  " /" + client.getNickname() + "/ \n" +
                "Order date: " + orderDetails.getOrderDate() + "\n" +
                "Products: " + orderDetails.getAllProducts() + "\n" +
                "Cost: " + orderDetails.getOrderCost() + "zł \n" +
                "Payment method: " + orderDetails.getPaymentMethod() + "\n" +
                "Address: " + orderDetails.getClientAddressDetails()
        );

        return true;
    }
}