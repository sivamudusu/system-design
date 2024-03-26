package org.example.projects.parkinglot.models;

import org.example.projects.parkinglot.models.enums.BillStatus;

import java.time.LocalDateTime;

public class Bill extends BaseModel{
    private LocalDateTime exitTime;
    private Double amount;
    private BillStatus billStatus;
    private Ticket ticket;
    private Gate exitGate;

    public Bill(LocalDateTime exitTime, Double amount, BillStatus billStatus, Ticket ticket, Gate exitGate) {
        this.exitTime = exitTime;
        this.amount = amount;
        this.billStatus = billStatus;
        this.ticket = ticket;
        this.exitGate = exitGate;
    }
    public Bill(){

    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public void setExitTime(LocalDateTime exitTime) {
        this.exitTime = exitTime;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public BillStatus getBillStatus() {
        return billStatus;
    }

    public void setBillStatus(BillStatus billStatus) {
        this.billStatus = billStatus;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Gate getExitGate() {
        return exitGate;
    }

    public void setExitGate(Gate exitGate) {
        this.exitGate = exitGate;
    }
}
