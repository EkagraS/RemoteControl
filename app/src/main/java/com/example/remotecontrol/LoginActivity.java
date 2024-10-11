package com.example.remotecontrol;

import android.content.Intent;
import android.os.Bundle;
import android.os.NetworkOnMainThreadException;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;
import com.google.firebase.ktx.Firebase;

public class LoginActivity extends AppCompatActivity {

    EditText txt1,txt2;
    Button login;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });

        txt1=findViewById(R.id.editTextEmailAddress);
        txt2=findViewById(R.id.editTextPassword);
        login=findViewById(R.id.button2);
        auth=FirebaseAuth.getInstance();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=txt1.getText().toString().trim();
                String pass=txt2.getText().toString().trim();

                auth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        try {
                            if (task.isSuccessful()) {
                                startActivity(new Intent(LoginActivity.this, StartActivity.class));
                                finish();
                            } else {
                                Log.d("Login Failed", task.getException().toString());
                                Toast.makeText(LoginActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                            }
                        } catch (Exception e) {
                            Log.e("LoginActivity", "Login failed: " + e.getMessage(), e);

                            if (e instanceof FirebaseAuthInvalidUserException) {
                                Toast.makeText(LoginActivity.this, "No account found with this email.", Toast.LENGTH_LONG).show();
                            }
                            else if (e instanceof FirebaseAuthInvalidCredentialsException) {
                                Toast.makeText(LoginActivity.this, "Invalid credentials. Please check your email and password.", Toast.LENGTH_LONG).show();
                            }
                            else if (e instanceof NetworkOnMainThreadException) {
                                Toast.makeText(LoginActivity.this, "Network error. Please check your connection.", Toast.LENGTH_LONG).show();
                            }
                            else {
                                Toast.makeText(LoginActivity.this, "An unexpected error occurred. Please try again later.", Toast.LENGTH_LONG).show();
                            }

                            e.printStackTrace(); // Print stack trace for debugging purposes
                        }                    }
                });

            }
        });


    }
}