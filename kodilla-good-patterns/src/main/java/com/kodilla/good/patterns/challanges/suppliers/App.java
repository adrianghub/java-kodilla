package com.kodilla.good.patterns.challanges.suppliers;

public class App {
    public static void main(String[] args) {
        SupplierRequestRetriever supplierRequestRetriever = new SupplierRequestRetriever();
        SupplierRequest supplierRequest = supplierRequestRetriever.retrieve();

        Supplier supplier = new Supplier(new EmailConfirmationService(), new ExtraFoodShopSupplierService(), new ExtraFoodShopSupplierRepository());
        supplier.process(supplierRequest);
    }
}
