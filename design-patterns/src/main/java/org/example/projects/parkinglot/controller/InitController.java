package org.example.projects.parkinglot.controller;

import org.example.projects.parkinglot.models.ParkingLot;
import org.example.projects.parkinglot.service.InitialisationService;

public class InitController {
    private InitialisationService initialisationService;

    public InitController(InitialisationService initialisationService) {
        this.initialisationService = initialisationService;
    }

    public ParkingLot init(){
        return  initialisationService.init();
    }
}
