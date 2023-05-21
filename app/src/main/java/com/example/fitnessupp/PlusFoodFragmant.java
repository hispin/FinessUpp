package com.example.fitnessupp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PlusFoodFragmant extends Fragment {
    private MainViewModel mvmPlusFf;
    private RecyclerView recyclerView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_plus_food_fragmant, container, false);
        setViews(view);
        mvmPlusFf = new ViewModelProvider(requireActivity()).get(MainViewModel.class);

        //TODO
        mvmPlusFf.livedataFoodsList.observe(requireActivity(), new Observer<ArrayList<Food>>() {
            @Override
            public void onChanged(ArrayList<Food> foods) {
                FoodAdapter foodAdapter = new FoodAdapter(foods, new FoodAdapter.OnItemClickLister() {
                    @Override
                    public void onItemClick(Food food) {
                        //TODO
                    }
                });
                recyclerView.setLayoutManager(new LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false));
                recyclerView.setAdapter(foodAdapter);
                recyclerView.setHasFixedSize(true);
            }
        });

        return view;
    }

    public void setViews(View view) {
        recyclerView = view.findViewById(R.id.recycleViewPf);
    }
}