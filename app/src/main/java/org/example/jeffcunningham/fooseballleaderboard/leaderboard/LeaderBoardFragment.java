package org.example.jeffcunningham.fooseballleaderboard.leaderboard;

import android.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.example.jeffcunningham.fooseballleaderboard.MainActivity;
import org.example.jeffcunningham.fooseballleaderboard.R;
import org.example.jeffcunningham.fooseballleaderboard.util.Constants;
import org.example.jeffcunningham.fooseballleaderboard.util.Logger;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LeaderBoardFragment extends Fragment {

  private static final String TAG = "LeaderBoardFragment";

  @BindView(R.id.leaderboardRecyclerView)
  RecyclerView leaderboardRecyclerView;

  private RecyclerView.LayoutManager leaderboardLayoutManager;

  private LeaderBoardAdapter adapter;

  @Inject
  LeaderBoardPresenter leaderBoardPresenter;

  @Inject
  Logger logger;

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {

    ((MainActivity) getActivity()).component().inject(this);

    View view = inflater.inflate(R.layout.fragment_leaderboard, container, false);

    ButterKnife.bind(this, view);

    return view;


  }

  @Override
  public void onViewCreated(View view, Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    leaderboardRecyclerView.setHasFixedSize(true);
    leaderboardLayoutManager = new LinearLayoutManager(getActivity());
    leaderboardRecyclerView.setLayoutManager(leaderboardLayoutManager);
    adapter = new LeaderBoardAdapter(logger);
    leaderboardRecyclerView.setAdapter(adapter);

    FloatingActionButton fab = getActivity().findViewById(R.id.fab);
    fab.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        logger.info(TAG, "onClick: ");
        leaderBoardPresenter.inputMatch();
      }
    });
  }

  @Override
  public void onStart() {
    super.onStart();

    leaderBoardPresenter.getLeaderBoardData(Constants.SORT_POWER_RANKING)
        .subscribe(x -> adapter.setRankingList(x),
            e -> logger.error(TAG, "onStart: ", e));


  }


}
