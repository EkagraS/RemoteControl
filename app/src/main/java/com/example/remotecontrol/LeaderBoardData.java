package com.example.remotecontrol;

public class LeaderBoardData {
    String teamName, mentorName, leaderName, timeTaken;

    public LeaderBoardData(String leaderName, String mentorName, String teamName, String timeTaken) {
        this.leaderName = leaderName;
        this.mentorName = mentorName;
        this.teamName = teamName;
        this.timeTaken = timeTaken;
    }

    public LeaderBoardData() {}

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

    public String getTimeTaken() {
        return timeTaken;
    }

    public void setTimeTaken(String timeTaken) {
        this.timeTaken = timeTaken;
    }
}
