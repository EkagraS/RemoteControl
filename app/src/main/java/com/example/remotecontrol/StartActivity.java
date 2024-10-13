package com.example.remotecontrol;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class StartActivity extends AppCompatActivity {

    ImageView crd1;
    CardView crd2, crd3, crd4, crd6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        crd1=findViewById(R.id.start_controls_img);
        crd2=findViewById(R.id.settings_card);
        crd3=findViewById(R.id.aboutus_card);
        crd4=findViewById(R.id.leaderboard_card);
//        crd5=findViewById(R.id.cardView5);
        crd6=findViewById(R.id.anouncement_card);


        crd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StartActivity.this,MainActivity.class));
            }
        });

        crd2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StartActivity.this,SettingsActivity.class));
            }
        });

        crd3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StartActivity.this,InfoActivity.class));
            }
        });

        crd4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StartActivity.this,LeaderBoardActivity.class));
            }
        });

//        crd5.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(StartActivity.this,AllTeamsActivity.class));
//            }
//        });

        crd6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StartActivity.this,AnnouncementActivity.class));
            }
        });

    }
}