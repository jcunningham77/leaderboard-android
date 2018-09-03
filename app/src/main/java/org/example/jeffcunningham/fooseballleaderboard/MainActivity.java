package org.example.jeffcunningham.fooseballleaderboard;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.WindowManager;

import org.example.jeffcunningham.fooseballleaderboard.di.DaggerMainActivityComponent;
import org.example.jeffcunningham.fooseballleaderboard.di.MainActivityComponent;
import org.example.jeffcunningham.fooseballleaderboard.di.MainActivityModule;
import org.example.jeffcunningham.fooseballleaderboard.leaderboard.LeaderBoardFragment;
import org.example.jeffcunningham.fooseballleaderboard.util.Constants;
import org.example.jeffcunningham.fooseballleaderboard.util.Logger;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

  private static final String TAG = "MainActivity";
  private MainActivityComponent component;

  @Inject
  Logger logger;

  /**
   * Build dagger component
   */
  public MainActivityComponent component() {
    if (component == null) {
      component = DaggerMainActivityComponent.builder()
          .applicationComponent(((MainApplication) getApplication()).getApplicationComponent())
          .mainActivityModule(new MainActivityModule(this))
          .build();
    }
    return component;
  }

  private void executeInjection() {
    component().inject(this);
  }


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    executeInjection();
    setContentView(R.layout.activity_main);
    getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);

    Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);

    setSupportActionBar(myToolbar);

    FragmentManager fm = getFragmentManager();
    FragmentTransaction ft = fm.beginTransaction();
    LeaderBoardFragment leaderBoardFragment = new LeaderBoardFragment();
    ft.replace(R.id.fragment_container, leaderBoardFragment, Constants.LEADERBOARD_FRAGMENT_TAG);
    ft.commit();

  }

}
