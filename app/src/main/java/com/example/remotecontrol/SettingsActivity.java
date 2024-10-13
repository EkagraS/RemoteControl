package com.example.remotecontrol;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.firebase.auth.FirebaseAuth;

public class SettingsActivity extends AppCompatActivity {

    ImageView top, bottom, left, right, stop, clock, anticlock, s1, s2, s3, s4, s5;
    TextView TopRequestCode, BottomRequestCode, LeftRequestCode, RightRequestCode, StopRequestCode, AntiClockRequestCode, ClockRequestCode, s1RequestCode, s2RequestCode, s3RequestCode, s4RequestCode, s5RequestCode;
    private FirebaseAuth auth;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        top = findViewById(R.id.EditOptionTop);
        bottom = findViewById(R.id.EditOptionBottom);
        left = findViewById(R.id.EditOptionLeft);
        right = findViewById(R.id.EditOptionRight);
        stop = findViewById(R.id.EditOptionStop);
        anticlock = findViewById(R.id.EditOptionClockwise);
        clock = findViewById(R.id.EditOptionAntiClock);
        s1 = findViewById(R.id.EditOptionspeed1);
        s2 = findViewById(R.id.EditOptionspeed2);
        s3 = findViewById(R.id.EditOptionspeed3);
        s4 = findViewById(R.id.EditOptionspeed4);
        s5 = findViewById(R.id.EditOptionspeed5);

        TopRequestCode = findViewById(R.id.topRequestCode);
        BottomRequestCode = findViewById(R.id.bottomRequestCode);
        LeftRequestCode = findViewById(R.id.leftRequestCode);
        RightRequestCode = findViewById(R.id.rightRequestCode);
        StopRequestCode = findViewById(R.id.stopRequestCode);
        AntiClockRequestCode = findViewById(R.id.antiClockRequestCode);
        ClockRequestCode = findViewById(R.id.clockwiseRequestCode);
        s1RequestCode = findViewById(R.id.speed1RequestCode);
        s2RequestCode = findViewById(R.id.speed2RequestCode);
        s3RequestCode = findViewById(R.id.speed3RequestCode);
        s4RequestCode = findViewById(R.id.speed4RequestCode);
        s5RequestCode = findViewById(R.id.speed5RequestCode);
        auth = FirebaseAuth.getInstance();


