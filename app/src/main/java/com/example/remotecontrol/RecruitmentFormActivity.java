package com.example.remotecontrol;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class RecruitmentFormActivity extends AppCompatActivity {

    EditText txt1,txt2,txt3,txt4;
    Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recruitment_form);

        submit=findViewById(R.id.button);
        txt1=findViewById(R.id.editTextText1);
        txt2=findViewById(R.id.editTextText2);
        txt3=findViewById(R.id.editTextText3);
        txt4=findViewById(R.id.editTextText4);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=txt1.getText().toString();
                String phone=txt2.getText().toString();
                String email=txt3.getText().toString();
                String reason=txt4.getText().toString();
                String domain="GD";
                saveData(name,phone,email,reason, domain);
            }
        });

    }

    // id=AKfycbyDWk0v0ydkeo7WbtqqiKg3FL8NKSm1jS9uAzFdiQnxn7-E5UVAtVivSaxbQKrcUKAL
    private void saveData(String name, String phone, String email, String reason, String domain) {
        String url="https://script.google.com/macros/s/AKfycbzOoT5ACN6uubpMPAe1qoXWPV2pW4cli73rs-SAqlGQ5P_AG4Fu1cT7_bpqsxko_UzP/exec";
        url=url+"action=create&name="+name+"&phone="+phone+"&email="+email+"&reason="+reason+"&domain="+domain;

        StringRequest stringRequest=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(),response, Toast.LENGTH_SHORT).show();
                Log.d("SUCcESS", response);
            }
        },new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),error.toString(), Toast.LENGTH_SHORT).show();
                Log.e("REQUEST ERROR", error.toString());
            }
        });

        RequestQueue queue= Volley.newRequestQueue(this);
        queue.add(stringRequest);
    }
}