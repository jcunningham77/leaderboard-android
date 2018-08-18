package org.example.jeffcunningham.fooseballleaderboard.input;

import org.example.jeffcunningham.fooseballleaderboard.bo.Match;
import org.example.jeffcunningham.fooseballleaderboard.repository.RemoteRankingsRepository;
import org.example.jeffcunningham.fooseballleaderboard.repository.RemoteRankingsRepositoryImpl;
import org.example.jeffcunningham.fooseballleaderboard.util.Logger;

import javax.inject.Inject;

public class InputPresenterImpl implements InputPresenter {


    RemoteRankingsRepository rankingsRepository;
    Logger logger;

    private static final String TAG = "InputPresenterImpl";

    @Inject
    public InputPresenterImpl(RemoteRankingsRepositoryImpl remoteRankingsRepositoryImpl, Logger logger) {
        this.rankingsRepository = remoteRankingsRepositoryImpl;
        this.logger = logger;

    }

    @Override
    public void recordMatch(Match match) {

        rankingsRepository.inputMatchObservable(match).subscribe(matchResult -> logger.info(TAG,"Consuming item " + matchResult),e->logger.error(TAG,e.getMessage()));




    }
}
