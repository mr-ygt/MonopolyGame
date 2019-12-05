package com.company;

public class Money {
    int amount;

    public Money() {
        this(0);
    }

    public Money(int amount) {
        this.amount = amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void addMoney(int amount) {
        this.amount += amount;
    }

    public void subtractMoney(int amount) {
        this.amount -= amount;
    }

    public boolean isBrokeOut() {
        return amount < 0;
    }
}