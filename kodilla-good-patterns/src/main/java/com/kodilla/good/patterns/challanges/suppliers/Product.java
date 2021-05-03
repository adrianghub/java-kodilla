package com.kodilla.good.patterns.challanges.suppliers;

public class Product {

    private String productName;
    private String productCategory;
    private int quantity;

    public Product(String productName, String productCategory, int quantity) {
        this.productName = productName;
        this.productCategory = productCategory;
        this.quantity = quantity;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public int getQuantity() {
        return quantity;
    }
}
