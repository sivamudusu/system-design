package org.example.semaphores;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Producer implements Runnable{
    private Queue<Shirt> store;
    private String name;
    private int maxSize;
    Semaphore semaproducer;
    Semaphore semaconsumer;

    public Producer(Queue<Shirt>store,String name,int maxSize,Semaphore semaconsumer, Semaphore semaproducer){
        this.store = store;
        this.name = name;
        this.maxSize = maxSize;
        this.semaconsumer = semaconsumer;
        this.semaproducer = semaproducer;
    }

    @Override
    public void run() {
        while (true){
            try {
                semaproducer.acquire();
                System.out.println("current sixe is "+this.store.size() + "added by producer" + this.name);
                store.add(new Shirt());
                semaconsumer.release();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }

    }

}
