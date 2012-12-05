package com.houston.standings;

public class StandingsTableRow {
    private int points = 0;
    private final String team;
    
    public StandingsTableRow(String team) {
        this.team = team;
    }

    public int getPoints() {
        return points;
    }

    public void addPoints(int points) {
        this.points += points;
        
    }

    public String getTeam() {
        return team;
    }

}
