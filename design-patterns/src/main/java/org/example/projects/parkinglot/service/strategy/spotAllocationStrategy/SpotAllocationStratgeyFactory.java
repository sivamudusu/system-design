package org.example.projects.parkinglot.service.strategy.spotAllocationStrategy;

public class SpotAllocationStratgeyFactory {
//    TODO:add spot allocation startegy with Enums
    public static SpotAllocationStrategy getSpotAllocationStrategy(){
        return new linearSpotAllocationStrategy();
    }
}
