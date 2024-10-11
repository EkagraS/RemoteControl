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

public class LeaderBoardActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    LeaderBoardAdaptor leaderBoardAdaptor;
    List<LeaderBoardData> leaderBoardDataList;

    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leader_board);

        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        leaderBoardDataList=new ArrayList<>();
        leaderBoardAdaptor=new LeaderBoardAdaptor(leaderBoardDataList);
        recyclerView.setAdapter(leaderBoardAdaptor);

        databaseReference= FirebaseDatabase.getInstance().getReference("Leaderboard");
        DatabaseReference ref1=databaseReference.child("Team1");
        Log.d("Team 1", ref1.getKey().toString());
        fetchTeamsFromFirebase();

    }

    private void fetchTeamsFromFirebase() {
        DatabaseReference ref=databaseReference.child("timeTaken");
        databaseReference.orderByChild("timeTaken").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                leaderBoardDataList.clear();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    LeaderBoardData data = dataSnapshot.getValue(LeaderBoardData.class);
                    if(data!=null) {
                        leaderBoardDataList.add(data);
                    }
                }
                leaderBoardAdaptor.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e("Firebase Error", "Failed to read data", error.toException());
            }
        });
    }
}