package org.example.jeffcunningham.fooseballleaderboard.bo;

public class Player {

    public Player(String name, int gamesPlayed, int gamesWon) {
        this.gamesPlayed = gamesPlayed;
        this.gamesWon = gamesWon;
        this.name = name;
    }

    public int gamesPlayed;
    public int gamesWon;
    public String name;

}
