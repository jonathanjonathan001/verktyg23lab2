package com.example;

public class BankServiceImpl implements BankService {
    @Override
    public void pay(String id, double amount) {
        if (id.equals("fail"))
            throw new RuntimeException();
    }
}
