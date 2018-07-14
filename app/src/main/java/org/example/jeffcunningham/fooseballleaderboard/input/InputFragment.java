package org.example.jeffcunningham.fooseballleaderboard.input;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import org.example.jeffcunningham.fooseballleaderboard.MainActivity;
import org.example.jeffcunningham.fooseballleaderboard.R;
import org.example.jeffcunningham.fooseballleaderboard.bo.Match;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class InputFragment extends Fragment {

    @Inject
    InputPresenter inputPresenter;

    @BindView(R.id.player1Name)
    EditText player1Name;
    @BindView(R.id.player2Name)
    EditText player2Name;
    @BindView(R.id.player1Score)
    EditText player1Score;
    @BindView(R.id.player2Score)
    EditText player2Score;
    @BindView(R.id.button)
    Button inputMatchButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ((MainActivity) getActivity()).component().inject(this);

        View view = inflater.inflate(R.layout.fragment_input, container, false);
        ButterKnife.bind(this,view);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        inputMatchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Match match = new Match();
                match.player1Name = player1Name.getText().toString();
                match.player2Name = player2Name.getText().toString();
                match.player1Score = Integer.parseInt(player1Score.getText().toString());
                match.player2Score = Integer.parseInt(player2Score.getText().toString());
                inputPresenter.recordMatch(match);
            }
        });
    }
}
