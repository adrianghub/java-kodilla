package com.kodilla.good.patterns.challanges.suppliers;

public interface SupplierRepository {
    void sendOrder(Client client, OrderDetails orderDetails);
}
