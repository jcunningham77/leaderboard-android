package org.example.jeffcunningham.fooseballleaderboard.leaderboard;

import android.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import butterknife.BindView;
import butterknife.ButterKnife;
import javax.inject.Inject;
import org.example.jeffcunningham.fooseballleaderboard.MainActivity;
import org.example.jeffcunningham.fooseballleaderboard.R;
import org.example.jeffcunningham.fooseballleaderboard.util.Constants;
import org.example.jeffcunningham.fooseballleaderboard.util.Logger;

public class LeaderBoardFragment extends Fragment {

    private static final String TAG = "LeaderBoardFragment";

    @BindView(R.id.leaderboardRecyclerView)
    RecyclerView leaderboardRecyclerView;

    @BindView(R.id.progressBar)
    ProgressBar progressBar;

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
        progressBar.setVisibility(View.VISIBLE);
        leaderboardRecyclerView.setVisibility(View.INVISIBLE);
        leaderBoardPresenter.getLeaderBoardData(Constants.SORT_POWER_RANKING)
            .subscribe(x ->{
                    progressBar.setVisibility(View.INVISIBLE);
                    adapter.setRankingList(x);
                    leaderboardRecyclerView.setVisibility(View.VISIBLE);

                },
                e -> logger.error(TAG, "onStart: ", e));


    }


}
