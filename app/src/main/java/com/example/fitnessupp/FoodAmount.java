package com.example.fitnessupp;

public class FoodAmount {
    private String name;
    private int amount;

    public FoodAmount(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    public FoodAmount() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
