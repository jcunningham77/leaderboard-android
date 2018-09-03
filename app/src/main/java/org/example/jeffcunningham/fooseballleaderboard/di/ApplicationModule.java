package org.example.jeffcunningham.fooseballleaderboard.di;

import android.app.Application;
import android.content.Context;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import org.example.jeffcunningham.fooseballleaderboard.di.annotations.ApplicationContext;
import org.example.jeffcunningham.fooseballleaderboard.repository.RemoteRankingsRepository;
import org.example.jeffcunningham.fooseballleaderboard.repository.RemoteRankingsRepositoryImpl;
import org.example.jeffcunningham.fooseballleaderboard.util.Logger;
import org.example.jeffcunningham.fooseballleaderboard.util.LoggerImpl;

@Module(includes = APIServiceModule.class)
public class ApplicationModule {

  private final Application application;
  private Context context;

  public ApplicationModule(Application application) {
    this.application = application;
    this.context = application.getApplicationContext();
  }

  @Provides
  @Singleton
  Application application() {
    return application;
  }

  @Provides
  @ApplicationContext
  public Context provideApplicationContext() {
    return context;
  }

  @Provides
  Logger provideLogger(LoggerImpl impl) {
    return impl;
  }

  @Provides
  RemoteRankingsRepository provideRemoteRankingsRepository(RemoteRankingsRepositoryImpl impl) {
    return impl;
  }

}
