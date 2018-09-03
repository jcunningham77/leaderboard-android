package org.example.jeffcunningham.fooseballleaderboard.bo;

public class Match {

  public Match(String player1Name, String player2Name, int player1Score, int player2Score) {
    this.player1Name = player1Name;
    this.player2Name = player2Name;
    this.player1Score = player1Score;
    this.player2Score = player2Score;
  }

  public String player1Name;
  public String player2Name;
  public int player1Score;
  public int player2Score;

  @Override
  public String toString() {
    return "Match{" +
        "player1Name='" + player1Name + '\'' +
        ", player2Name='" + player2Name + '\'' +
        ", player1Score=" + player1Score +
        ", player2Score=" + player2Score +
        '}';
  }
}
