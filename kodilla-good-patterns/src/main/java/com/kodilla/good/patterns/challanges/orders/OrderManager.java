package com.kodilla.good.patterns.challanges.orders;

public class OrderManager {

    private InfoService infoService;
    private OrderService orderService;
    private OrderRepository orderRepository;

    public OrderManager(final InfoService infoService, final OrderService orderService, final OrderRepository orderRepository) {
        this.infoService = infoService;
        this.orderService = orderService;
        this.orderRepository = orderRepository;
    }

    public OrderDto manageOrder (final OrderRequest orderRequest) {
        boolean isOrdered = orderService.takeOrder(orderRequest.getUser(), orderRequest.getOrderDetails());

        if (isOrdered) {
            infoService.inform(orderRequest.getUser());
            orderRepository.createOrder(orderRequest.getUser(), orderRequest.getOrderDetails());
            return new OrderDto(orderRequest.getUser(), true);
        } else {
            return new OrderDto(orderRequest.getUser(), false);
        }
    }
}
