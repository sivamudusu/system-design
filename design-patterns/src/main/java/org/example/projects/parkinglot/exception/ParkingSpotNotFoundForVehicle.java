package org.example.projects.parkinglot.exception;

public class ParkingSpotNotFoundForVehicle extends RuntimeException{
    public ParkingSpotNotFoundForVehicle() {
    }

    public ParkingSpotNotFoundForVehicle(String message) {
        super(message);
    }
}
