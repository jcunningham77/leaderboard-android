package org.example.jeffcunningham.fooseballleaderboard.leaderboard;

import android.app.Dialog;
import io.reactivex.Single;
import java.util.List;
import javax.inject.Inject;
import org.example.jeffcunningham.fooseballleaderboard.bo.Player;
import org.example.jeffcunningham.fooseballleaderboard.repository.RemoteRankingsRepository;
import org.example.jeffcunningham.fooseballleaderboard.util.DialogProvider;
import org.example.jeffcunningham.fooseballleaderboard.util.Logger;
import org.example.jeffcunningham.fooseballleaderboard.util.SnackbarPresenter;

public class LeaderBoardPresenterImpl implements LeaderBoardPresenter {

  private static final String TAG = "LeaderBoardPresenterImp";

  private DialogProvider dialogProvider;
  private RemoteRankingsRepository rankingsRepository;
  private Logger logger;
  private SnackbarPresenter snackbarPresenter;

  @Inject
  public LeaderBoardPresenterImpl(RemoteRankingsRepository rankingsRepository, Logger logger,
      DialogProvider dialogProvider, SnackbarPresenter snackbarPresenter) {
    this.rankingsRepository = rankingsRepository;
    this.logger = logger;
    this.dialogProvider = dialogProvider;
    this.snackbarPresenter = snackbarPresenter;
  }

  @Override
  public Single<List<Player>> getLeaderBoardData(String sortType) {
    logger.info(TAG, "getLeaderBoardData() called with: sortType = [" + sortType + "]");
    return rankingsRepository.getRankings(sortType);
  }

  public void inputMatch() {
    final Dialog alert = dialogProvider.provideMatchInputDialog(match -> {
      rankingsRepository.inputMatchObservable(match)
          .subscribe(
              matchResult -> {
                logger.info(TAG, "inputMatch: match result = " + matchResult);
                String message = "Congrats " + matchResult.getWinner().getName() + ", sorry " + matchResult.getLoser().getName();
                snackbarPresenter.showSnackBar(message);
              }, Throwable::printStackTrace);


    });
    alert.show();
  }
}
