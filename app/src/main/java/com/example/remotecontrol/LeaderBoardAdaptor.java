package com.example.remotecontrol;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class LeaderBoardAdaptor extends RecyclerView.Adapter<LeaderBoardAdaptor.ViewHolder> {

    private List<LeaderBoardData> leaderBoardDataList;

    public LeaderBoardAdaptor(List<LeaderBoardData> leaderBoardDataList) {
        this.leaderBoardDataList = leaderBoardDataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.leaderboard_box, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        LeaderBoardData data=leaderBoardDataList.get(position);
        holder.TeamName.setText(data.getTeamName());
        holder.MentorName.setText(data.getMentorName());
        holder.LeaderName.setText(data.getLeaderName());
        holder.TimeTaken.setText(data.getTimeTaken());

        if(position==0){
            holder.cv.setCardBackgroundColor(Color.parseColor("#F2BF20"));// Gold color
        } else if (position==1) {
            holder.cv.setCardBackgroundColor(Color.parseColor("#C0C0C0"));// Silver color
        } else if (position==2) {
            holder.cv.setCardBackgroundColor(Color.parseColor("#CD7F32"));// Bronze color
        }
    }

    @Override
    public int getItemCount() {
        return leaderBoardDataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView TeamName, MentorName, LeaderName, TimeTaken;
        CardView cv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            TeamName = itemView.findViewById(R.id.textView1);
            MentorName = itemView.findViewById(R.id.textView2);
            LeaderName = itemView.findViewById(R.id.textView3);
            TimeTaken = itemView.findViewById(R.id.textView4);
            cv=itemView.findViewById(R.id.cv);
        }
    }
}
