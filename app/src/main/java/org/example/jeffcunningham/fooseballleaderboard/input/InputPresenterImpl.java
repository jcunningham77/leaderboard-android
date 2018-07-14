package org.example.jeffcunningham.fooseballleaderboard.input;

import org.example.jeffcunningham.fooseballleaderboard.bo.Match;
import org.example.jeffcunningham.fooseballleaderboard.repository.RankingsRepository;

import javax.inject.Inject;

public class InputPresenterImpl implements InputPresenter {

    @Inject
    RankingsRepository rankingsRepository;

    @Inject
    public InputPresenterImpl() {
    }

    @Override
    public void recordMatch(Match match) {

        rankingsRepository.inputMatch(match);

    }
}
