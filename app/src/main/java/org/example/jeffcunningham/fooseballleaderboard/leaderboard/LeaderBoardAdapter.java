package org.example.jeffcunningham.fooseballleaderboard.leaderboard;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.example.jeffcunningham.fooseballleaderboard.R;
import org.example.jeffcunningham.fooseballleaderboard.bo.Player;
import org.example.jeffcunningham.fooseballleaderboard.util.Logger;

import java.util.ArrayList;
import java.util.List;

public class LeaderBoardAdapter extends RecyclerView.Adapter {

    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;

    private static final String TAG = "LeaderBoardAdapter";


    Logger logger;

    private Context context;

    public LeaderBoardAdapter(Logger logger) {
        this.logger = logger;
    }

    private List<Player> rankings = new ArrayList<Player>();


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;

        RecyclerView.ViewHolder viewHolder;
        if (viewType == TYPE_ITEM) {
            logger.info(TAG, "onCreateViewHolder: ");
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.player_view_holder, parent, false);
            viewHolder = new PlayerViewHolder(view);
        } else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ranking_header_view_holder, parent, false);
            viewHolder = new RankingHeaderViewHolder(view);
        }

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {


        if (rankings != null && rankings.size() > 1 && position>0) {

            ((PlayerViewHolder) holder).setPlayerName(rankings.get(position-1).name);
            ((PlayerViewHolder) holder).setMatchesPlayed(rankings.get(position-1).matchesPlayed);
            ((PlayerViewHolder) holder).setMatchesWon(rankings.get(position-1).matchesWon);

        }
    }


    @Override
    public int getItemCount() {
        return rankings.size()+1;
    }

    void setRankingList(List<Player> rankings) {

        this.rankings = rankings;

        notifyDataSetChanged();

    }

    @Override
    public int getItemViewType(int position) {
        if (isPositionHeader(position)) {
            return TYPE_HEADER;

        } else  {
            return TYPE_ITEM;
        }


    }

    private boolean isPositionHeader(int position) {
        return position == 0;
    }


}
