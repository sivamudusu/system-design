package org.example.projects.parkinglot.repository;

import org.example.projects.parkinglot.exception.ParkingSpotNotFoundException;
import org.example.projects.parkinglot.exception.TicketNotFoundException;
import org.example.projects.parkinglot.models.ParkingSpot;
import org.example.projects.parkinglot.models.Ticket;

import java.util.HashMap;
import java.util.Map;

public class ParkingSpotRepository {
    private Map<Integer, ParkingSpot> parkingSpotMap;

    public ParkingSpotRepository() {
        this.parkingSpotMap = new HashMap<>();
    }

    public ParkingSpot getSpot(int spotId){
        ParkingSpot parkingSpot = parkingSpotMap.get(spotId);
        if(parkingSpot == null){
            throw new ParkingSpotNotFoundException("spot not found for Id:"+spotId );
        }
        return parkingSpot;
    }
    public void addSpot(ParkingSpot parkingSpot){
        parkingSpotMap.put(parkingSpot.getId(), parkingSpot);
        System.out.println("spot has been added to db successfully");
    }
}
