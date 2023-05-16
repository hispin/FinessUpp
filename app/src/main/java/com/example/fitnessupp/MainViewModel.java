package com.example.fitnessupp;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class MainViewModel extends ViewModel {
    private Food mvmFood;
    private User mvmUser;
    private Project mvmProject;
    private Profile mvmProfile;

    public MainViewModel() {
        mvmFood = new Food();
        mvmUser = new User();
        mvmProject = new Project();
        mvmProfile = new Profile();
        mvmProfile.getDetailedFromFireStore();
    }

    //TODO
    public String getDetail() {
        ArrayList<Food> arrayList = mvmProfile.getFoodArrayList();
        String s = String.valueOf(arrayList.get(1));

        return s;
    }
}
