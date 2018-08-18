package org.example.jeffcunningham.fooseballleaderboard.di;

import org.example.jeffcunningham.fooseballleaderboard.MainActivity;
import org.example.jeffcunningham.fooseballleaderboard.leaderboard.LeaderBoardFragment;

import dagger.Component;

/**
 * Created by jeffcunningham on 1/23/17.
 */

@ActivityScope
@Component(dependencies = ApplicationComponent.class, modules = MainActivityModule.class)
public interface MainActivityComponent {

  void inject(MainActivity activity);

  void inject(LeaderBoardFragment fragment);


}
