package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        ArrayCreator array = new ArrayCreator(20);

        ExecutorService exec = Executors.newCachedThreadPool();
        try {
            Future<List<Integer>> listFuture = exec.submit(array);
            List<Integer> list = listFuture.get();
            System.out.println(list);
            print(list);
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            exec.shutdown();
        }

//        doSomething();

    }
    static void print(List<Integer>array){
        for (int i=0;i<array.size();i++){
            System.out.print(array.get(i));
        }
    }
//    static void doSomething(){
//
//        Node root = new Node(5);
//
//        root.left = new Node(6);
//        root.right = new Node(7);
//        root.left.left = new Node(10);
//
//        ExecutorService exec = Executors.newSingleThreadExecutor();
//        Future<Integer> anfuture = exec.submit(new helloworldPrinter(root));
//
//        try{
//             int ans = anfuture.get();
//            System.out.println(ans);
//        }catch (Exception e){
//            e.printStackTrace();
//        }finally {
//            exec.shutdown();
//        }
//    }
}

//steps to create your own threads

// 1 dont think about what thread you want rather think about task that needs to be done in parellel
// for every task that needs to be done in seperate thread you will create a class for it

// class helloworldPrinter{
//    void run(){}

// }

//make this class implements an interface called runnable
//now your compiler will tell you to implement a run method
// in the run method you write code that you want to run in a seperate thread
// at the place where you want to create a thread update the object of the class

// helloworldPrniter hwp = new helloworldPrinter();
//Thread t = new Thread(hwp)
// t.start