package org.example.mergesort;

import org.example.mergesort.Quicksort;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
        int[] array = {3, 5, 2, 1, 6, 7, 9, 8};
        ExecutorService executorService = Executors.newCachedThreadPool();
        Quicksort quicksort = new Quicksort(array, 0, array.length - 1, executorService);

        Future<?> future = executorService.submit(quicksort);

        try {
            future.get(); // Wait for the sorting to finish
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

        executorService.shutdown();
    }
}
