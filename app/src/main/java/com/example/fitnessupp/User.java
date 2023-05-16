package com.example.fitnessupp;

public class User {
    private String userName;
    private String password;
    private int age;
    private int height;
    private int weight;
    private boolean isMale;

    public User(String userName, String email, int age, int height, int weight, boolean isMale) {
        this.userName = userName;
        this.password = email;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.isMale = isMale;
    }

    public User() {
    }

    //TODO


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean male) {
        isMale = male;
    }
}
