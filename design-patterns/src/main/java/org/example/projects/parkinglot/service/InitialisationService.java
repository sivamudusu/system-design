package org.example.projects.parkinglot.service;

import org.example.projects.parkinglot.models.Gate;
import org.example.projects.parkinglot.models.ParkingFloor;
import org.example.projects.parkinglot.models.ParkingLot;
import org.example.projects.parkinglot.models.ParkingSpot;
import org.example.projects.parkinglot.models.enums.*;
import org.example.projects.parkinglot.repository.GateRepository;
import org.example.projects.parkinglot.repository.ParkingFloorRepository;
import org.example.projects.parkinglot.repository.ParkingLotRepository;
import org.example.projects.parkinglot.repository.ParkingSpotRepository;

import java.util.ArrayList;
import java.util.List;

public class InitialisationService {
    private ParkingLotRepository parkingLotRepository;
    private ParkingSpotRepository parkingSpotRepository;
    private ParkingFloorRepository parkingFloorRepository;
    private GateRepository gateRepository;

    public InitialisationService(ParkingLotRepository parkingLotRepository, ParkingSpotRepository parkingSpotRepository, ParkingFloorRepository parkingFloorRepository, GateRepository gateRepository) {
        this.parkingLotRepository = parkingLotRepository;
        this.parkingSpotRepository = parkingSpotRepository;
        this.parkingFloorRepository = parkingFloorRepository;
        this.gateRepository = gateRepository;
    }

    public ParkingLot init(){
        System.out.println("starting initialisation***");
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setName("developers parking lot centre");
        parkingLot.setAddress("somewhere inside a costly malll");
        parkingLot.setCapacity(100);
        parkingLot.setVehicleTypesSupported(List.of(VehicleType.EV,VehicleType.TWO_WHEELER,VehicleType.FOUR_WHEELER,VehicleType.LUX));
        List<ParkingFloor> floors = new ArrayList<>();

        for(int i=1;i<=10;i++){
            ParkingFloor parkingFloor = new ParkingFloor();
            parkingFloor.setId(i);
            parkingFloor.setFlooeNumber(i);
            parkingFloor.setParkingFloorStatus(ParkingFloorStatus.AVAILABLE);
            List<ParkingSpot> spots = new ArrayList<>();
            for(int j=1;j<=10;j++){
                ParkingSpot parkingSpot = new ParkingSpot();
                parkingSpot.setId(j);
                parkingSpot.setNumber(i*100+j);
                parkingSpot.setParkingSpotStatus(ParkingSpotStatus.EMPTY);
                parkingSpot.setVehicleType(VehicleType.FOUR_WHEELER);
                spots.add(parkingSpot);
                parkingSpotRepository.addSpot(parkingSpot);

            }
            parkingFloor.setParkingSpots(spots);
            Gate entryGate = new Gate();
            entryGate.setId(i*1000+1);
            entryGate.setGateNumber(i*100+1);
            entryGate.setGateType(GateType.ENTRY);
            entryGate.setGateStatus(GateStatus.OPEN);
            entryGate.setOperatorName("operator "+i+1);
            parkingFloor.setEntryGate(entryGate);
            gateRepository.addGate(entryGate);

            Gate exitGate = new Gate();
            exitGate.setId(i*1000+2);
            exitGate.setGateNumber(i*100+2);
            exitGate.setGateType(GateType.EXIT);
            exitGate.setGateStatus(GateStatus.OPEN);
            exitGate.setOperatorName("operator "+i+2);
            parkingFloor.setExitGate(exitGate);
            gateRepository.addGate(exitGate);


            floors.add(parkingFloor);
            parkingFloorRepository.addParkingFloor(parkingFloor);

        }
        parkingLot.setFloors(floors);
        parkingLotRepository.addParkingLot(parkingLot);

        return  parkingLotRepository.getParkingLot(1);
    }
}
