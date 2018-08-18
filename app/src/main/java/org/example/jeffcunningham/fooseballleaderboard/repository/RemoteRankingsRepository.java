package org.example.jeffcunningham.fooseballleaderboard.repository;

import org.example.jeffcunningham.fooseballleaderboard.bo.Match;
import org.example.jeffcunningham.fooseballleaderboard.bo.Player;
import org.example.jeffcunningham.fooseballleaderboard.bo.matchresult.MatchResult;

import java.util.List;

import io.reactivex.Single;

public interface RemoteRankingsRepository {
    Single<List<Player>> getRankings(String sortType);

    Single<MatchResult> inputMatchObservable(Match match);
}
