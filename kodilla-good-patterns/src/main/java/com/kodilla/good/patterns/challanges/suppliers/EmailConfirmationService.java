package com.kodilla.good.patterns.challanges.suppliers;

public class EmailConfirmationService implements InformationService {

    @Override
    public void sendConfirmationToClient(Client client) {
        System.out.println("Information sent to: " + client.getNickname() + ", e-mail: " + client.getEMail());
    }
}
