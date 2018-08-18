package org.example.jeffcunningham.fooseballleaderboard.leaderboard;

import org.example.jeffcunningham.fooseballleaderboard.bo.Player;
import org.example.jeffcunningham.fooseballleaderboard.repository.RemoteRankingsRepository;
import org.example.jeffcunningham.fooseballleaderboard.util.Logger;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

public class LeaderBoardPresenterImpl implements LeaderBoardPresenter {

    private static final String TAG = "LeaderBoardPresenterImp";


    RemoteRankingsRepository rankingsRepository;


    Logger logger;

    @Inject
    public LeaderBoardPresenterImpl(RemoteRankingsRepository rankingsRepository, Logger logger) {
        this.rankingsRepository = rankingsRepository;
        this.logger = logger;


    }

    @Override
    public Single<List<Player>> getLeaderBoardData(String sortType) {

        logger.info(TAG, "getLeaderBoardData() called with: sortType = [" + sortType + "]");


        return rankingsRepository.getRankings(sortType);
    }




}
