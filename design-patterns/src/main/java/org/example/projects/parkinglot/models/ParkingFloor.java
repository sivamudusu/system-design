package org.example.projects.parkinglot.models;

import org.example.projects.parkinglot.models.enums.ParkingFloorStatus;

import java.util.List;

public class ParkingFloor extends BaseModel{

    private int flooeNumber;
    private List<ParkingSpot> parkingSpots;
    private Gate entryGate;
    private  Gate exitGate;

    private ParkingFloorStatus parkingFloorStatus;


    public ParkingFloor(int flooeNumber, List<ParkingSpot> parkingSpots, Gate entryGate, Gate exitGate, ParkingFloorStatus parkingFloorStatus) {
        this.flooeNumber = flooeNumber;
        this.parkingSpots = parkingSpots;
        this.entryGate = entryGate;
        this.exitGate = exitGate;
        this.parkingFloorStatus = parkingFloorStatus;
    }
    public ParkingFloor(){

    }

    public int getFlooeNumber() {
        return flooeNumber;
    }

    public void setFlooeNumber(int flooeNumber) {
        this.flooeNumber = flooeNumber;
    }

    public List<ParkingSpot> getParkingSpots() {
        return parkingSpots;
    }

    public void setParkingSpots(List<ParkingSpot> parkingSpots) {
        this.parkingSpots = parkingSpots;
    }

    public Gate getEntryGate() {
        return entryGate;
    }

    public void setEntryGate(Gate entryGate) {
        this.entryGate = entryGate;
    }

    public Gate getExitGate() {
        return exitGate;
    }

    public void setExitGate(Gate exitGate) {
        this.exitGate = exitGate;
    }

    public ParkingFloorStatus getParkingFloorStatus() {
        return parkingFloorStatus;
    }

    public void setParkingFloorStatus(ParkingFloorStatus parkingFloorStatus) {
        this.parkingFloorStatus = parkingFloorStatus;
    }
}
