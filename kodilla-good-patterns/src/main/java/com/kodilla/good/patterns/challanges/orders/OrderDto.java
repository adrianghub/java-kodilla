package com.kodilla.good.patterns.challanges.orders;

public class OrderDto {

    public User user;
    public boolean isOrdered;

    public OrderDto(User user, final boolean isOrdered) {
        this.user = user;
        this.isOrdered = isOrdered;
    }

    public User getUser() { return user; }

    public boolean isOrdered() { return isOrdered; }
}
