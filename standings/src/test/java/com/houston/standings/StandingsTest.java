package com.houston.standings;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class StandingsTest {
    private Standing standing;
    
    @Before
    public void setUp() {
        standing = new Standing();
    }
    
    @Test
    public void getStandingsTableAfterOneMatch() {
        standing.addResults("Suomi", "Georgia", 3, 0);
        List<StandingsTableRow> standingsTable = standing.getStandingsTable();
        assertEquals(2, standingsTable.size());
    }
    
    @Test
    public void getPointsAfterOneMatch() {
        standing.addResults("Suomi", "Georgia", 3, 0);
        List<StandingsTableRow> standingsTable = standing.getStandingsTable();
        assertEquals(3, standingsTable.get(0).getPoints());
        assertEquals(0, standingsTable.get(1).getPoints());
    }
    
    @Test
    public void getTeamsAfterOneMatch() {
        standing.addResults("Suomi", "Georgia", 3, 0);
        List<StandingsTableRow> standingsTable = standing.getStandingsTable();
        assertEquals("Suomi", standingsTable.get(0).getTeam());
        assertEquals("Georgia", standingsTable.get(1).getTeam());
    }
    
    @Test
    public void getPointsAfterOneMatchIfSecondTeamWins() {
        standing.addResults("Suomi", "Georgia", 0, 3);
        List<StandingsTableRow> standingsTable = standing.getStandingsTable();
        assertEquals(0, standingsTable.get(0).getPoints());
        assertEquals(3, standingsTable.get(1).getPoints());
    }
    
    @Test
    public void getPointsAfterOneDraw() {
        standing.addResults("Suomi", "Georgia", 1, 1);
        List<StandingsTableRow> standingsTable = standing.getStandingsTable();
        assertEquals(1, standingsTable.get(0).getPoints());
        assertEquals(1, standingsTable.get(1).getPoints());
    }
    
    @Test
    public void getPointsAfterTwoGames() {
        standing.addResults("Suomi", "Georgia", 1, 1);
        standing.addResults("Suomi", "Ruotsi", 1, 1);
        List<StandingsTableRow> standingsTable = standing.getStandingsTable();
        assertEquals(3, standingsTable.size());
        assertEquals(2, standingsTable.get(0).getPoints());
        assertEquals(1, standingsTable.get(1).getPoints());
    }

}
