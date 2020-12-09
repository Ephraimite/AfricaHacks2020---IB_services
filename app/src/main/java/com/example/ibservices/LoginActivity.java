package com.example.ibservices;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ibservices.Ui.MainActivity;
import com.example.ibservices.Ui.ProgressButton;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    View btn_login;
    TextView signUpHere;
    private ProgressButton progressButton;
    EditText et_email, et_password;
    View view;

    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btn_login = findViewById(R.id.btn_login);
        signUpHere = findViewById(R.id.signup_here);
        et_email = findViewById(R.id.sign_in_email);
        et_password = findViewById(R.id.sign_in_password);

        mAuth = FirebaseAuth.getInstance();

        btn_login.setOnClickListener(v -> {

            progressButton = new ProgressButton(LoginActivity.this, view);
            String email = et_email.getText().toString();
            String password = et_password.getText().toString();

            if (TextUtils.isEmpty(email)){
                Toast.makeText(this, "Pls input email", Toast.LENGTH_LONG).show();
            } else if (TextUtils.isEmpty(password)) {
                Toast.makeText(this, "Pls input password", Toast.LENGTH_LONG).show();
            }else{
                loginUser(email, password);
                progressButton.buttonActivated();
            }
        });

        signUpHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, SignUpActivity.class));
                finish();
            }
        });


    }

    private void loginUser(String email, String password) {

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        // Sign in success, update UI with the signed-in user's information
                        Toast.makeText(this, "Login Successful", Toast.LENGTH_LONG).show();
                        FirebaseUser user = mAuth.getCurrentUser();
                        progressButton.buttonFinished();

                        startActivity(new Intent(LoginActivity.this, MainActivity.class));


                    } else {
                        // If sign in fails, display a message to the user.
                        Toast.makeText(LoginActivity.this, "Authentication failed." + task.getException(), Toast.LENGTH_SHORT).show();
                        progressButton.buttonFinished();
                    }

                    // ...
                });
    }
}