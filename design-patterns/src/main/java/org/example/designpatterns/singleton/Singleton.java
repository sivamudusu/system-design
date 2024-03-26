package org.example.designpatterns.singleton;

public class Singleton {
    private static Singleton instance;

    public Singleton(){

    }

    public static Singleton getInstance(){
        if(instance==null){
            instance = new Singleton();
        }
        return instance;
    }

}
