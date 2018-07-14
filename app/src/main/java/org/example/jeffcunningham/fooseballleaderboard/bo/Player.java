package org.example.jeffcunningham.fooseballleaderboard.bo;

public class Player {

    public Player(String name, int matchesPlayed, int matchesWon) {
        this.matchesPlayed = matchesPlayed;
        this.matchesWon = matchesWon;
        this.name = name;
    }

    public int matchesPlayed;
    public int matchesWon;
    public String name;

}
