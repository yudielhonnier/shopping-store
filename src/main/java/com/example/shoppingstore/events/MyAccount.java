package com.example.shoppingstore.events;

public class MyAccount {
    int balance = 20;
    String balanceString = "20";


    public boolean withdraw(int amount) {
        if (balance < amount) {
            return false;
        }
        balance = balance - amount;
        return true;
    }

    public String getBalance() {
        return balanceString;
    }
}