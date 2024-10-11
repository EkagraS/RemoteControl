package com.example.remotecontrol;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AnnouncementAdaptor extends RecyclerView.Adapter<AnnouncementAdaptor.AnnouncementViewHolder> {

    private List<AnnouncementData> announcementDataList;

    public AnnouncementAdaptor(List<AnnouncementData> announcementDataList) {
        this.announcementDataList = announcementDataList;
    }

    @NonNull
    @Override
    public AnnouncementViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.announcement_box,parent,false);
        return new AnnouncementViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AnnouncementViewHolder holder, int position) {
        AnnouncementData data=announcementDataList.get(position);
        holder.announcementSubTitle.setText(data.getAnnouncementSubTitle());
        holder.announcementBody.setText(data.getAnnouncementBody());
    }

    @Override
    public int getItemCount() {
        return announcementDataList.size();
    }

    public class AnnouncementViewHolder extends RecyclerView.ViewHolder {
        TextView announcementBody, announcementSubTitle, announcementTitle;
        public AnnouncementViewHolder(@NonNull View itemView) {
            super(itemView);
            announcementBody = itemView.findViewById(R.id.announcementBody);
            announcementSubTitle = itemView.findViewById(R.id.announcementSubTitle);
        }
    }
}
