package com.example.remotecontrol;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class StartActivity extends AppCompatActivity {

    CardView crd1, crd2, crd3, crd4, crd5, crd6, crd7, crd8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        crd1=findViewById(R.id.cardView1);
        crd2=findViewById(R.id.cardView2);
        crd3=findViewById(R.id.cardView3);
        crd4=findViewById(R.id.cardView4);
        crd5=findViewById(R.id.cardView5);
        crd6=findViewById(R.id.cardView6);


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

        crd5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StartActivity.this,AllTeamsActivity.class));
            }
        });

        crd6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StartActivity.this,AnnouncementActivity.class));
            }
        });

    }
}