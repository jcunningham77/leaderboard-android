package org.example.jeffcunningham.fooseballleaderboard.di;

import android.support.v7.app.AppCompatActivity;

import org.example.jeffcunningham.fooseballleaderboard.MainActivity;
import org.example.jeffcunningham.fooseballleaderboard.leaderboard.LeaderBoardPresenter;
import org.example.jeffcunningham.fooseballleaderboard.leaderboard.LeaderBoardPresenterImpl;
import org.example.jeffcunningham.fooseballleaderboard.util.DialogProvider;
import org.example.jeffcunningham.fooseballleaderboard.util.DialogProviderImpl;

import dagger.Module;
import dagger.Provides;
import org.example.jeffcunningham.fooseballleaderboard.util.SnackbarPresenter;
import org.example.jeffcunningham.fooseballleaderboard.util.SnackbarPresenterImpl;

/**
 * Created by jeffcunningham on 1/23/17.
 */
@Module
public class MainActivityModule {

  private AppCompatActivity appCompatActivity;

  public MainActivityModule(MainActivity activity) {
    this.appCompatActivity = activity;
  }

  @ActivityScope
  @Provides
  public AppCompatActivity provideActivity() {
    return appCompatActivity;
  }

  @Provides
  @ActivityScope
  LeaderBoardPresenter provideLeaderBoardPresenter(LeaderBoardPresenterImpl impl) {
    return impl;
  }

  @Provides
  @ActivityScope
  DialogProvider provideDialogProvider(DialogProviderImpl impl) {
    return impl;
  }

  @Provides
  @ActivityScope
  SnackbarPresenter provideSnackbarPresenter(SnackbarPresenterImpl impl) {
    return impl;
  }


}
