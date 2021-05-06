package com.kodilla.good.patterns.challanges.suppliers;

public class SupplyDto {

    public Client client;
    public boolean isOrderAvailable;

    public SupplyDto(Client client, boolean isOrderAvailable) {
        this.client = client;
        this.isOrderAvailable = isOrderAvailable;
    }

    public Client getUser() { return client; }

    public boolean isOrderAvailable() { return isOrderAvailable(); }
}
