package org.example.projects.parkinglot.repository;

import org.example.projects.parkinglot.exception.BillNotFoundException;
import org.example.projects.parkinglot.models.Bill;

import java.util.HashMap;
import java.util.Map;

public class BillRepository {

    private Map<Integer, Bill>billMap;

    public BillRepository(){
        this.billMap = new HashMap<>();

    }
    public Bill getBill(int billId){
        Bill bill = billMap.get(billId);
        if(bill == null){
            throw new BillNotFoundException("bill not found for the id "+billId);
        }
        return bill;
    }
    public void addBill(Bill bill){
        billMap.put(bill.getId(),bill);
        System.out.println("bill has been added to the db");

    }
}
