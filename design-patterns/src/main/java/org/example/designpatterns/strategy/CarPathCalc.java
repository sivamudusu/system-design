package org.example.designpatterns.strategy;

public class CarPathCalc implements PathCalculator{

    @Override
    public void findPath(String source, String destination) {
        System.out.println("car pth via "+source+", "+destination);
    }
}
