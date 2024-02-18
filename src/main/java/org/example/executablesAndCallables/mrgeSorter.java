package org.example.executablesAndCallables;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class mrgeSorter implements Callable<List<Integer>> {
    List<Integer> arrayTosort;
    ExecutorService exec;
    public mrgeSorter(List<Integer> arrayTosort, ExecutorService exec){
        this.arrayTosort = arrayTosort;
        this.exec = exec;

    }

    public List<Integer> call() throws Exception{
        if(arrayTosort.size() <= 1){
            return arrayTosort;
        }

        int mid = arrayTosort.size() / 2;
        List<Integer>leftArray = new ArrayList<>();
        List<Integer>rightArray = new ArrayList<>();

        for(int i=0;i<mid;i++){
            leftArray.add(arrayTosort.get(i));
        }
        for(int i=mid;i<arrayTosort.size();i++){
            rightArray.add(arrayTosort.get(i));

        }

        mrgeSorter leftsorter = new mrgeSorter(leftArray,exec);
        mrgeSorter rightsorter = new mrgeSorter(rightArray,exec);


        Future<List<Integer>>leftfuture = exec.submit(leftsorter);
        Future<List<Integer>>rightfuture = exec.submit(rightsorter);

        List<Integer>leftsorted = leftfuture.get();
        List<Integer>rightsorted = rightfuture.get();

        int i =0;
        int j =0;
        List<Integer>sorted = new ArrayList<>();

        while (i < leftsorted.size() && j < rightsorted.size()){
            if(leftsorted.get(i) < rightsorted.get(j)){
                sorted.add(leftsorted.get(i));
                i++;
            }else{
                sorted.add(rightsorted.get(j));
                j++;
            }
        }
        while (i < leftsorted.size()){
            sorted.add(leftsorted.get(i));
            i++;
        }
        while( j < rightsorted.size()){
            sorted.add(rightsorted.get(j));
            j++;
        }

        return sorted;

    }
}
