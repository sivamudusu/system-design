package org.example.designpatterns.observer;

public class Main {
    public static void main(String[] args) {
        CustomerNotifier customerNotifier = new CustomerNotifier();
        InvoiceNotifier invoiceNotifier = new InvoiceNotifier();

        Amazon amazon = new Amazon();
        amazon.addOrderplacedSubscriber(customerNotifier);
        amazon.addOrderplacedSubscriber(invoiceNotifier);

        amazon.orderPlaced();

        amazon.removeOrderPlacedSubscriber(invoiceNotifier);
        amazon.orderPlaced();
    }

}