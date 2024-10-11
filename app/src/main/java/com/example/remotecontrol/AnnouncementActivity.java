package com.example.remotecontrol;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class AnnouncementActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    AnnouncementAdaptor AnnouncementAdaptor;
    List<AnnouncementData> announcementDataList;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_announcement);


        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        announcementDataList=new ArrayList<>();
        AnnouncementAdaptor=new AnnouncementAdaptor(announcementDataList);
        recyclerView.setAdapter(AnnouncementAdaptor);

        databaseReference= FirebaseDatabase.getInstance().getReference("Announcements");

        fetchTeamsFromFirebase();

    }

    private void fetchTeamsFromFirebase() {
        databaseReference.orderByChild("announcementId").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                announcementDataList.clear();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    AnnouncementData data = dataSnapshot.getValue(AnnouncementData.class);
                    if(data!=null) {
                        announcementDataList.add(data);
                        Log.d("Firebase Data", "Fetched Data: " + data.toString());
                    }
                }
                AnnouncementAdaptor.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e("Firebase Error", "Failed to read data", error.toException());
            }
        });
    }
}