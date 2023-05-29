package com.example.fitnessupp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

public class ProfileFragment extends Fragment implements View.OnClickListener {
    private TextView profileUserNameTv;
    private TextView profileEmailTv;
    private ConstraintLayout accountSettings;
    private ConstraintLayout myStatus;
    private ConstraintLayout userDetails;
    private ConstraintLayout notifications;
    private ConstraintLayout fingerprintSettings;
    private Fragment pFrag;
    private MainViewModel mvmProfile;

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
        mvmProfile = new ViewModelProvider(requireActivity()).get(MainViewModel.class);

        //TODO
        mvmProfile.getUserDetails();
        User user = mvmProfile.getUser();
        profileUserNameTv.setText(user.getUserName());
        profileEmailTv.setText(user.getEmail());

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.accountSettings:
                pFrag = new AccountSettingsFragment();
                FragmentTransaction ft1 = requireActivity().getSupportFragmentManager().beginTransaction();
                ft1.replace(R.id.Fragment, pFrag);
                ft1.addToBackStack(null);
                ft1.commit();
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
        myStatus = view.findViewById(R.id.myStatus);
        userDetails = view.findViewById(R.id.userDetails);
        notifications = view.findViewById(R.id.notifications);
        fingerprintSettings = view.findViewById(R.id.fingerprintSettings);
        profileUserNameTv = view.findViewById(R.id.profileUserNameTv);
        profileEmailTv = view.findViewById(R.id.profileEmailTv);

        fingerprintSettings.setOnClickListener(this);
        accountSettings.setOnClickListener(this);
        myStatus.setOnClickListener(this);
        userDetails.setOnClickListener(this);
        notifications.setOnClickListener(this);
    }
}