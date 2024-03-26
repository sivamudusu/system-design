package org.example.designpatterns.observer;

public class CustomerNotifier implements OrderPlacedSubscriber{
    @Override
    public void orderplacedEvent() {
        System.out.println("send sms to customer ");
        System.out.println("send emial to customer");
    }
}
