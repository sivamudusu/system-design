package org.example.projects.parkinglot.service;

import org.example.projects.parkinglot.models.ParkingLot;
import org.example.projects.parkinglot.models.ParkingSpot;
import org.example.projects.parkinglot.models.Ticket;
import org.example.projects.parkinglot.models.Vehicle;
import org.example.projects.parkinglot.models.enums.ParkingSpotStatus;
import org.example.projects.parkinglot.repository.GateRepository;
import org.example.projects.parkinglot.repository.ParkingLotRepository;
import org.example.projects.parkinglot.repository.ParkingSpotRepository;
import org.example.projects.parkinglot.repository.TicketRepository;
import org.example.projects.parkinglot.service.strategy.spotAllocationStrategy.SpotAllocationStrategy;
import org.example.projects.parkinglot.service.strategy.spotAllocationStrategy.SpotAllocationStratgeyFactory;

import java.time.LocalDateTime;

public class TicketService {
    private TicketRepository ticketRepository;
    private ParkingLotRepository parkingLotRepository;
    private GateRepository gateRepository;
    private ParkingSpotRepository parkingSpotRepository;

    public TicketService(TicketRepository ticketRepository, ParkingLotRepository parkingLotRepository,GateRepository gateRepository,ParkingSpotRepository parkingSpotRepository) {
        this.ticketRepository = ticketRepository;
        this.parkingLotRepository = parkingLotRepository;
        this.gateRepository = gateRepository;
        this.parkingLotRepository = parkingLotRepository;
        this.parkingSpotRepository = parkingSpotRepository;
    }

    public Ticket generateTicket(Vehicle vehicle, int gateId,int parkingLotId){
        SpotAllocationStrategy strategy = SpotAllocationStratgeyFactory.getSpotAllocationStrategy();
        ParkingLot parkingLot = parkingLotRepository.getParkingLot(parkingLotId);
        ParkingSpot allocatedSpot = strategy.spot(parkingLot,vehicle);
        allocatedSpot.setParkingSpotStatus(ParkingSpotStatus.OCCUPIED);
        allocatedSpot.setVehicle(vehicle);
        parkingSpotRepository.addSpot(allocatedSpot);
        Ticket ticket = new Ticket();
        ticket.setEntryTime(LocalDateTime.now());
        ticket.setEntryGate(gateRepository.getGate(gateId));
        ticket.setParkingSpot(allocatedSpot);
        ticket.setVehicle(vehicle);
        return  ticketRepository.addTicket(ticket);



    }
}
