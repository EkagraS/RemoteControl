package com.example.remotecontrol;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SettingsActivity extends AppCompatActivity {

    ImageView top, bottom, left, right;
    TextView TopRequestCode, BottomRequestCode, LeftRequestCode, RightRequestCode;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        top=findViewById(R.id.EditOptionTop);
        bottom=findViewById(R.id.EditOptionBottom);
        left=findViewById(R.id.EditOptionLeft);
        right=findViewById(R.id.EditOptionRight);
        TopRequestCode=findViewById(R.id.topRequestCode);
        BottomRequestCode=findViewById(R.id.bottomRequestCode);
        LeftRequestCode=findViewById(R.id.leftRequestCode);
        RightRequestCode=findViewById(R.id.rightRequestCode);

        top.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(SettingsActivity.this);
                dialog.setContentView(R.layout.edit_option_dialog_box);
                dialog.show();

                EditText text1;
                Button confirm;

                text1=dialog.findViewById(R.id.editTextText);
                confirm=dialog.findViewById(R.id.button);

                confirm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String message=text1.getText().toString();

                        SharedPreferences.Editor editor=getSharedPreferences("Data", MODE_PRIVATE).edit();
                        editor.putString("top",message);
                        editor.apply();
                        TopRequestCode.setText(message);
                        dialog.dismiss();
                    }
                });
            }
        });

        bottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(SettingsActivity.this);
                dialog.setContentView(R.layout.edit_option_dialog_box);
                dialog.show();

                EditText text1;
                Button confirm;

                text1=dialog.findViewById(R.id.editTextText);
                confirm=dialog.findViewById(R.id.button);

                confirm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String message=text1.getText().toString();

                        SharedPreferences.Editor editor=getSharedPreferences("Data", MODE_PRIVATE).edit();
                        editor.putString("bottom",message);
                        editor.apply();
                        BottomRequestCode.setText(message);
                        dialog.dismiss();
                    }
                });
            }
        });

        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(SettingsActivity.this);
                dialog.setContentView(R.layout.edit_option_dialog_box);
                dialog.show();

                EditText text1;
                Button confirm;

                text1=dialog.findViewById(R.id.editTextText);
                confirm=dialog.findViewById(R.id.button);

                confirm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String message=text1.getText().toString();

                        SharedPreferences.Editor editor=getSharedPreferences("Data", MODE_PRIVATE).edit();
                        editor.putString("left",message);
                        editor.apply();
                        LeftRequestCode.setText(message);
                        dialog.dismiss();
                    }
                });
            }
        });

        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(SettingsActivity.this);
                dialog.setContentView(R.layout.edit_option_dialog_box);
                dialog.show();

                EditText text1;
                Button confirm;

                text1=dialog.findViewById(R.id.editTextText);
                confirm=dialog.findViewById(R.id.button);

                confirm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String message=text1.getText().toString();

                        SharedPreferences.Editor editor=getSharedPreferences("Data", MODE_PRIVATE).edit();
                        editor.putString("right",message);
                        editor.apply();
                        RightRequestCode.setText(message);
                        dialog.dismiss();
                    }
                });
            }
        });

        SharedPreferences editor=getSharedPreferences("Data", MODE_PRIVATE);
        String topText=editor.getString("top", "");
        String bottomText=editor.getString("bottom", "");
        String leftText=editor.getString("left", "");
        String rightText=editor.getString("right", "");

        TopRequestCode.setText(topText);
        LeftRequestCode.setText(leftText);
        RightRequestCode.setText(rightText);
        BottomRequestCode.setText(bottomText);

    }
}