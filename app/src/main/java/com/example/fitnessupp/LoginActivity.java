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
    private SharedPreferences mySharedPref;
    private SharedPreferences.Editor myEdit;
    private TextView logInTvcb;
    private TextView signUTvcb;
    private TextView headlineTv;
    private TextView registerTv;
    private EditText userNameEd;
    private EditText passwordEd;
    private FirebaseAuth auth;
    private String email;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setViews();
        auth = FirebaseAuth.getInstance();
        mySharedPref = getSharedPreferences("mySharedPref", MODE_PRIVATE);
        myEdit = mySharedPref.edit();
        userNameEd.setText(mySharedPref.getString("username", ""));
        if (auth.getCurrentUser() != null) {
            goToMainActivity();
        }
        //userNameEd.setText(mySharedPref.getString("userName", "-1"));

        //TODO
        //myEdit.putString("userName", userNameEd.getText().toString());
    }

    private void goToMainActivity() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.logInTextViewCB:
                myEdit.putString("userName", userNameEd.getText().toString());
                if (logInTvcb.getText().equals(getResources().getString(R.string.login))) {
                    getEmailAndPassword();
//                    auth.signInWithEmailAndPassword(email, password).addOnCanceledListener(this, new OnCompleteListener<AuthResult>() {
//                        @Override
//                        public void onComplete(@NonNull Task<AuthResult> task) {
//                            if (task.isSuccessful()) {
//                                login();
//                            } else {
//                                Toast.makeText(LoginActivity.this, getResources().getString(R.string.youarenotinourdatabase), Toast.LENGTH_SHORT).show();
//                            }
//                        }
//                    });
                }

            case R.id.signUpTextViewCb:
                if (signUTvcb.getText().equals(getResources().getString(R.string.Signup))) {
                    headlineTv.setText(getResources().getString(R.string.Signup));
                    logInTvcb.setText(getResources().getString(R.string.Signup));
                    registerTv.setText(getResources().getString(R.string.Alreadyregistered));
                    signUTvcb.setText(getResources().getString(R.string.login));
                }
                if (signUTvcb.getText().equals(getResources().getString(R.string.login))) {
                    headlineTv.setText(getResources().getString(R.string.login));
                    logInTvcb.setText(getResources().getString(R.string.login));
                    registerTv.setText(getResources().getString(R.string.Notregisteredyet));
                    signUTvcb.setText(getResources().getString(R.string.Signup));
                }

            default:
        }
    }

    private void getEmailAndPassword() {
        email = userNameEd.getText().toString();
        password = passwordEd.getText().toString();
    }

    private void in() {
        Toast.makeText(this, getResources().getString(R.string.youarenotinourdatabase), Toast.LENGTH_SHORT).show();
    }

    private void login() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }

    private void setViews() {
        logInTvcb = findViewById(R.id.logInTextViewCB);
        signUTvcb = findViewById(R.id.signUpTextViewCb);
        userNameEd = findViewById(R.id.userNameEd);
        passwordEd = findViewById(R.id.passwordEd);
        headlineTv = findViewById(R.id.headlineTv);
        registerTv = findViewById(R.id.registerTv);

        logInTvcb.setOnClickListener(this);
        signUTvcb.setOnClickListener(this);
    }
}