package org.example.projects.parkinglot.service.strategy.spotAllocationStrategy;

import org.example.projects.parkinglot.exception.ParkingSpotNotFoundForVehicle;
import org.example.projects.parkinglot.models.ParkingFloor;
import org.example.projects.parkinglot.models.ParkingLot;
import org.example.projects.parkinglot.models.ParkingSpot;
import org.example.projects.parkinglot.models.Vehicle;
import org.example.projects.parkinglot.models.enums.ParkingSpotStatus;
import org.example.projects.parkinglot.models.enums.VehicleType;

import java.util.List;

public class linearSpotAllocationStrategy implements SpotAllocationStrategy{

    @Override
    public ParkingSpot spot(ParkingLot parkingLot,Vehicle vehicle) {
        List<ParkingFloor>parkingFloors = parkingLot.getFloors();
        for(ParkingFloor parkingFloor : parkingFloors){
            for(ParkingSpot parkingSpot : parkingFloor.getParkingSpots()){
                if(parkingSpot.getParkingSpotStatus()== ParkingSpotStatus.EMPTY && parkingSpot.getVehicleType()== VehicleType.FOUR_WHEELER){
                    return parkingSpot;
                }
            }
        }
        throw new ParkingSpotNotFoundForVehicle("NO spot foumd for the given type of vehicle");
    }
}
