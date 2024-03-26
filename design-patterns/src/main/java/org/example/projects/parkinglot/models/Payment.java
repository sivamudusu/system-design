package org.example.projects.parkinglot.models;

import org.example.projects.parkinglot.models.enums.PaymentMode;
import org.example.projects.parkinglot.models.enums.PaymentStatus;

import java.time.LocalDateTime;

public class Payment extends BaseModel{
    private double amount;
    private String transactionNumber;
    private PaymentStatus paymentStatus;
    private PaymentMode paymentMode;

    private Bill bill;
    private LocalDateTime paymentTime;

    public Payment(double amount, String transactionNumber, PaymentStatus paymentStatus, PaymentMode paymentMode, Bill bill, LocalDateTime paymentTime) {
        this.amount = amount;
        this.transactionNumber = transactionNumber;
        this.paymentStatus = paymentStatus;
        this.paymentMode = paymentMode;
        this.bill = bill;
        this.paymentTime = paymentTime;
    }
    public Payment(){

    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getTransactionNumber() {
        return transactionNumber;
    }

    public void setTransactionNumber(String transactionNumber) {
        this.transactionNumber = transactionNumber;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public PaymentMode getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(PaymentMode paymentMode) {
        this.paymentMode = paymentMode;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public LocalDateTime getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(LocalDateTime paymentTime) {
        this.paymentTime = paymentTime;
    }
}
