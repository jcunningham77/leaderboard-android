package org.example.jeffcunningham.fooseballleaderboard;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import org.example.jeffcunningham.fooseballleaderboard.di.DaggerMainComponent;
import org.example.jeffcunningham.fooseballleaderboard.di.MainComponent;
import org.example.jeffcunningham.fooseballleaderboard.di.MainModule;
import org.example.jeffcunningham.fooseballleaderboard.input.InputFragment;
import org.example.jeffcunningham.fooseballleaderboard.leaderboard.LeaderBoardFragment;
import org.example.jeffcunningham.fooseballleaderboard.util.Constants;
import org.example.jeffcunningham.fooseballleaderboard.util.Logger;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private MainComponent component;

    public TabLayout tabLayout;

    @Inject
    Logger logger;

    /** Build dagger component */
    public MainComponent component() {
        if (component == null) {
            component = DaggerMainComponent.builder()
                    .applicationComponent(((MainApplication) getApplication()).getApplicationComponent())
                    .mainModule(new MainModule())
                    .build();
        }
        return component;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        initializeTabLayout();


    }

    private void initializeTabLayout() {


        tabLayout = (TabLayout) findViewById(R.id.tabLayout);

        tabLayout.addTab(tabLayout.newTab().setText(R.string.input_tab_title));

        tabLayout.addTab(tabLayout.newTab().setText(R.string.leaderboard_tab_title));




        tabLayout.addOnTabSelectedListener(listener);

        tabLayout.setSelectedTabIndicatorColor(Color.TRANSPARENT);
    }

    /*
     *   Initialize tab layout listener
     */
    TabLayout.OnTabSelectedListener listener = new TabLayout.OnTabSelectedListener() {
        @Override
        public void onTabSelected(TabLayout.Tab tab) {
            Log.i(TAG, "onTabSelected: ");
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();

            tabLayout.setSelectedTabIndicatorColor(Color.BLUE);
            //todo extract into method
            switch (tab.getPosition()) {
                case 0:
                    InputFragment inputFragment = new InputFragment();
                    ft.replace(R.id.fragment_container, inputFragment, Constants.INPUT_RESULTS_FRAGMENT_TAG);
                    ft.commit();
                    break;
                case 1:
                    LeaderBoardFragment leaderBoardFragment = new LeaderBoardFragment();
                    ft.replace(R.id.fragment_container, leaderBoardFragment, Constants.LEADERBOARD_FRAGMENT_TAG);
                    ft.commit();
                    break;

            }
        }

        @Override
        public void onTabUnselected(TabLayout.Tab tab) {

            Log.i(TAG, "onTabUnselected: ");

        }

        @Override
        public void onTabReselected(TabLayout.Tab tab) {

            Log.i(TAG, "onTabReselected: ");

            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            tabLayout.setSelectedTabIndicatorColor(Color.BLUE);
            //todo extract into method
            switch (tab.getPosition()) {
                case 0:
                    InputFragment inputFragment = new InputFragment();
                    ft.replace(R.id.fragment_container, inputFragment, Constants.INPUT_RESULTS_FRAGMENT_TAG);
                    ft.commit();
                    break;
                case 1:
                    LeaderBoardFragment leaderBoardFragment = new LeaderBoardFragment();
                    ft.replace(R.id.fragment_container, leaderBoardFragment, Constants.LEADERBOARD_FRAGMENT_TAG);
                    ft.commit();
                    break;

            }

        }
    };
}
