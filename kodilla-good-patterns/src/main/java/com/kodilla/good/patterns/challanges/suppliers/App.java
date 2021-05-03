package com.kodilla.good.patterns.challanges.suppliers;


public class App {
    public static void main(String[] args) {
        SupplierRequestRetriever supplierRequestRetriever = new SupplierRequestRetriever();
        SupplierRequest supplierRequest = supplierRequestRetriever.retrieve();
    }
}
