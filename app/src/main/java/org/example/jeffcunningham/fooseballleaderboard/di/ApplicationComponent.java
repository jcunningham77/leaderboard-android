package org.example.jeffcunningham.fooseballleaderboard.di;

import dagger.Component;
import javax.inject.Singleton;
import org.example.jeffcunningham.fooseballleaderboard.MainApplication;
import org.example.jeffcunningham.fooseballleaderboard.repository.RemoteRankingsRepository;
import org.example.jeffcunningham.fooseballleaderboard.util.Logger;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    void inject(MainApplication baseApplication);

    Logger logger();

    RemoteRankingsRepository remoteRankingRepository();

}
