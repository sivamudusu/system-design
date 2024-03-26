package org.example.designpatterns.adapter;

public interface BankAPIAdapter {

    double checkBalance(User user);
    int doTransaction(User fromUser, User toUser, double amount);
    boolean changePassword(User user,int currentPin,int newPin );
}
