
package org.example.jeffcunningham.fooseballleaderboard.bo.matchresult;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Winner {

  @SerializedName("_id")
  @Expose
  private String id;
  @SerializedName("name")
  @Expose
  private String name;
  @SerializedName("__v")
  @Expose
  private Integer v;
  @SerializedName("matchesPlayed")
  @Expose
  private Integer matchesPlayed;
  @SerializedName("matchesWon")
  @Expose
  private Integer matchesWon;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getV() {
    return v;
  }

  public void setV(Integer v) {
    this.v = v;
  }

  public Integer getMatchesPlayed() {
    return matchesPlayed;
  }

  public void setMatchesPlayed(Integer matchesPlayed) {
    this.matchesPlayed = matchesPlayed;
  }

  public Integer getMatchesWon() {
    return matchesWon;
  }

  public void setMatchesWon(Integer matchesWon) {
    this.matchesWon = matchesWon;
  }

}
