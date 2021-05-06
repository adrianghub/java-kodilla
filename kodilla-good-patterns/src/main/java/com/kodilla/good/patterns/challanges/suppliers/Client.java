package com.kodilla.good.patterns.challanges.suppliers;

public class Client {

    private String firstName;
    private String lastName;
    private String nickname;
    private String eMail;

    public Client(String firstName, String lastName, String nickname, String eMail) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nickname = nickname;
        this.eMail = eMail;
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

    public String getEMail() {
        return eMail;
    }

}
