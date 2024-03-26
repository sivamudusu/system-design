package org.example.designpatterns.observer;

import java.util.ArrayList;
import java.util.List;

public class Amazon {
    private List<OrderPlacedSubscriber>orderPlacedSubscribers;

    public Amazon() {
        this.orderPlacedSubscribers = new ArrayList<>();
    }
    public void orderPlaced(){
        for(OrderPlacedSubscriber o : orderPlacedSubscribers){
            o.orderplacedEvent();
        }
    }
    public void addOrderplacedSubscriber(OrderPlacedSubscriber orderPlacedSubscriber){
        orderPlacedSubscribers.add(orderPlacedSubscriber);
    }

    public void removeOrderPlacedSubscriber(OrderPlacedSubscriber orderPlacedSubscriber){
        orderPlacedSubscribers.remove(orderPlacedSubscriber);
    }
}
