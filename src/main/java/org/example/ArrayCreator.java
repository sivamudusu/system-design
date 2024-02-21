package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class ArrayCreator implements Callable<List<Integer>> {
    private int high;
    ArrayList<Integer> list = new ArrayList<>();

    public ArrayCreator(int high){
        this.high = high;
    }

    @Override
    public List<Integer> call() throws Exception {
        for(int i=1;i<=high;i++){
            list.add(i);
        }
        return list;
    }
}
