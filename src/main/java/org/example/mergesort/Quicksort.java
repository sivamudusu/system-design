package org.example.mergesort;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class Quicksort implements Runnable {
    private int[] array;
    private int low;
    private int high;
    private ExecutorService executorService;

    public Quicksort(int[] array, int low, int high, ExecutorService executorService) {
        this.array = array;
        this.low = low;
        this.high = high;
        this.executorService = executorService;
    }

    @Override
    public void run() {
        if (low < high) {
            int partitionIndex = partition(array, low, high);
            Quicksort left = new Quicksort(array, low, partitionIndex - 1, executorService);
            Quicksort right = new Quicksort(array, partitionIndex + 1, high, executorService);

            Future<?> leftFuture = executorService.submit(left);
            Future<?> rightFuture = executorService.submit(right);

            try {
                leftFuture.get();
                rightFuture.get();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    private int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;
                swap(array, i, j);
            }
        }

        swap(array, i + 1, high);
        return i + 1;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
