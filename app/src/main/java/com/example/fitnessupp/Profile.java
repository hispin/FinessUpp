package com.example.fitnessupp;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

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
        foodArrayList = new ArrayList<>();
    }

    public void getDetailedFromFireStore() {
        FirebaseFirestore.getInstance().collection("Food").get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                for (DocumentSnapshot documentSnapshot : queryDocumentSnapshots) {
                    if (documentSnapshot.exists()) {
                        String name = documentSnapshot.getString("name");
                        Long protein = documentSnapshot.getLong("protein");
                        int protein1 = Math.toIntExact(protein);
                        Long carbohydrate = documentSnapshot.getLong("carbohydrate");
                        int carbohydrate1 = Math.toIntExact(carbohydrate);
                        Long fat = documentSnapshot.getLong("fat");
                        int fat1 = Math.toIntExact(fat);
                        Long calories = documentSnapshot.getLong("calories");
                        int calories1 = Math.toIntExact(calories);
                        Food food = new Food(name, protein1, carbohydrate1, fat1, calories1);
                        foodArrayList.add(food);
                    }
                }
            }
        });
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
