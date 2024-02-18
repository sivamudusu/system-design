package org.example.executablesAndCallables;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {
    public static void main(String[] args) {
        List<Integer>input = List.of(7,3,4,8,9,10);


        ExecutorService exec = Executors.newCachedThreadPool();
        mrgeSorter mrgeSorter = new mrgeSorter(input,exec);


        try{
            Future<List<Integer>> ansFuture = exec.submit(mrgeSorter);

            List<Integer> ans = ansFuture.get();
            System.out.println(ans);

        }catch (Exception e){
            throw new RuntimeException("some rerror", e);
        }finally {
            exec.shutdown();
        }





    }
}
