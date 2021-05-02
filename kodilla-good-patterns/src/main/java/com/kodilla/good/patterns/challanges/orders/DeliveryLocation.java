package com.kodilla.good.patterns.challanges.orders;

public class DeliveryLocation {

    private String street;
    private int postCode;
    private String city;

    public DeliveryLocation(String street, int postCode, String city) {
        this.street = street;
        this.postCode = postCode;
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public int getPostCode() {
        return postCode;
    }

    public String getCity() {
        return city;
    }
}
