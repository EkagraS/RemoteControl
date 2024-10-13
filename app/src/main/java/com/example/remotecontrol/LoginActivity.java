package com.example.remotecontrol;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.NetworkOnMainThreadException;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;

import java.util.Objects;




public class LoginActivity extends AppCompatActivity {

    FirebaseAuth auth;


    private TextInputEditText emailEditText, passEditText;
    private TextInputLayout emailTextInputLayout, passTextInputLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });

        emailEditText = findViewById(R.id.email_inputedittext);
        emailTextInputLayout = findViewById(R.id.email_edittext_material_layout);
        passEditText = findViewById(R.id.pass_inputedittext);
        passTextInputLayout = findViewById(R.id.password_edittext_material_layout);
        auth = FirebaseAuth.getInstance();


        findViewById(R.id.login_submit_btn).setOnClickListener(view -> {

            String email = Objects.requireNonNull(emailEditText.getText()).toString().trim();
            String pass = Objects.requireNonNull(passEditText.getText()).toString().trim();


            if (email.isEmpty()) {
                emailTextInputLayout.setError("Email cannot be empty");
            } else if (pass.isEmpty()) {
                emailTextInputLayout.setError(null);
                passTextInputLayout.setError("Email cannot be empty");
            } else {
                emailTextInputLayout.setError(null);
                passTextInputLayout.setError(null);

                auth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
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
                            } else if (e instanceof FirebaseAuthInvalidCredentialsException) {
                                Toast.makeText(LoginActivity.this, "Invalid credentials. Please check your email and password.", Toast.LENGTH_LONG).show();
                            } else if (e instanceof NetworkOnMainThreadException) {
                                Toast.makeText(LoginActivity.this, "Network error. Please check your connection.", Toast.LENGTH_LONG).show();
                            } else {
                                Toast.makeText(LoginActivity.this, "An unexpected error occurred. Please try again later.", Toast.LENGTH_LONG).show();
                            }

                            e.printStackTrace(); // Print stack trace for debugging purposes
                        }
                    }
                });
            }
        });


    }
}