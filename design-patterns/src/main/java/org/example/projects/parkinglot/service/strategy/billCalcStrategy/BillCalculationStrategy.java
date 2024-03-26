package org.example.projects.parkinglot.service.strategy.billCalcStrategy;

import org.example.projects.parkinglot.models.Bill;
import org.example.projects.parkinglot.models.Ticket;

public interface BillCalculationStrategy {
    Bill generateBill(Ticket ticket);
}
