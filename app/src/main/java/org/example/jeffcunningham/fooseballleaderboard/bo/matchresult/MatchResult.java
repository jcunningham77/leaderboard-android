
package org.example.jeffcunningham.fooseballleaderboard.bo.matchresult;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MatchResult {

  @SerializedName("winner")
  @Expose
  private Winner winner;
  @SerializedName("loser")
  @Expose
  private Loser loser;

  public Winner getWinner() {
    return winner;
  }

  public void setWinner(Winner winner) {
    this.winner = winner;
  }

  public Loser getLoser() {
    return loser;
  }

  public void setLoser(Loser loser) {
    this.loser = loser;
  }

}
