package org.example.jeffcunningham.fooseballleaderboard.repository;

import org.example.jeffcunningham.fooseballleaderboard.bo.Match;
import org.example.jeffcunningham.fooseballleaderboard.bo.Player;
import org.example.jeffcunningham.fooseballleaderboard.bo.matchresult.MatchResult;
import org.example.jeffcunningham.fooseballleaderboard.repository.api.RankingsAPI;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class RemoteRankingsRepositoryImpl implements RemoteRankingsRepository {


  @Inject
  RankingsAPI rankingsAPI;

  @Inject
  public RemoteRankingsRepositoryImpl() {

  }

  @Override
  public Single<List<Player>> getRankings(String sortType) {
    return rankingsAPI.getRankings().subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread());
  }

  @Override
  public Single<MatchResult> inputMatchObservable(Match match) {
    return rankingsAPI.saveMatch(match).subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread());

  }

}
