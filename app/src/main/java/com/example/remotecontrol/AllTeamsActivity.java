package com.example.remotecontrol;

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

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class AllTeamsActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    TeamAdaptor teamAdaptor;
    List<TeamData> teamDataList;

    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_teams);

        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        teamDataList=new ArrayList<>();
        teamAdaptor=new TeamAdaptor(teamDataList);
        recyclerView.setAdapter(teamAdaptor);

        databaseReference= FirebaseDatabase.getInstance().getReference("Teams");
        fetchTeamsFromFirebase();

    }

    private void fetchTeamsFromFirebase() {
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                teamDataList.clear();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    TeamData data = dataSnapshot.getValue(TeamData.class);
                    if(data!=null) {
                        teamDataList.add(data);
                    }
                }
                teamAdaptor.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e("Firebase Error", "Failed to read data", error.toException());
            }
        });
    }

}