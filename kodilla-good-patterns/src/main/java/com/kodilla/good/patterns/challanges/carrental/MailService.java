package com.kodilla.good.patterns.challanges.carrental;

public class MailService implements InformationService {
    @Override
    public void inform(User user) {
        System.out.println("Mail sent successfully");
    }
}
