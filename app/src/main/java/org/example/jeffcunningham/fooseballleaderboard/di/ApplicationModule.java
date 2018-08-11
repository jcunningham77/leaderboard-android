package org.example.jeffcunningham.fooseballleaderboard.di;

import android.app.Application;
import android.content.Context;

import org.example.jeffcunningham.fooseballleaderboard.di.annotations.ApplicationContext;
import org.example.jeffcunningham.fooseballleaderboard.repository.LocalRankingsRepositoryImpl;
import org.example.jeffcunningham.fooseballleaderboard.repository.RankingsRepository;
import org.example.jeffcunningham.fooseballleaderboard.util.Logger;
import org.example.jeffcunningham.fooseballleaderboard.util.LoggerImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


@Module(includes = APIServiceModule.class)
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
    RankingsRepository provideRankingsRepository(LocalRankingsRepositoryImpl impl){return impl;}







}
