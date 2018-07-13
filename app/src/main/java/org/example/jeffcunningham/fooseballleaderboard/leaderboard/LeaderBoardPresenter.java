package org.example.jeffcunningham.fooseballleaderboard.leaderboard;

import org.example.jeffcunningham.fooseballleaderboard.bo.Player;

import java.util.List;

public interface LeaderBoardPresenter {



    List<Player> getLeaderBoardData(String sortType);
}
