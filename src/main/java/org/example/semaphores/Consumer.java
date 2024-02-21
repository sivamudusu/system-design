package org.example.semaphores;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Consumer implements Runnable{
    private Queue<Shirt> store;
    private String name;

    Semaphore semaconsumer;
    Semaphore semaproducer;


    public Consumer(Queue<Shirt>store,String name,Semaphore semaconsumer,Semaphore semaproducer){

        this.store = store;
        this.name = name;
        this.semaconsumer = semaconsumer;
        this.semaproducer = semaproducer;
    }

    @Override
    public void run() {
        while (true){
            try {
                semaconsumer.acquire();
                System.out.println("current sixe is "+this.store.size() + "removed by consumer" + this.name);
                store.remove();
                semaproducer.release();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }



        }


    }
}
