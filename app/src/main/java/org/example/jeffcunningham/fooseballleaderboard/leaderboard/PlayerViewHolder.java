package org.example.jeffcunningham.fooseballleaderboard.leaderboard;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import org.example.jeffcunningham.fooseballleaderboard.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PlayerViewHolder extends RecyclerView.ViewHolder {



    @BindView(R.id.player_name)
    TextView txtPlayerName;
    @BindView(R.id.matches_won)
    TextView txtMatchesWon;
    @BindView(R.id.matches_played)
    TextView txtMatchesPlayed;

    public PlayerViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }

    void setPlayerName(String playerName){
        txtPlayerName.setText(playerName);
    }

    void setMatchesWon(int matchesWon){
        txtMatchesWon.setText(String.valueOf(matchesWon));
    }

    void setMatchesPlayed(int matchesPlayed){
        txtMatchesPlayed.setText(String.valueOf(matchesPlayed));
    }
}
