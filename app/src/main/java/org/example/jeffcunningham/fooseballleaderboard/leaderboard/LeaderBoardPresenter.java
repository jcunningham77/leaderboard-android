package org.example.jeffcunningham.fooseballleaderboard.leaderboard;

import org.example.jeffcunningham.fooseballleaderboard.bo.Player;

import java.util.List;

import io.reactivex.Single;

public interface LeaderBoardPresenter {



    Single<List<Player>> getLeaderBoardData(String sortType);
}