        findViewById(R.id.settings_logout_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logoutUser();
            }
        });



        findViewById(R.id.settings_back_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        top.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //layout for alert box
                LinearLayout layout = new LinearLayout(SettingsActivity.this);
                layout.setOrientation(LinearLayout.VERTICAL);

                //pixel calc for alert box
                int paddingInPx = (int) (15 * getResources().getDisplayMetrics().density); // 20dp converted to pixels
                layout.setPadding(paddingInPx, paddingInPx, paddingInPx, paddingInPx);

                //edit text for alertbox
                EditText text1 = new EditText(SettingsActivity.this);
                text1.setHint("Enter new code here");
                layout.addView(text1);

                //alert box
                MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(SettingsActivity.this);
                builder.setTitle("Edit Code");
                builder.setView(layout);
                builder.setNegativeButton("Cancel", (dialog, which) -> dialog.dismiss());

                builder.setPositiveButton("Confirm", (dialog, which) -> {
                    String message = text1.getText().toString();

                    SharedPreferences.Editor editor = getSharedPreferences("Data", MODE_PRIVATE).edit();
                    editor.putString("top", message);
                    editor.apply();

                    TopRequestCode.setText(message);
                });

                builder.show();
            }
        });

        bottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //layout for alert box
                LinearLayout layout = new LinearLayout(SettingsActivity.this);
                layout.setOrientation(LinearLayout.VERTICAL);

                //pixel calc for alert box
                int paddingInPx = (int) (15 * getResources().getDisplayMetrics().density); // 20dp converted to pixels
                layout.setPadding(paddingInPx, paddingInPx, paddingInPx, paddingInPx);

                //edit text for alertbox
                EditText text1 = new EditText(SettingsActivity.this);
                text1.setHint("Enter new code here");
                layout.addView(text1);

                //alert box
                MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(SettingsActivity.this);
                builder.setTitle("Edit Code");
                builder.setView(layout);
                builder.setNegativeButton("Cancel", (dialog, which) -> dialog.dismiss());

                builder.setPositiveButton("Confirm", (dialog, which) -> {
                    String message = text1.getText().toString();

                    SharedPreferences.Editor editor = getSharedPreferences("Data", MODE_PRIVATE).edit();
                    editor.putString("bottom", message);
                    editor.apply();

                    BottomRequestCode.setText(message);
                });

                builder.show();
            }
        });

        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //layout for alert box
                LinearLayout layout = new LinearLayout(SettingsActivity.this);
                layout.setOrientation(LinearLayout.VERTICAL);

                //pixel calc for alert box
                int paddingInPx = (int) (15 * getResources().getDisplayMetrics().density); // 20dp converted to pixels
                layout.setPadding(paddingInPx, paddingInPx, paddingInPx, paddingInPx);

                //edit text for alertbox
                EditText text1 = new EditText(SettingsActivity.this);
                text1.setHint("Enter new code here");
                layout.addView(text1);

                //alert box
                MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(SettingsActivity.this);
                builder.setTitle("Edit Code");
                builder.setView(layout);
                builder.setNegativeButton("Cancel", (dialog, which) -> dialog.dismiss());

                builder.setPositiveButton("Confirm", (dialog, which) -> {
                    String message = text1.getText().toString();

                    SharedPreferences.Editor editor = getSharedPreferences("Data", MODE_PRIVATE).edit();
                    editor.putString("left", message);
                    editor.apply();

                    LeftRequestCode.setText(message);
                });

                builder.show();
            }
        });

        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //layout for alert box
                LinearLayout layout = new LinearLayout(SettingsActivity.this);
                layout.setOrientation(LinearLayout.VERTICAL);

                //pixel calc for alert box
                int paddingInPx = (int) (15 * getResources().getDisplayMetrics().density); // 20dp converted to pixels
                layout.setPadding(paddingInPx, paddingInPx, paddingInPx, paddingInPx);

                //edit text for alertbox
                EditText text1 = new EditText(SettingsActivity.this);
                text1.setHint("Enter new code here");
                layout.addView(text1);

                //alert box
                MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(SettingsActivity.this);
                builder.setTitle("Edit Code");
                builder.setView(layout);
                builder.setNegativeButton("Cancel", (dialog, which) -> dialog.dismiss());

                builder.setPositiveButton("Confirm", (dialog, which) -> {
                    String message = text1.getText().toString();

                    SharedPreferences.Editor editor = getSharedPreferences("Data", MODE_PRIVATE).edit();
                    editor.putString("right", message);
                    editor.apply();

                    RightRequestCode.setText(message);
                });

                builder.show();
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //layout for alert box
                LinearLayout layout = new LinearLayout(SettingsActivity.this);
                layout.setOrientation(LinearLayout.VERTICAL);

                //pixel calc for alert box
                int paddingInPx = (int) (15 * getResources().getDisplayMetrics().density); // 20dp converted to pixels
                layout.setPadding(paddingInPx, paddingInPx, paddingInPx, paddingInPx);

                //edit text for alertbox
                EditText text1 = new EditText(SettingsActivity.this);
                text1.setHint("Enter new code here");
                layout.addView(text1);

                //alert box
                MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(SettingsActivity.this);
                builder.setTitle("Edit Code");
                builder.setView(layout);
                builder.setNegativeButton("Cancel", (dialog, which) -> dialog.dismiss());

                builder.setPositiveButton("Confirm", (dialog, which) -> {
                    String message = text1.getText().toString();

                    SharedPreferences.Editor editor = getSharedPreferences("Data", MODE_PRIVATE).edit();
                    editor.putString("stop", message);
                    editor.apply();

                    StopRequestCode.setText(message);
                });

                builder.show();
            }
        });

        anticlock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //layout for alert box
                LinearLayout layout = new LinearLayout(SettingsActivity.this);
                layout.setOrientation(LinearLayout.VERTICAL);

                //pixel calc for alert box
                int paddingInPx = (int) (15 * getResources().getDisplayMetrics().density); // 20dp converted to pixels
                layout.setPadding(paddingInPx, paddingInPx, paddingInPx, paddingInPx);

                //edit text for alertbox
                EditText text1 = new EditText(SettingsActivity.this);
                text1.setHint("Enter new code here");
                layout.addView(text1);

                //alert box
                MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(SettingsActivity.this);
                builder.setTitle("Edit Code");
                builder.setView(layout);
                builder.setNegativeButton("Cancel", (dialog, which) -> dialog.dismiss());

                builder.setPositiveButton("Confirm", (dialog, which) -> {
                    String message = text1.getText().toString();

                    SharedPreferences.Editor editor = getSharedPreferences("Data", MODE_PRIVATE).edit();
                    editor.putString("anticlock", message);
                    editor.apply();

                    AntiClockRequestCode.setText(message);
                });

                builder.show();
            }
        });

        clock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //layout for alert box
                LinearLayout layout = new LinearLayout(SettingsActivity.this);
                layout.setOrientation(LinearLayout.VERTICAL);

                //pixel calc for alert box
                int paddingInPx = (int) (15 * getResources().getDisplayMetrics().density); // 20dp converted to pixels
                layout.setPadding(paddingInPx, paddingInPx, paddingInPx, paddingInPx);

                //edit text for alertbox
                EditText text1 = new EditText(SettingsActivity.this);
                text1.setHint("Enter new code here");
                layout.addView(text1);

                //alert box
                MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(SettingsActivity.this);
                builder.setTitle("Edit Code");
                builder.setView(layout);
                builder.setNegativeButton("Cancel", (dialog, which) -> dialog.dismiss());

                builder.setPositiveButton("Confirm", (dialog, which) -> {
                    String message = text1.getText().toString();

                    SharedPreferences.Editor editor = getSharedPreferences("Data", MODE_PRIVATE).edit();
                    editor.putString("clock", message);
                    editor.apply();

                    ClockRequestCode.setText(message);
                });

                builder.show();
            }
        });

        s1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //layout for alert box
                LinearLayout layout = new LinearLayout(SettingsActivity.this);
                layout.setOrientation(LinearLayout.VERTICAL);

                //pixel calc for alert box
                int paddingInPx = (int) (15 * getResources().getDisplayMetrics().density); // 20dp converted to pixels
                layout.setPadding(paddingInPx, paddingInPx, paddingInPx, paddingInPx);

                //edit text for alertbox
                EditText text1 = new EditText(SettingsActivity.this);
                text1.setHint("Enter new code here");
                layout.addView(text1);

                //alert box
                MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(SettingsActivity.this);
                builder.setTitle("Edit Code");
                builder.setView(layout);
                builder.setNegativeButton("Cancel", (dialog, which) -> dialog.dismiss());

                builder.setPositiveButton("Confirm", (dialog, which) -> {
                    String message = text1.getText().toString();

                    SharedPreferences.Editor editor = getSharedPreferences("Data", MODE_PRIVATE).edit();
                    editor.putString("s1", message);
                    editor.apply();

                    s1RequestCode.setText(message);
                });

                builder.show();
            }
        });

        s2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //layout for alert box
                LinearLayout layout = new LinearLayout(SettingsActivity.this);
                layout.setOrientation(LinearLayout.VERTICAL);

                //pixel calc for alert box
                int paddingInPx = (int) (15 * getResources().getDisplayMetrics().density); // 20dp converted to pixels
                layout.setPadding(paddingInPx, paddingInPx, paddingInPx, paddingInPx);

                //edit text for alertbox
                EditText text1 = new EditText(SettingsActivity.this);
                text1.setHint("Enter new code here");
                layout.addView(text1);

                //alert box
                MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(SettingsActivity.this);
                builder.setTitle("Edit Code");
                builder.setView(layout);
                builder.setNegativeButton("Cancel", (dialog, which) -> dialog.dismiss());

                builder.setPositiveButton("Confirm", (dialog, which) -> {
                    String message = text1.getText().toString();

                    SharedPreferences.Editor editor = getSharedPreferences("Data", MODE_PRIVATE).edit();
                    editor.putString("s2", message);
                    editor.apply();

                    s2RequestCode.setText(message);
                });

                builder.show();
            }
        });

        s3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //layout for alert box
                LinearLayout layout = new LinearLayout(SettingsActivity.this);
                layout.setOrientation(LinearLayout.VERTICAL);

                //pixel calc for alert box
                int paddingInPx = (int) (15 * getResources().getDisplayMetrics().density); // 20dp converted to pixels
                layout.setPadding(paddingInPx, paddingInPx, paddingInPx, paddingInPx);

                //edit text for alertbox
                EditText text1 = new EditText(SettingsActivity.this);
                text1.setHint("Enter new code here");
                layout.addView(text1);

                //alert box
                MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(SettingsActivity.this);
                builder.setTitle("Edit Code");
                builder.setView(layout);
                builder.setNegativeButton("Cancel", (dialog, which) -> dialog.dismiss());

                builder.setPositiveButton("Confirm", (dialog, which) -> {
                    String message = text1.getText().toString();

                    SharedPreferences.Editor editor = getSharedPreferences("Data", MODE_PRIVATE).edit();
                    editor.putString("s3", message);
                    editor.apply();

                    s3RequestCode.setText(message);
                });

                builder.show();
            }
        });

        s4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //layout for alert box
                LinearLayout layout = new LinearLayout(SettingsActivity.this);
                layout.setOrientation(LinearLayout.VERTICAL);

                //pixel calc for alert box
                int paddingInPx = (int) (15 * getResources().getDisplayMetrics().density); // 20dp converted to pixels
                layout.setPadding(paddingInPx, paddingInPx, paddingInPx, paddingInPx);

                //edit text for alertbox
                EditText text1 = new EditText(SettingsActivity.this);
                text1.setHint("Enter new code here");
                layout.addView(text1);

                //alert box
                MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(SettingsActivity.this);
                builder.setTitle("Edit Code");
                builder.setView(layout);
                builder.setNegativeButton("Cancel", (dialog, which) -> dialog.dismiss());

                builder.setPositiveButton("Confirm", (dialog, which) -> {
                    String message = text1.getText().toString();

                    SharedPreferences.Editor editor = getSharedPreferences("Data", MODE_PRIVATE).edit();
                    editor.putString("s4", message);
                    editor.apply();

                    s4RequestCode.setText(message);
                });

                builder.show();
            }
        });

        s5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //layout for alert box
                LinearLayout layout = new LinearLayout(SettingsActivity.this);
                layout.setOrientation(LinearLayout.VERTICAL);

                //pixel calc for alert box
                int paddingInPx = (int) (15 * getResources().getDisplayMetrics().density); // 20dp converted to pixels
                layout.setPadding(paddingInPx, paddingInPx, paddingInPx, paddingInPx);

                //edit text for alertbox
                EditText text1 = new EditText(SettingsActivity.this);
                text1.setHint("Enter new code here");
                layout.addView(text1);

                //alert box
                MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(SettingsActivity.this);
                builder.setTitle("Edit Code");
                builder.setView(layout);
                builder.setNegativeButton("Cancel", (dialog, which) -> dialog.dismiss());

                builder.setPositiveButton("Confirm", (dialog, which) -> {
                    String message = text1.getText().toString();

                    SharedPreferences.Editor editor = getSharedPreferences("Data", MODE_PRIVATE).edit();
                    editor.putString("s5", message);
                    editor.apply();

                    s5RequestCode.setText(message);
                });

                builder.show();
            }
        });



        SharedPreferences editor = getSharedPreferences("Data", MODE_PRIVATE);
        String topText = editor.getString("top", "Select Code for Top");
        String bottomText = editor.getString("bottom", "Select Code for Bottom");
        String leftText = editor.getString("left", "Select Code for Left");
        String rightText = editor.getString("right", "Select Code for Right");
        String stopText = editor.getString("stop", "Select Code for Stop");
        String clockText = editor.getString("clock", "Select Code for Clockwise");
        String AclockText = editor.getString("anticlock", "Select Code for AntiClockwise");
        String s1Text = editor.getString("s1", "Select Code for Speed 1");
        String s2Text = editor.getString("s2", "Select Code for Speed 2");
        String s3Text = editor.getString("s3", "Select Code for Speed 3");
        String s4Text = editor.getString("s4", "Select Code for Speed 4");
        String s5Text = editor.getString("s5", "Select Code for Speed 5");

        TopRequestCode.setText(topText);
        LeftRequestCode.setText(leftText);
        RightRequestCode.setText(rightText);
        BottomRequestCode.setText(bottomText);
        StopRequestCode.setText(stopText);
        ClockRequestCode.setText(clockText);
        AntiClockRequestCode.setText(AclockText);
        s1RequestCode.setText(s1Text);
        s2RequestCode.setText(s2Text);
        s3RequestCode.setText(s3Text);
        s4RequestCode.setText(s4Text);
        s5RequestCode.setText(s5Text);


    }


    private void logoutUser() {
        try {
            auth.signOut(); // Sign out the user
            Toast.makeText(SettingsActivity.this, "Logged out successfully", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(SettingsActivity.this, LoginActivity.class)); // Redirect to LoginActivity
            finish(); // Close current activity
        } catch (Exception e) {
            Toast.makeText(SettingsActivity.this, "Logout failed. Please try again.", Toast.LENGTH_SHORT).show();
        }
    }
}