package org.example.designpatterns.protoypeAndRegistry;

public class Main {
    public static void main(String[] args) {
        Student prototype = new Student("TTY","evng","sandeep","DSA");

        Student surya = prototype.clone();
        surya.setName("surya");
        surya.setId(10);
        surya.setEmail("hello@gmail.com");

        System.out.println(surya);
    }
}
