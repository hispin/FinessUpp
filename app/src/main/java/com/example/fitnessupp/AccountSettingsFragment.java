package com.example.fitnessupp;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;

import java.util.Locale;

public class AccountSettingsFragment extends Fragment implements View.OnClickListener {
    private ImageView asfImIsraelFlag;
    private ImageView asfImUSA;
    private TextView asfTvcbSignout;
    private FirebaseAuth auth;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_account_settings, container, false);
        setViews(view);

        //TODO

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.asfImIsraelFlag:
                Locale locale = new Locale("iw");
                Locale.setDefault(locale);
                Resources resources = getResources();
                Configuration configuration = resources.getConfiguration();
                configuration.setLocale(locale);
                resources.updateConfiguration(configuration, resources.getDisplayMetrics());
                getActivity().recreate();
                break;

            case R.id.asfImUSA:
                Locale locale2 = new Locale("en");
                Locale.setDefault(locale2);
                Resources resources2 = getResources();
                Configuration configuration2 = resources2.getConfiguration();
                configuration2.setLocale(locale2);
                resources2.updateConfiguration(configuration2, resources2.getDisplayMetrics());
                getActivity().recreate();
                break;

            case R.id.asfTvcbSignout:
                auth.getInstance().signOut();
                Intent i = new Intent(requireActivity(), LoginActivity.class);
                startActivity(i);
                break;

            default:
        }
    }

    public void setViews(View view) {
        asfImIsraelFlag = view.findViewById(R.id.asfImIsraelFlag);
        asfImUSA = view.findViewById(R.id.asfImUSA);
        asfTvcbSignout = view.findViewById(R.id.asfTvcbSignout);

        asfImIsraelFlag.setOnClickListener(this);
        asfImUSA.setOnClickListener(this);
        asfTvcbSignout.setOnClickListener(this);
    }
}