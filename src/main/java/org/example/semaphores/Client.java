package org.example.semaphores;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.Semaphore;

public class Client {
    public static void main(String[] args) {
        Queue<Shirt> store = new ConcurrentLinkedDeque<>();
        int max = 5;

        Semaphore semaproducer = new Semaphore(max);
        Semaphore semaConsumer = new Semaphore(0);


        Producer p1 = new Producer(store,"p1",max,semaConsumer,semaproducer);
        Producer p2 = new Producer(store,"p2",max,semaConsumer,semaproducer);
        Producer p3 = new Producer(store,"p3",max,semaConsumer,semaproducer);
        Producer p4 = new Producer(store,"p4",max,semaConsumer,semaproducer);
        Producer p5 = new Producer(store,"p5",max,semaConsumer,semaproducer);

        Consumer c1 = new Consumer(store,"c1",semaConsumer,semaproducer);
        Consumer c2 = new Consumer(store,"c2",semaConsumer,semaproducer);
        Consumer c3 = new Consumer(store,"c3",semaConsumer,semaproducer);
        Consumer c4 = new Consumer(store,"c4",semaConsumer,semaproducer);
        Consumer c5 = new Consumer(store,"c5",semaConsumer,semaproducer);

        Thread t1 = new Thread(p1);
        t1.start();
        Thread t2 = new Thread(p2);
        t2.start();
        Thread t3 = new Thread(p3);
        t3.start();
        Thread t4 = new Thread(p4);
        t4.start();
        Thread t5 = new Thread(p5);
        t5.start();

        Thread tc1 = new Thread(c1);
        tc1.start();
        Thread tc2 = new Thread(c2);
        tc2.start();
        Thread tc3 = new Thread(c3);
        tc3.start();
        Thread tc4 = new Thread(c4);
        tc4.start();
        Thread tc5 = new Thread(c5);
        tc5.start();





    }
}
