package com.example.remotecontrol;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class MainActivity extends AppCompatActivity {

    ImageView top, bottom, left, right, clockwise, anticlockwise, stop;
    Button speed1, speed2, speed3, speed4, speed5;
    private CarApiService service;

    private OkHttpClient client = new OkHttpClient.Builder()
            .build();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String baseUrl = "http://192.168.4.1/"; // Can be dynamic from user input or preferences
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .build();
        service = retrofit.create(CarApiService.class);

        ConnectivityManager connManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkRequest.Builder builder = new NetworkRequest.Builder();
        builder.addTransportType(NetworkCapabilities.TRANSPORT_WIFI);
        builder.addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET);
        NetworkRequest request = builder.build();


        connManager.requestNetwork(request, new ConnectivityManager.NetworkCallback() {
            @Override
            public void onAvailable(android.net.Network network) {
                super.onAvailable(network);

                connManager.bindProcessToNetwork(network);

                String baseUrl = "http://192.168.4.1/"; // Can be dynamic from user input or preferences
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(baseUrl)
                        .build();
                service = retrofit.create(CarApiService.class);

            }

            @Override
            public void onUnavailable() {
                super.onUnavailable();
                // Handle the case when the network is unavailable
                Log.e("Network", "No available network");
            }
        });


        top = findViewById(R.id.imageButtonForward);
        bottom = findViewById(R.id.imageButtonDown);
        left = findViewById(R.id.imageButtonLeft);
        right = findViewById(R.id.imageButtonRight);
        stop = findViewById(R.id.stopButton);
        clockwise = findViewById(R.id.ClockWiseButton);
        anticlockwise = findViewById(R.id.antiClockWiseButton);
        speed1 = findViewById(R.id.speed1);
        speed2 = findViewById(R.id.speed2);
        speed3 = findViewById(R.id.speed3);
        speed4 = findViewById(R.id.speed4);
        speed5 = findViewById(R.id.speed5);


        SharedPreferences editor = getSharedPreferences("Data", MODE_PRIVATE);
        String topText = editor.getString("top", "");
        String bottomText = editor.getString("bottom", "");
        String leftText = editor.getString("left", "");
        String rightText = editor.getString("right", "");
        String stopText = editor.getString("stop", "");
        String clockText = editor.getString("clock", "");
        String AclockText = editor.getString("anticlock", "");
        String s1Text = editor.getString("s1", "");
        String s2Text = editor.getString("s2", "");
        String s3Text = editor.getString("s3", "");
        String s4Text = editor.getString("s4", "");
        String s5Text = editor.getString("s5", "");


        speed1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMoveRequest(s1Text);
            }
        });

        speed2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMoveRequest(s2Text);
            }
        });

        speed3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMoveRequest(s3Text);
            }
        });

        speed4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMoveRequest(s4Text);
            }
        });

        speed5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMoveRequest(s5Text);
            }
        });

        findViewById(R.id.main_back_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        left.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        left.setAlpha(0.6f);
                        sendMoveRequest(leftText);
                        return true;
                    case MotionEvent.ACTION_UP:
                        sendMoveRequest(stopText);
                        left.setAlpha(1.0f);
                        return false;
                }
                return false;
            }
        });

        right.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        right.setAlpha(0.6f);
                        sendMoveRequest(rightText);
                        return true;
                    case MotionEvent.ACTION_UP:
                        right.setAlpha(1.0f);
                        sendMoveRequest(stopText);
                        return false;
                }
                return false;
            }
        });
        top.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        top.setAlpha(0.6f);
                        sendMoveRequest(topText);
                        return true;
                    case MotionEvent.ACTION_UP:
                        top.setAlpha(1.0f);
                        sendMoveRequest(stopText);
                        return false;
                }
                return false;
            }

        });

        bottom.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        bottom.setAlpha(0.6f);
                        sendMoveRequest(bottomText);  // Send "white" when button is pressed
                        return true;
                    case MotionEvent.ACTION_UP:
                        bottom.setAlpha(1.0f);
                        sendMoveRequest(stopText);   // Send "stop" when button is released
                        return true;
                }
                return false;
            }
        });



        clockwise.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        clockwise.setAlpha(0.6f);
                        sendMoveRequest(clockText);  // Send "white" when button is pressed
                        return true;
                    case MotionEvent.ACTION_UP:
                        clockwise.setAlpha(1.0f);
                        sendMoveRequest(stopText);
                        return true;
                }
                return false;
            }
        });

        anticlockwise.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        anticlockwise.setAlpha(0.6f);
                        sendMoveRequest(AclockText);
                        return true;
                    case MotionEvent.ACTION_UP:
                        anticlockwise.setAlpha(1.0f);
                        sendMoveRequest(stopText);
                        return true;
                }
                return false;
            }
        });



        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMoveRequest(stopText);
            }
        });
    }


    private void sendMoveRequest(String cmd) {
        String baseUrl = "http://192.168.4.1/"; // Ensure this matches your RC car's address
        String url = baseUrl + "?dir=" + cmd; // Construct the URL for the move request

        // Create a request
        Request request = new Request.Builder()
                .url(url)
                .header("Connection", "close") // Indicate that the connection should be closed
                .get() // Use GET request
                .build();

        // Execute the request
        client.newCall(request).enqueue(new okhttp3.Callback() {
            @Override
            public void onResponse(@NonNull okhttp3.Call call, @NonNull okhttp3.Response response) throws IOException {
                runOnUiThread(() -> {
                    if (!response.isSuccessful()) {
                        Log.e("Response unsuccessful", response.message());
                        Toast.makeText(MainActivity.this, "Failed: " + response.message(), Toast.LENGTH_SHORT).show();
                    } else {
                        Log.i("Response", "Code: " + response.code());
                    }
                });
                response.close(); // Close the response to avoid leaks
            }

            @Override
            public void onFailure(okhttp3.Call call, IOException e) {
                runOnUiThread(() -> {
                    Log.e("Network Error", e.toString());
                    Toast.makeText(MainActivity.this, "Failed: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                });
            }

        });
    }

    interface CarApiService {
        @GET("/?")
        Call<Void> move(@Query("dir") String direction);
    }


}