package com.example.remotecontrol;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TeamAdaptor extends RecyclerView.Adapter<TeamAdaptor.ViewHolder> {

    private List<TeamData> teamDataList;

    public TeamAdaptor(List<TeamData> teamDataList) {
        this.teamDataList = teamDataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.team_box, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TeamData data=teamDataList.get(position);
        holder.TeamName.setText("Team Name: "+data.getTeamName());
        holder.MentorName.setText("Mentor Name: "+data.getMentorName());
        holder.LeaderName.setText("Team Leader Name: "+data.getLeaderName());
    }

    @Override
    public int getItemCount() {
        return teamDataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView TeamName, MentorName, LeaderName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            TeamName = itemView.findViewById(R.id.textView11);
            MentorName = itemView.findViewById(R.id.textView22);
            LeaderName = itemView.findViewById(R.id.textView33);
        }
    }
}
