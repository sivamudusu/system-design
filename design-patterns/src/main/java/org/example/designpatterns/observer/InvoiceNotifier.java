package org.example.designpatterns.observer;

public class InvoiceNotifier implements OrderPlacedSubscriber{
    @Override
    public void orderplacedEvent() {
        System.out.println("send invoice");
    }
}
