package org.example.projects.parkinglot.repository;

import org.example.projects.parkinglot.exception.GateNotFoundException;
import org.example.projects.parkinglot.models.Gate;

import java.util.HashMap;
import java.util.Map;

public class GateRepository {
    private Map<Integer, Gate>gateMap;

    public GateRepository(){
        this.gateMap = new HashMap<>();
    }
    public Gate getGate(int gateId){
        Gate gate = gateMap.get(gateId);
        if(gate==null){
            throw new GateNotFoundException("Gate not found for the id"+gateId);
        }
        return gate;
    }
    public void addGate(Gate gate){
        gateMap.put(gate.getId(),gate);
        System.out.println("gate has been added to the repository");
    }
}
