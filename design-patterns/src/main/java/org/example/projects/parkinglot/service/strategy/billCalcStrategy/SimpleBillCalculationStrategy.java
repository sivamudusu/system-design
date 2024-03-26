package org.example.projects.parkinglot.service.strategy.billCalcStrategy;

import org.example.projects.parkinglot.models.Bill;
import org.example.projects.parkinglot.models.Ticket;
import org.example.projects.parkinglot.models.enums.BillStatus;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class SimpleBillCalculationStrategy implements BillCalculationStrategy{
//    1sec 10rs

    @Override
    public Bill generateBill(Ticket ticket) {
        LocalDateTime entryTime = ticket.getEntryTime();
        LocalDateTime exitTime = LocalDateTime.now();
        long numberOfSconds = ChronoUnit.SECONDS.between(exitTime,entryTime);
        double amount = numberOfSconds;
        Bill bill = new Bill();
        bill.setAmount(amount);
        bill.setTicket(ticket);
        bill.setExitTime(exitTime);
        bill.setId(exitTime.hashCode());
        bill.setBillStatus(BillStatus.UNPAID);

        return bill;

    }
}
