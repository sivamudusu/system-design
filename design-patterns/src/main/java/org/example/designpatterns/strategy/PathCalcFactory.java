package org.example.designpatterns.strategy;

public class PathCalcFactory {

    public static PathCalculator getpathCalculator(Mode mode){
        return switch (mode){
            case CAR -> new CarPathCalc();
            case BIKE -> new BikePathCalc();
            case WALK -> new WalkPathCalc();
            default -> null;
        };
    }
}
