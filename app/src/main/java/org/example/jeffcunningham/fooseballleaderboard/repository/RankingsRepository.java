package org.example.jeffcunningham.fooseballleaderboard.repository;

import org.example.jeffcunningham.fooseballleaderboard.bo.Match;
import org.example.jeffcunningham.fooseballleaderboard.bo.Player;

import java.util.List;

public interface RankingsRepository {

    List<Player> getRankings(String sortType);

    void inputMatch(Match match);
}
