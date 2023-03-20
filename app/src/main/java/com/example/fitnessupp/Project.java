package com.example.fitnessupp;

public class Project {
    private int currentCalorieCount;
    private int waterGoal;
    private int currentWaterCount;
    private int remainingWaterCount;

    public Project(int currentCalorieCount, int waterGoal, int currentWaterCount, int remainingWaterCount) {
        this.currentCalorieCount = currentCalorieCount;
        this.waterGoal = waterGoal;
        this.currentWaterCount = currentWaterCount;
        this.remainingWaterCount = remainingWaterCount;
    }

    public Project() {
    }

    //TODO

    public int getCurrentCalorieCount() {
        return currentCalorieCount;
    }

    public void setCurrentCalorieCount(int currentCalorieCount) {
        this.currentCalorieCount = currentCalorieCount;
    }

    public int getWaterGoal() {
        return waterGoal;
    }

    public void setWaterGoal(int waterGoal) {
        this.waterGoal = waterGoal;
    }

    public int getCurrentWaterCount() {
        return currentWaterCount;
    }

    public void setCurrentWaterCount(int currentWaterCount) {
        this.currentWaterCount = currentWaterCount;
    }

    public int getRemainingWaterCount() {
        return remainingWaterCount;
    }

    public void setRemainingWaterCount(int remainingWaterCount) {
        this.remainingWaterCount = remainingWaterCount;
    }
}
