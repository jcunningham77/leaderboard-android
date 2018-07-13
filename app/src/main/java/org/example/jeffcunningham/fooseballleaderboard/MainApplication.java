package org.example.jeffcunningham.fooseballleaderboard;

import android.app.Application;

import org.example.jeffcunningham.fooseballleaderboard.di.ApplicationComponent;
import org.example.jeffcunningham.fooseballleaderboard.di.ApplicationModule;
import org.example.jeffcunningham.fooseballleaderboard.di.DaggerApplicationComponent;

public class MainApplication extends Application {

    private ApplicationComponent applicationComponent;

    private static final String TAG = "BaseApplication";
    @Override
    public void onCreate() {
        super.onCreate();


        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
