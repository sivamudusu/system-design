package org.example.projects.parkinglot;

import org.example.projects.parkinglot.controller.InitController;
import org.example.projects.parkinglot.controller.TicketController;
import org.example.projects.parkinglot.models.ParkingLot;
import org.example.projects.parkinglot.models.Ticket;
import org.example.projects.parkinglot.models.Vehicle;
import org.example.projects.parkinglot.models.enums.VehicleType;
import org.example.projects.parkinglot.repository.*;
import org.example.projects.parkinglot.service.InitialisationService;
import org.example.projects.parkinglot.service.TicketService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ParkingFloorRepository parkingFloorRepository = new ParkingFloorRepository();
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        ParkingSpotRepository parkingSpotRepository = new ParkingSpotRepository();
        GateRepository gateRepository = new GateRepository();
        TicketRepository ticketRepository = new TicketRepository();

        InitialisationService initialisationService = new InitialisationService(parkingLotRepository,parkingSpotRepository,parkingFloorRepository,gateRepository);
        InitController initController = new InitController(initialisationService);
        TicketService ticketService = new TicketService(ticketRepository,parkingLotRepository,gateRepository,parkingSpotRepository);
        TicketController ticketController = new TicketController(ticketService);
        System.out.println("** parking lot init started **");
        ParkingLot parkingLot = initController.init();
        System.out.println("end");
        System.out.println("please enter an option -> 1. enter parking, 2. exit parking");
        int option = sc.nextInt();
        while (true){
            if(option == 1){
                Vehicle vehicle = new Vehicle();
                System.out.println("enetr the vehicle number");
                String number = sc.next();
                vehicle.setVehicleNumber(number);
                System.out.println("enter the vehicle color");
                String color = sc.next();
                vehicle.setColor(color);
                System.out.println("enter vehicletype -> 1. car, 2. bike");
                int type = sc.nextInt();
                if(type == 1){
                    vehicle.setVehicleType(VehicleType.FOUR_WHEELER);
                }else{
                    vehicle.setVehicleType(VehicleType.TWO_WHEELER);
                }
                System.out.println("please enetr the parking lot id");
                int parkingLotId = sc.nextInt();
                System.out.println("plesse enter the gate Id");
                int gateId = sc.nextInt();
                Ticket ticket = ticketController.generateTicket(vehicle,gateId,parkingLotId);
                System.out.println("gnerated ticket" + ticket);

            }else {
                break;
            }
        }


    }
}
