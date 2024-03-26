package org.example.projects.parkinglot.repository;

import org.example.projects.parkinglot.exception.parkingFloorNotFoundException;
import org.example.projects.parkinglot.models.ParkingFloor;

import java.util.HashMap;
import java.util.Map;

public class ParkingFloorRepository {
    private Map<Integer, ParkingFloor> parkingFloorMap;

    public ParkingFloorRepository() {
        this.parkingFloorMap = new HashMap<>();
    }

    public ParkingFloor getParkingFloor(int parkingFloorId){
        ParkingFloor parkingFloor = parkingFloorMap.get(parkingFloorId);
        if(parkingFloor == null){
            throw new parkingFloorNotFoundException("ParkingFloor not found for Id:"+parkingFloorId );
        }
        return parkingFloor;
    }
    public void addParkingFloor(ParkingFloor parkingFloor){
        parkingFloorMap.put(parkingFloor.getId(), parkingFloor);
        System.out.println("floor has been added to db successfully");
    }
}
