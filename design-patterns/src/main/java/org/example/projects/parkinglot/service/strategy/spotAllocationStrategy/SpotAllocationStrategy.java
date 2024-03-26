package org.example.projects.parkinglot.service.strategy.spotAllocationStrategy;

import org.example.projects.parkinglot.models.ParkingLot;
import org.example.projects.parkinglot.models.ParkingSpot;
import org.example.projects.parkinglot.models.Vehicle;

public interface SpotAllocationStrategy {
    ParkingSpot spot(ParkingLot parkingLot,Vehicle vehicle);
}
