package com.kodilla.good.patterns.challanges.suppliers;

public class Product {

    private String productName;
    private String productCategory;
    private double productCost;
    private int productQuantity;

    public Product(String productName, String productCategory, double productCost, int productQuantity) {
        this.productName = productName;
        this.productCategory = productCategory;
        this.productCost = productCost;
        this.productQuantity = productQuantity;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public double getProductCost() {
        return productCost;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    @Override
    public String toString() {
        return  '\n' + productName + " X " +
                productQuantity + ", " +
                productCost + "zł/szt. '\n'";
    }
}
