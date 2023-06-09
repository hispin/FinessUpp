package com.example.fitnessupp;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class WaterFragment extends Fragment implements View.OnClickListener {
    private ProgressBar waterProgressBar;
    private int waterGoalWater;
    private int currentWaterCountWater;
    private int remainingWaterCountWater;
    private TextView tvCurrentWaterCountWater;
    private TextView tvRemainingWaterCountWater;
    private TextView plusDrinksWater;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_water, container, false);
        setViews(view);

        //TODO

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.plusButtonWater:
                Toast.makeText(requireActivity(), "hey", Toast.LENGTH_SHORT).show();
                Resources resources = getResources();
                tvCurrentWaterCountWater.setText("10 " + resources.getString(R.string.ml));
                tvRemainingWaterCountWater.setText("0 " + resources.getString(R.string.ml));

            default:
        }
    }

    public void setViews(View view){
        waterProgressBar = view.findViewById(R.id.progressBar);
        waterProgressBar.setProgress(90);
        plusDrinksWater = view.findViewById(R.id.plusButtonWater);
        plusDrinksWater.setOnClickListener(this);
        tvCurrentWaterCountWater = view.findViewById(R.id.currentWaterCountWater);
        tvRemainingWaterCountWater = view.findViewById(R.id.remainingWaterCountWater);
    }
}