package com.kodilla.good.patterns.challanges.orders;

public class User {

    private String firstName;
    private String lastName;
    private String nickname;
    private int phoneNumber;

    public User(String firstName, String lastName, String nickname, int phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nickname = nickname;
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getNickname() {
        return nickname;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }
}
