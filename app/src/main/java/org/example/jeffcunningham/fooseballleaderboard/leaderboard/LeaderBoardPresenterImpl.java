package org.example.jeffcunningham.fooseballleaderboard.leaderboard;

import org.example.jeffcunningham.fooseballleaderboard.bo.Player;
import org.example.jeffcunningham.fooseballleaderboard.repository.RankingsRepository;
import org.example.jeffcunningham.fooseballleaderboard.util.Logger;

import java.util.List;

import javax.inject.Inject;

public class LeaderBoardPresenterImpl implements LeaderBoardPresenter {

    private static final String TAG = "LeaderBoardPresenterImp";

    @Inject
    RankingsRepository rankingsRepository;

    @Inject
    Logger logger;

    @Inject
    public LeaderBoardPresenterImpl() {


    }

    @Override
    public List<Player> getLeaderBoardData(String sortType) {

        logger.info(TAG, "getLeaderBoardData() called with: sortType = [" + sortType + "]");

        return rankingsRepository.getRankings(sortType);
    }
}
