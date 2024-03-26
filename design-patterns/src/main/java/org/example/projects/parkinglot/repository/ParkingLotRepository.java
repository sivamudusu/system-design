package org.example.projects.parkinglot.repository;

import org.example.projects.parkinglot.exception.ParkingLotNotFoundException;
import org.example.projects.parkinglot.exception.TicketNotFoundException;
import org.example.projects.parkinglot.models.ParkingLot;
import org.example.projects.parkinglot.models.Ticket;

import java.util.HashMap;
import java.util.Map;

public class ParkingLotRepository {
    private Map<Integer, ParkingLot> parkingLots;
    private static int idCounter = 0;

    public ParkingLotRepository() {
        this.parkingLots = new HashMap<>();
    }

    public ParkingLot getParkingLot(int parkingLotId){
        ParkingLot parkingLot = parkingLots.get(parkingLotId);
        if(parkingLot == null){
            throw new ParkingLotNotFoundException("parkingLot not found for the id"+parkingLotId);
        }
        return parkingLot;
    }
    public void addParkingLot(ParkingLot parkingLot){
        parkingLot.setId(++idCounter);
        parkingLots.put(parkingLot.getId(),parkingLot);
        System.out.println("parking lot hads been added to the db");
    }
}
