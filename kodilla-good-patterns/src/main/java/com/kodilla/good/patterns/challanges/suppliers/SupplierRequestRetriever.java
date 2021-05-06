package com.kodilla.good.patterns.challanges.suppliers;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SupplierRequestRetriever {

    public SupplierRequest retrieve() {
        Client client = new Client("Krzysztof", "Krawczyk", "krzykra1", "hungermaster@mail.co");

        Product pizza = new Product("Pizza Hawajska 30cm", "fast-food", 12.50, 1);
        Product dips = new Product("Sos pomidorowy Tabasco", "dip", 2.50, 3);
        Product drinks = new Product("Coca cola Pola", "beverage", 7.50, 4);

        List<Product> order =  new ArrayList<>();
        order.add(pizza);
        order.add(dips);
        order.add(drinks);

        String clientSpecialWish = "Pizza ciepła, nie jak ostatnio...";

        LocalDateTime orderDate = LocalDateTime.of(2021, 5, 1, 7, 55);

        Enum<PaymentMethod> paymentMethod = PaymentMethod.BLIK;
        ClientAddress clientAddress = new ClientAddress("Kozłowska 4/13", 74200, "Białystok");

        String brandName = "Extra Food Shop";

        OrderDetails orderDetails = new OrderDetails(order, orderDate, paymentMethod, clientAddress, clientSpecialWish, brandName);

        return new SupplierRequest(client, orderDetails);
    }
}
