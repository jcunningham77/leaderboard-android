package org.example.jeffcunningham.fooseballleaderboard.repository.comparator;

import org.example.jeffcunningham.fooseballleaderboard.bo.Player;

import java.util.Comparator;
/*
    We will return the player list from best to least. (i.e., most wins and/ or games played will return at the beginning of the list
 */
public class MatchesPlayedComparator implements Comparator<Player> {



    @Override
    public int compare(Player player1, Player player2) {
        if (player1.matchesPlayed >player2.matchesPlayed){
            return -1;
        } else if (player2.matchesPlayed >player1.matchesPlayed) {
            return 1;
        } else {
            return 0;
        }
    }
}
