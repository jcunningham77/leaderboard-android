package org.example.jeffcunningham.fooseballleaderboard.di;

import org.example.jeffcunningham.fooseballleaderboard.input.InputPresenter;
import org.example.jeffcunningham.fooseballleaderboard.input.InputPresenterImpl;
import org.example.jeffcunningham.fooseballleaderboard.leaderboard.LeaderBoardPresenter;
import org.example.jeffcunningham.fooseballleaderboard.leaderboard.LeaderBoardPresenterImpl;

import dagger.Module;
import dagger.Provides;

/**
 * Created by jeffcunningham on 1/23/17.
 */
@Module
public class MainModule {

    @Provides
    LeaderBoardPresenter provideLeaderBoardPresenter(LeaderBoardPresenterImpl impl) {
        return impl;
    }

    @Provides
    InputPresenter provideInputPresenter(InputPresenterImpl impl) {
        return impl;
    }


}
