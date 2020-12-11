package com.example.ibservices;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ibservices.Data.Users;
import com.example.ibservices.Ui.LoginButton;
import com.example.ibservices.Ui.SignUpButton;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class SignUpActivity extends AppCompatActivity {

    EditText et_name, et_email, et_phone, et_password;

    View view;
    View btn_signUp;
    private SignUpButton signUpButton;
    private FirebaseAuth mAuth;

    FirebaseFirestore firebaseFirestore;
    private String userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        et_name = findViewById(R.id.sign_up_name);
        et_email = findViewById(R.id.sign_up_email);
        et_phone = findViewById(R.id.signup_phone);
        et_password = findViewById(R.id.signup_password);

        view = findViewById(R.id.btn_signup);

        mAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();

        signUpButton = new SignUpButton(SignUpActivity.this, view);


        view.setOnClickListener(v -> {

            String name = et_email.getText().toString();
            String email = et_password.getText().toString();
            String phone = et_email.getText().toString();
            String password = et_password.getText().toString();

            if (TextUtils.isEmpty(name)){
                Toast.makeText(this, "Pls type your name", Toast.LENGTH_LONG).show();
            } else if (TextUtils.isEmpty(email)) {
                Toast.makeText(this, "Pls input email", Toast.LENGTH_LONG).show();
            }else if (TextUtils.isEmpty(phone)) {
                Toast.makeText(this, "Pls input phone number", Toast.LENGTH_LONG).show();
            }else if (TextUtils.isEmpty(password)) {
                Toast.makeText(this, "Pls input password", Toast.LENGTH_LONG).show();
            }
            else{
                signUpUser(email,password);
                signUpButton.buttonActivated();
            }
        });

    }

    private void signUpUser(String email, String password) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        // Sign in success, update UI with the signed-in user's information
                        Toast.makeText(SignUpActivity.this, "User has been sucessfully registered",
                                Toast.LENGTH_LONG).show();
                        signUpButton.buttonFinished();
                        startActivity(new Intent(SignUpActivity.this, LoginActivity.class));
                    } else {
                        // If sign up fails, display a message to the user.
                        Toast.makeText(SignUpActivity.this, task.getException().getMessage(),
                                Toast.LENGTH_LONG).show();
                        signUpButton.buttonFinished();

                    }

                    // ...
                });


    }


}