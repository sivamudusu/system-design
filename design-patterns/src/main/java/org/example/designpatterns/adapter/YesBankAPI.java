package org.example.designpatterns.adapter;

public class YesBankAPI {
    public long getBalance(String username, String password){
        return 1000;
    }

    public char doTransaction(String fromUser, String toUser, String fromUserPassword,double amount){
        return 'y';
    }

    public boolean changePin(String username, String password, int currentPin,int newPin){
        return true;
    }
}
