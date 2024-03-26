package org.example.designpatterns.adapter;

public class Phonepe {
    private BankAPIAdapter bankAPIAdapter;

    public Phonepe(){
        this.bankAPIAdapter = new YesBankAPIAdapter();
    }

    public void checkBalance(User user){
        double d = bankAPIAdapter.checkBalance(user);
        System.out.println(d);
    }
    public void transferMoney(User fromUser, User touser, double aount){
        if(bankAPIAdapter.checkBalance(fromUser)< aount){
            System.out.println("failed");
        }
        int status = bankAPIAdapter.doTransaction(fromUser,touser,aount);
        switch (status){
            case 1 :
                System.out.println("success");
                break;
            case 0 :
                System.out.println("failed");
                break;
            default:
                System.out.println("in process");
                break;
        }
//        deduct amount from user account
    }
}
