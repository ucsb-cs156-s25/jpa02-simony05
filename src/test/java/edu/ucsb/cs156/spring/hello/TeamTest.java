package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }
   
    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void equals_returns_correct_boolean() {
        team.addMember("Simon");

        // Case 1: same object
        assertEquals(team.equals(team), true);

        // Case 2: different object
        String name = "a";
        assertEquals(team.equals(name), false);

        // Case 3: different objects of team

        // Case 3.1: name same & members same
        Team team1 = new Team("test-team");
        team1.addMember("Simon");
        assertEquals(team.equals(team), true);

        // Case 3.2: name different & members same
        Team team2 = new Team("test-team2");
        team2.addMember("Simon");
        assertEquals(team.equals(team2), false);

        // Case 3.3: name same & members different
        Team team3 = new Team("test-team");
        team3.addMember("Yan");
        assertEquals(team.equals(team3), false);

        // Case 3.4: name different & members different
        Team team4 = new Team("test-team2");
        team4.addMember("Yan");
        assertEquals(team.equals(team4), false);
    }

    @Test
    public void hashCode_returns_correct_boolean() {
        // instantiate t as a Team object
        int result = team.hashCode();
        int expectedResult = -1226298695;
        assertEquals(expectedResult, result);
    }

}
