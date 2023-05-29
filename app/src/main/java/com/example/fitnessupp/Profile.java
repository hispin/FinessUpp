package com.example.fitnessupp;

import java.util.ArrayList;

public class Profile extends User {
    private String userName;
    private ArrayList<Food> foodArrayList;
    private int totalCarbohydrate;
    private int totalFat;
    private int totalProtein;

    public Profile(String userName, int totalCarbohydrate, int totalFat, int totalProtein) {
        super();
        this.userName = userName;
        this.totalCarbohydrate = totalCarbohydrate;
        this.totalFat = totalFat;
        this.totalProtein = totalProtein;
        foodArrayList = new ArrayList<>();
    }

    public Profile() {
        super();
        foodArrayList = new ArrayList<>();
    }

    public int getTotalCarbohydrate() {
        return totalCarbohydrate;
    }

    public void setTotalCarbohydrate(int totalCarbohydrate) {
        this.totalCarbohydrate = totalCarbohydrate;
    }

    public int getTotalFat() {
        return totalFat;
    }

    public void setTotalFat(int totalFat) {
        this.totalFat = totalFat;
    }

    public int getTotalProtein() {
        return totalProtein;
    }

    public void setTotalProtein(int totalProtein) {
        this.totalProtein = totalProtein;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public ArrayList<Food> getFoodArrayList() {
        return foodArrayList;
    }

    public void setFoodArrayList(ArrayList<Food> foodArrayList) {
        this.foodArrayList = foodArrayList;
    }
}
