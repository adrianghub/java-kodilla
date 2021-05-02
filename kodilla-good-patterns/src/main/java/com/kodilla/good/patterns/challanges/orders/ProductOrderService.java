package com.kodilla.good.patterns.challanges.orders;

public class ProductOrderService implements OrderService{

    @Override
    public boolean takeOrder(User user, OrderDetails orderDetails) {

        System.out.println("Order details:\n" +
                        "Client: " + user.getFirstName() + " " + user.getLastName() +  " /" + user.getNickname() + "/ \n" +
                        "Order date: " + orderDetails.getOrderDate() + "\n" +
                        "Product: " + orderDetails.getProductName() + "\n" +
                        "Cost: " + orderDetails.getOrderCost() + "zł \n" +
                        "Payment method: " + orderDetails.getPaymentMethod() + "\n" +
                        "Address: " + orderDetails.getDeliveryLocation()
        );

        return true;
    }
}
