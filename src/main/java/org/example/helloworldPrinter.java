package org.example;


import java.util.concurrent.*;

public class helloworldPrinter implements Callable<Integer> {
    Node root;

    public helloworldPrinter(Node root){
        this.root = root;
    }

    public Integer call() throws Exception{
        return calculate(root);
    }

    public int calculate(Node tree){
        if (tree == null)return 0;

        ExecutorService exec = Executors.newFixedThreadPool(2);

        try{

            Future<Integer> left = exec.submit(new helloworldPrinter(tree.left));
            Future<Integer> right = exec.submit(new helloworldPrinter(tree.right));

            int leftTotal = left.get();
            int rightTotal = right.get();
            return 1 + leftTotal + rightTotal;


        }catch (Exception e){
            throw new RuntimeException("Error calaculating" ,e);
        }finally {
            exec.shutdown();
        }
    }
}
