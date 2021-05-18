package com.kodilla.patterns.strategy.stock;

public class CorporateCustomer extends Customer{
    public CorporateCustomer(String name) {
        super(name);
        this.buyPredictor = new BalancedPredictor();
    }
}
