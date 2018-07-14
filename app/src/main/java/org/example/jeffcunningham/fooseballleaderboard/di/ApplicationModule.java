package org.example.jeffcunningham.fooseballleaderboard.di;

import android.app.Application;
import android.content.Context;

import org.example.jeffcunningham.fooseballleaderboard.di.annotations.ApplicationContext;
import org.example.jeffcunningham.fooseballleaderboard.repository.RankingsRepository;
import org.example.jeffcunningham.fooseballleaderboard.repository.RankingsRepositoryImpl;
import org.example.jeffcunningham.fooseballleaderboard.util.Logger;
import org.example.jeffcunningham.fooseballleaderboard.util.LoggerImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by jeffcunningham on 1/22/17.
 */
@Module
public class ApplicationModule {

    private final Application application;
    private Context context;

    public ApplicationModule(Application application) {
        this.application = application;
        this.context = application.getApplicationContext();
    }

    /**
     * Expose the application to the graph.
     */
    @Provides
    @Singleton
    Application application() {
        return application;
    }

    @Provides
    @ApplicationContext
    public Context provideApplicationContext(){
        return context;
    }


    @Provides
    Logger provideLogger(LoggerImpl impl){
        return impl;
    }

    @Provides
    @Singleton
    RankingsRepository provideRankingsRepository(RankingsRepositoryImpl impl){return impl;}

}
