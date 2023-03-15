package com.example.fitnessupp;

public class Food {
    private int protein;
    private int carbohydrates;
    private int fat;
    private int Sugar;
    private int totalCal;

    public Food(int protein, int carbohydrates, int fat, int sugar, int totalCal) {
        this.protein = protein;
        this.carbohydrates = carbohydrates;
        this.fat = fat;
        Sugar = sugar;
        this.totalCal = totalCal;
    }

    public int getProtein() {
        return protein;
    }

    public void setProtein(int protein) {
        this.protein = protein;
    }

    public int getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(int carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public int getFat() {
        return fat;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    public int getSugar() {
        return Sugar;
    }

    public void setSugar(int sugar) {
        Sugar = sugar;
    }

    public int getTotalCal() {
        return totalCal;
    }

    public void setTotalCal(int totalCal) {
        this.totalCal = totalCal;
    }
}
