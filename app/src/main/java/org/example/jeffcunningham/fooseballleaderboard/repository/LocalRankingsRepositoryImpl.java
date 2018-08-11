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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;


//todo move to Android library
public class LocalRankingsRepositoryImpl implements RankingsRepository {


    private static final String TAG = "LocalRankingsRepositoryImpl";
    Map<String,Player> rankingsMap;


    @Inject
    Logger logger;

    @Inject
    public LocalRankingsRepositoryImpl() {

        rankingsMap = new HashMap<>();

        rankingsMap.put("Diego",new Player("Diego",8,5));
        rankingsMap.put("Amos",new Player("Amos",12,5));
        rankingsMap.put("Joel",new Player("Joel",3,2));
        rankingsMap.put("Tim",new Player("Tim",5,2));


    }

    @Override
    public List<Player> getRankings(String sortType) {
        logger.info(TAG, "getRankings() called with: sortType = [" + sortType + "]");

        List<Player> playerList = new ArrayList<>(rankingsMap.values());

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

        //determine if there was a winner
        if(match.player2Score-match.player1Score!=0){
            if(match.player1Score>match.player2Score){
                upsertRankingWithMatchPlayedAndWin(match.player1Name);
                upsertRankingWithMatchPlayed(match.player2Name);
            } else {
                upsertRankingWithMatchPlayedAndWin(match.player2Name);
                upsertRankingWithMatchPlayed(match.player1Name);
            }
        } else {//the match was a tie, so just update the matches played statistic

            upsertRankingWithMatchPlayed(match.player1Name);
            upsertRankingWithMatchPlayed(match.player2Name);

        }

    }



    public void upsertRankingWithMatchPlayed(String playerName){

        if(rankingsMap.containsKey(playerName)){
            Player player = rankingsMap.get(playerName);
            player.matchesPlayed++;
            rankingsMap.put(playerName,player);
        } else {
            rankingsMap.put(playerName,new Player(playerName,1,0));
        }


    }

    public void upsertRankingWithMatchPlayedAndWin(String playerName){

        if(rankingsMap.containsKey(playerName)){
            Player player = rankingsMap.get(playerName);
            player.matchesPlayed++;
            player.matchesWon++;
            rankingsMap.put(playerName,player);
        } else {
            rankingsMap.put(playerName,new Player(playerName,1,1));
        }

    }


}
