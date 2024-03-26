package org.example.designpatterns.strategy;
//path calcs should be singleton because they don't have any other usecases
public class BikePathCalc implements PathCalculator{
    @Override
    public void findPath(String source, String destination) {
        System.out.println("Bike path via "+source + ","+destination);
    }
}
