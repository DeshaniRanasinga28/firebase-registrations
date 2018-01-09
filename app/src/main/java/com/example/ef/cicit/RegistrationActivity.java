package com.example.ef.cicit;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class RegistrationActivity extends AppCompatActivity {
    public static final String TAG = RegistrationActivity.class.getSimpleName();
    private TextView texLogin;

    private EditText textName;
    private EditText textPassword;
    private EditText textConPassword;
    private EditText tetxCompany;
    private EditText textPhone;
    private EditText textEmail;

    private Button regLogin;


    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        firebaseAuth = FirebaseAuth.getInstance();

        textName = (EditText)findViewById(R.id.user_name);
        textPassword = (EditText)findViewById(R.id.user_password);
        textConPassword = (EditText)findViewById(R.id.user_conPassword);
        tetxCompany = (EditText)findViewById(R.id.user_company);
        textPhone = (EditText)findViewById(R.id.user_phone);
        textEmail = (EditText)findViewById(R.id.user_email);

        regLogin = (Button)findViewById(R.id.signup);
    }


    //User Registration
    private void usereRegistration() {

        String password = textPassword.getText().toString().trim();
        String email = textEmail.getText().toString().trim();

        if(TextUtils.isEmpty(email)){
            Toast.makeText(getApplicationContext(),"Enter email address!", Toast.LENGTH_SHORT).show();
        }

        if(TextUtils.isEmpty(password)){
            Toast.makeText(getApplicationContext(),"Enter password!", Toast.LENGTH_SHORT).show();
        }

        if(password.length() < 6){
            Toast.makeText(getApplicationContext(),"Password too short, enter minimum 6 characters!",
                    Toast.LENGTH_SHORT).show();
        }

        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(RegistrationActivity.this, "Authentication Successful", Toast.LENGTH_SHORT)
                                    .show();
                        } else {
                            Toast.makeText(RegistrationActivity.this, "Authentication Failed", Toast.LENGTH_SHORT)
                                    .show();
                        }

                    }
                });
    }

    public void onRegSignin(View view){
        usereRegistration();
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
        finish();
    }

    public void onLogin(View view){
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
        finish();
    }

}
