package com.kodilla.good.patterns.challanges.orders;

public class SMSService implements InfoService {

    @Override
    public void inform(User user) {
        System.out.println("Information sent to: " + user.getNickname() + ", phone number: " + user.getPhoneNumber());
    }
}
