package org.example.projects.parkinglot.controller;

import org.example.projects.parkinglot.exception.InvalidRequestException;
import org.example.projects.parkinglot.models.Ticket;
import org.example.projects.parkinglot.models.Vehicle;
import org.example.projects.parkinglot.service.TicketService;

public class TicketController {
    private TicketService ticketService;

    public TicketController(TicketService ticketService){
        this.ticketService = ticketService;
    }
    public Ticket generateTicket(Vehicle vehicle, int gateId,int parkingLotId){
//        main job of controller is to validate the data
        if(gateId <=0 ||parkingLotId <= 0){
            throw new InvalidRequestException("please enter a valid request");
        }
        return ticketService.generateTicket(vehicle,gateId,parkingLotId);
    }
}

