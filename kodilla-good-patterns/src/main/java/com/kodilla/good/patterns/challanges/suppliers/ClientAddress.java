package com.kodilla.good.patterns.challanges.suppliers;

public class ClientAddress implements AddressDetails {

    private String street;
    private int postCode;
    private String city;

    public ClientAddress(String street, int postCode, String city) {
        this.street = street;
        this.postCode = postCode;
        this.city = city;
    }

    @Override
    public String getStreet() {
        return street;
    }

    @Override
    public int getPostCode() {
        return postCode;
    }

    @Override
    public String getCity() {
        return city;
    }
}
