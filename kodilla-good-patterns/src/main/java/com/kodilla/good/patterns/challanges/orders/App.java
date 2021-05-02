package com.kodilla.good.patterns.challanges.orders;

public class App {

    public static void main(String[] args) {

        OrderRequestRetriever orderRequestRetriever = new OrderRequestRetriever();
        OrderRequest orderRequest = orderRequestRetriever.retrieve();

        OrderManager orderManager = new OrderManager(new SMSService(), new ProductOrderService(), new ProductOrderRepository());
        orderManager.manageOrder(orderRequest);
    }
}
