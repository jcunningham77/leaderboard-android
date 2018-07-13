package org.example.jeffcunningham.fooseballleaderboard.di;

import android.app.Application;

import org.example.jeffcunningham.fooseballleaderboard.MainApplication;
import org.example.jeffcunningham.fooseballleaderboard.repository.RankingsRepository;
import org.example.jeffcunningham.fooseballleaderboard.util.Logger;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    void inject(MainApplication baseApplication);
    Application application();

    //seems like we need these available to use the @Inject at field level

    Logger logger();

    RankingsRepository rankingRepository();





}
