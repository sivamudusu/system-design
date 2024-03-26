package org.example.designpatterns.builder;

public class Main {
    public static void main(String[] args) {
        Student stu = Student.builder()
                .setAge(20)
                .setBirthyear(1995)
                .setCollege("hello world")
                .setId(1)
                .setName("shiva")
                .setPassedout(2022)
                .build();

        System.out.println(stu.toString());



    }
}
