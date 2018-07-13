package org.example.jeffcunningham.fooseballleaderboard.repository;

import org.example.jeffcunningham.fooseballleaderboard.bo.Match;
import org.example.jeffcunningham.fooseballleaderboard.bo.Player;
import org.example.jeffcunningham.fooseballleaderboard.repository.comparator.MatchesPlayedComparator;
import org.example.jeffcunningham.fooseballleaderboard.repository.comparator.MatchesWonComparator;
import org.example.jeffcunningham.fooseballleaderboard.repository.comparator.PowerRankingsSortComparator;
import org.example.jeffcunningham.fooseballleaderboard.util.Constants;
import org.example.jeffcunningham.fooseballleaderboard.util.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;


//todo move to Android library
public class RankingsRepositoryImpl implements RankingsRepository {


    private static final String TAG = "RankingsRepositoryImpl";
    List<Player> playerList;

    @Inject
    Logger logger;

    @Inject
    public RankingsRepositoryImpl() {

        playerList = new ArrayList<Player>();
        playerList.add(new Player("Diego",8,5));
        playerList.add(new Player("Amos",12,5));
        playerList.add(new Player("Joel",3,2));
        playerList.add(new Player("Tim",5,2));


    }

    @Override
    public List<Player> getRankings(String sortType) {
        logger.info(TAG, "getRankings() called with: sortType = [" + sortType + "]");

        switch (sortType){
            case Constants.SORT_POWER_RANKING:
                Collections.sort(playerList, new PowerRankingsSortComparator());
                break;
            case Constants.SORT_MATCHES_PLAYED:
                Collections.sort(playerList, new MatchesPlayedComparator());
                break;
            case Constants.SORT_MATCHES_WON:
                Collections.sort(playerList, new MatchesWonComparator());
                break;
        }


        return playerList;
    }

    @Override
    public void inputMatch(Match match) {

    }


}
