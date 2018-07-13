package org.example.jeffcunningham.fooseballleaderboard.di;

import org.example.jeffcunningham.fooseballleaderboard.MainActivity;
import org.example.jeffcunningham.fooseballleaderboard.di.annotations.PerActivity;
import org.example.jeffcunningham.fooseballleaderboard.input.InputFragment;
import org.example.jeffcunningham.fooseballleaderboard.leaderboard.LeaderBoardFragment;

import dagger.Component;

/**
 * Created by jeffcunningham on 1/23/17.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class,modules = MainModule.class)
public interface MainComponent {

    void inject(MainActivity activity);
    void inject(LeaderBoardFragment fragment);
    void inject(InputFragment fragment);

}
