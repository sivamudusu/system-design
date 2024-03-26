package org.example.designpatterns.decorator;

public class Main {
    public static void main(String[] args) {
        Icecream icecream =  new ChocoChip(new ChocoScoop(new OrangeCone(new ChocoSyrup(new ChocoCone()))));


        System.out.println(icecream.getCost());
        System.out.println(icecream.getDescription());
    }
}
