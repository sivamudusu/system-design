package org.example.synchronisation;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Client {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Count count = new Count();

        Lock lock = new ReentrantLock();

        Adder adder = new Adder(count,lock);
        Subtracter subtracter = new Subtracter(count,lock);

        ExecutorService exec = Executors.newCachedThreadPool();

        Future adder1 = exec.submit(adder);
        Future sub11 = exec.submit(subtracter);

        adder1.get();
        sub11.get();


//         Thread t1 = new Thread(adder);
//         Thread t2 = new Thread(subtracter);
//         t1.start();
//         t2.start();
//
//         t1.join();
//         t2.join();

//        System.out.println(count.value);

        System.out.println(count.value);
    }
}
