package org.example.designpatterns.adapter;

public class YesBankAPIAdapter implements BankAPIAdapter{
    private YesBankAPI yesBankAPI = new YesBankAPI();

    @Override
    public double checkBalance(User user) {
        return yesBankAPI.getBalance(user.name, user.password );
    }

    @Override
    public int doTransaction(User fromUser, User toUser, double amount) {
        return yesBankAPI.doTransaction(fromUser.name, toUser.name, fromUser.getPassword(), 200);
    }

    @Override
    public boolean changePassword(User user, int currentPin, int newPin) {
        return yesBankAPI.changePin(user.name, user.getPassword(), currentPin, newPin);
    }

    String generateToken(User user){
        return "hello";
    }
}
