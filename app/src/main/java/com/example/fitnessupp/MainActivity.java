package com.example.fitnessupp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private BottomNavigationView bottomNavMain;
    private Fragment fragMain;
    private ImageView imI;
    private ImageView imUSA;
    private TextView textView;


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
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.imI:
                Locale locale = new Locale("iw");
                Locale.setDefault(locale);
                Resources resources = getResources();
                Configuration configuration = resources.getConfiguration();
                configuration.setLocale(locale);
                resources.updateConfiguration(configuration,resources.getDisplayMetrics());
                finish();
                startActivity(getIntent());
                break;

            case R.id.ivUSA:
                Locale locale2 = new Locale("en");
                Locale.setDefault(locale2);
                Resources resources2 = getResources();
                Configuration configuration2 = resources2.getConfiguration();
                configuration2.setLocale(locale2);
                resources2.updateConfiguration(configuration2,resources2.getDisplayMetrics());
                finish();
                startActivity(getIntent());
                break;

            default:
        }
    }

    public void setViews() {
        bottomNavMain = findViewById(R.id.bottom_navigation);
        bottomNavMain.setSelectedItemId(R.id.home);
        imI = findViewById(R.id.imI);
        imI.setOnClickListener(this);
        imUSA = findViewById(R.id.ivUSA);
        imUSA.setOnClickListener(this);
        textView = findViewById(R.id.tttt);
    }
}