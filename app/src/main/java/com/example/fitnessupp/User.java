package com.example.fitnessupp;

public class User {
    private String userName;
    private String email;
    private int age;
    private int height;
    private int weight;
    private int caloricGoal;
    private boolean isMale;

    public User(String userName, String email, int age, int height, int weight, int caloricGoal, boolean isMale) {
        this.userName = userName;
        this.email = email;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.caloricGoal = caloricGoal;
        this.isMale = isMale;
    }
//TODO


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getCaloricGoal() {
        return caloricGoal;
    }

    public void setCaloricGoal(int caloricGoal) {
        this.caloricGoal = caloricGoal;
    }

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean male) {
        isMale = male;
    }
}
