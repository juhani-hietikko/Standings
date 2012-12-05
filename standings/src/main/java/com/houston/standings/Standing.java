package com.houston.standings;

import java.util.ArrayList;
import java.util.List;

public class Standing {
    ArrayList<StandingsTableRow> tableRows = new ArrayList<StandingsTableRow>();

    public void addResults(String team1, String team2, int goals1, int goals2) {
        StandingsTableRow tableRow1 = findOrCreateTableRow(team1);
        StandingsTableRow tableRow2 = findOrCreateTableRow(team2);
        
        if (goals1 > goals2) {
            tableRow1.addPoints(3);
        } else if (goals2 > goals1) {
            tableRow2.addPoints(3);
        } else {
            tableRow1.addPoints(1);
            tableRow2.addPoints(1);
        }
        
    }

    private StandingsTableRow findOrCreateTableRow(String team) {
        StandingsTableRow tableRow = null;
        for (StandingsTableRow row : tableRows) {
            if (row.getTeam().equals(team)) {
                tableRow = row;
            }
        }
        if (tableRow == null) {
            tableRow = new StandingsTableRow(team);
            tableRows.add(tableRow);
        }
        return tableRow;
    }

    public List<StandingsTableRow> getStandingsTable() {
        return tableRows;
    }

}
