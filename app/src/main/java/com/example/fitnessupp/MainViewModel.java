package com.example.fitnessupp;

import android.util.Log;

import androidx.annotation.Nullable;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class MainViewModel extends ViewModel {
    private User mvmUser;
    private Project mvmProject;
    private Profile mvmProfile;
    private ArrayList<Food> foodArrayList;
    public MutableLiveData<ArrayList<Food>> livedataFoodsList;
    private User user;


    public MainViewModel() {
        mvmUser = new User();
        mvmProject = new Project();
        mvmProfile = new Profile();
        foodArrayList = new ArrayList<>();
        livedataFoodsList = new MutableLiveData<ArrayList<Food>>();
        getFoodAllCollection();
        getUserDetails();
    }

    //TODO
    public String getDetail() {
        ArrayList<Food> arrayList = mvmProfile.getFoodArrayList();
        String s = String.valueOf(arrayList.get(1));

        return s;
    }

    public void getUserDetails() {
        final DocumentReference docRef = FirebaseFirestore.getInstance().collection("Users").document("HF8dY82mWp030VlEnojK");
        docRef.addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
                if (error != null) {
                    Log.w("Tag", "Listen failed", error);
                    return;
                }

                if (value != null && value.exists()) {
                    String userName = value.getString("userName");
                    //user.setUserName(userName);
                    String email = value.getString("email");
                    //user.setEmail(email);
                    String password = value.getString("password");
                    //user.setPassword(password);
                    long age = value.getLong("age");
                    int age1 = Math.toIntExact(age);
                    //user.setAge(age1);
                    Long height = value.getLong("height");
                    int height1 = Math.toIntExact(height);
                    //user.setHeight(height1);
                    Long weight = value.getLong("weight");
                    int weight1 = Math.toIntExact(weight);
                    //user.setWeight(weight1);
                    boolean isMale = value.getBoolean("isMale");
                    //user.setMale(isMale);
                    user = new User(userName, email, password, age1, height1, weight1, isMale);
                }
            }
        });
    }

    public void getFoodAllCollection() {
        final CollectionReference docRef = FirebaseFirestore.getInstance().collection("Food");
        docRef.addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                if (error != null) {
                    Log.w("TAG", "failed", error);
                    return;
                }

                foodArrayList = new ArrayList<>();
                for (QueryDocumentSnapshot doc : value) {
                    String name = doc.getString("name");
                    long protein = doc.getLong("protein");
                    int protein1 = Math.toIntExact(protein);
                    Long carbohydrate = doc.getLong("carbohydrate");
                    int carbohydrate1 = Math.toIntExact(carbohydrate);
                    Long fat = doc.getLong("fat");
                    int fat1 = Math.toIntExact(fat);
                    Long calories = doc.getLong("calories");
                    int calories1 = Math.toIntExact(calories);
                    Food food = new Food(name, protein1, carbohydrate1, fat1, calories1);
                    foodArrayList.add(food);
                }
                fillFoods();
                Log.d("TIG", "Current Food in CA: " + foodArrayList);
            }
        });

    }

    public void fillFoods() {
        livedataFoodsList.setValue(foodArrayList);
    }

    public User getUser() {
        return user;
    }
}
