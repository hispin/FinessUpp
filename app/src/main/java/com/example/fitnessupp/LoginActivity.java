package com.example.fitnessupp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    SharedPreferences mySharedPreferences;
    SharedPreferences.Editor myEdit;
    private TextView logInTvcb;
    private TextView signUTvcb;
    private EditText userNameEd;
    private EditText passwordEd;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setViews();
        auth = FirebaseAuth.getInstance();
        mySharedPreferences = getSharedPreferences("mySharedPreferences", MODE_PRIVATE);
        myEdit = mySharedPreferences.edit();
        userNameEd.setText(mySharedPreferences.getString("username", " "));

        //TODO
        myEdit.putString("userName", userNameEd.getText().toString());
    }

    private void logIn() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }

    @Override
    public void onClick(View view) {
        myEdit.putString("userName", userNameEd.getText().toString());
        switch (view.getId()) {

            case R.id.logInTextViewCB:
                if (auth.getCurrentUser() != null) {
                    logIn();
                } else {
                    Toast.makeText(this, "You are not in our database, you can try to register", Toast.LENGTH_SHORT).show();
                }

            case R.id.signUpTextViewCb:
                int i = 0;
        }

    }

    private void setViews() {
        logInTvcb = findViewById(R.id.logInTextViewCB);
        userNameEd = findViewById(R.id.userNameEd);
        passwordEd = findViewById(R.id.passwordEd);

        logInTvcb.setOnClickListener(this);
    }
}