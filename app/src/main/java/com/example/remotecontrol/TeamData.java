package com.example.remotecontrol;

public class TeamData {
    String teamName, mentorName, leaderName;

    public TeamData(String leaderName, String mentorName, String teamName) {
        this.leaderName = leaderName;
        this.mentorName = mentorName;
        this.teamName = teamName;
    }

    public TeamData() {}

    public String getLeaderName() {
        return leaderName;
    }

    public void setLeaderName(String leaderName) {
        this.leaderName = leaderName;
    }

    public String getMentorName() {
        return mentorName;
    }

    public void setMentorName(String mentorName) {
        this.mentorName = mentorName;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

}
