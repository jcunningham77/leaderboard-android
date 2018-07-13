package org.example.jeffcunningham.fooseballleaderboard.leaderboard;

import org.example.jeffcunningham.fooseballleaderboard.bo.Player;

import java.util.List;

import javax.inject.Inject;

public class LeaderBoardPresenterImpl implements LeaderBoardPresenter {

    @Inject
    public LeaderBoardPresenterImpl() {
    }

    @Override
    public List<Player> getLeaderBoardData(String sortType) {
        return null;
    }
}
