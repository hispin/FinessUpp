package com.example.fitnessupp;

import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    private Food mvmFood;
    private User mvmUser;
    private Project mvmProject;

    public MainViewModel() {
        mvmFood = new Food();
        mvmUser = new User();
        mvmProject = new Project();
    }

    //TODO
}
