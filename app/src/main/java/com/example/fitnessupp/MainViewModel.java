package com.example.fitnessupp;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class MainViewModel extends ViewModel {
    private User mvmUser;
    private Project mvmProject;
    private Profile mvmProfile;
    private ArrayList<Food> foodArrayList;
    public MutableLiveData<ArrayList<Food>> livedataFoodsList;


    public MainViewModel() {
        mvmUser = new User();
        mvmProject = new Project();
        mvmProfile = new Profile();
        foodArrayList = new ArrayList<>();
        getDetailedFromFireStore();
        livedataFoodsList = new MutableLiveData<ArrayList<Food>>();
    }

    //TODO
    public String getDetail() {
        ArrayList<Food> arrayList = mvmProfile.getFoodArrayList();
        String s = String.valueOf(arrayList.get(1));

        return s;
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
                fillFoods();
            }
        });
    }

    public void fillFoods() {
        livedataFoodsList.setValue(foodArrayList);
    }
}
