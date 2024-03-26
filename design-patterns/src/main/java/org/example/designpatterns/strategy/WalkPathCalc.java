package org.example.designpatterns.strategy;

public class WalkPathCalc implements PathCalculator{
    @Override
    public void findPath(String source, String destination) {
        System.out.println("walk path via "+source+", "+destination);
    }
}
