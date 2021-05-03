package com.kodilla.good.patterns.challanges.suppliers;

public class Supplier implements SupplierProcessor {

    private String brandName;

    public Supplier(String brandName) {
        this.brandName = brandName;
    }

    public String getBrandName() {
        return brandName;
    }

    @Override
    public void process() {
        // if productIsAvailable
        // collectOrder()
        // sentConfirmationToClient()
        // sentOrder()
    }
}
