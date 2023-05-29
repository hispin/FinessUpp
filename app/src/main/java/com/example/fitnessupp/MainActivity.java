package com.example.fitnessupp;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private BottomNavigationView bottomNavMain;
    private ConstraintLayout mainData;
    private ConstraintLayout secondData;
    private ConstraintLayout thirdData;
    private ConstraintLayout forthData;
    private TextView headlineTextView;
    private TextView plusButtonMain;
    private TextView mainTextView;
    private Fragment fragMain;
    private MainViewModel mvmMain;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setViews();

        bottomNavMain.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        FragmentTransaction ft1 = getSupportFragmentManager().beginTransaction();
                        ft1.detach(fragMain);
                        ft1.addToBackStack(null);
                        ft1.commit();
                        break;

                    case R.id.water:
                        fragMain = new WaterFragment();
                        FragmentTransaction ft2 = getSupportFragmentManager().beginTransaction();
                        ft2.replace(R.id.Fragment, fragMain);
                        ft2.addToBackStack(null);
                        ft2.commit();
                        break;

                    case R.id.profile:
                        fragMain = new ProfileFragment();
                        FragmentTransaction ft3 = getSupportFragmentManager().beginTransaction();
                        ft3.replace(R.id.Fragment, fragMain);
                        ft3.addToBackStack(null);
                        ft3.commit();
                        break;

                    default:
                }
                return true;
            }
        });
        mvmMain = new ViewModelProvider(this).get(MainViewModel.class);

        //TODO
        //mainTextView.setText(mvmMain.getDetail());

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.plusButtonFood:
                fragMain = new PlusFoodFragmant();
                FragmentTransaction ft4 = getSupportFragmentManager().beginTransaction();
                ft4.replace(R.id.Fragment, fragMain);
                ft4.addToBackStack(null);
                ft4.commit();
                break;

            default:
        }
    }

    public void setViews() {
        bottomNavMain = findViewById(R.id.bottom_navigation);
        headlineTextView = findViewById(R.id.tttt);
        mainData = findViewById(R.id.mainData);
        secondData = findViewById(R.id.secondData);
        thirdData = findViewById(R.id.thirdData);
        forthData = findViewById(R.id.forthData);
        plusButtonMain = findViewById(R.id.plusButtonFood);
        mainTextView = findViewById(R.id.mainTextView);

        bottomNavMain.setSelectedItemId(R.id.home);

        mainData.setOnClickListener(this);
        secondData.setOnClickListener(this);
        thirdData.setOnClickListener(this);
        forthData.setOnClickListener(this);
        plusButtonMain.setOnClickListener(this);
    }
}