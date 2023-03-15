package com.example.fitnessupp;

import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class ProfileFragment extends Fragment implements View.OnClickListener {
    private ConstraintLayout accountSettings;
    private ConstraintLayout myStatus;
    private ConstraintLayout userDetails;
    private ConstraintLayout notifications;
    private ConstraintLayout fingerprintSettings;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        setViews(view);

        //TODO

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.accountSettings:
                Toast.makeText(requireActivity(), "hey1", Toast.LENGTH_SHORT).show();
                break;

            case R.id.myStatus:
                Toast.makeText(requireActivity(), "hey2", Toast.LENGTH_SHORT).show();
                break;

            case R.id.userDetails:
                Toast.makeText(requireActivity(), "hey3", Toast.LENGTH_SHORT).show();
                break;

            case R.id.notifications:
                Toast.makeText(requireActivity(), "hey4", Toast.LENGTH_SHORT).show();
                break;

            case R.id.fingerprintSettings:
                Toast.makeText(requireActivity(), "hey5", Toast.LENGTH_SHORT).show();
                break;

            default:
        }
    }

    public void setViews(View view) {
        accountSettings = view.findViewById(R.id.accountSettings);
        accountSettings.setOnClickListener(this);
        myStatus = view.findViewById(R.id.myStatus);
        myStatus.setOnClickListener(this);
        userDetails = view.findViewById(R.id.userDetails);
        userDetails.setOnClickListener(this);
        notifications = view.findViewById(R.id.notifications);
        notifications.setOnClickListener(this);
        fingerprintSettings = view.findViewById(R.id.fingerprintSettings);
        fingerprintSettings.setOnClickListener(this);
    }
}