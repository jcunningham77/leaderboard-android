package org.example.jeffcunningham.fooseballleaderboard.input;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.example.jeffcunningham.fooseballleaderboard.MainActivity;
import org.example.jeffcunningham.fooseballleaderboard.R;

import javax.inject.Inject;

public class InputFragment extends Fragment {

    @Inject
    InputPresenter inputPresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ((MainActivity) getActivity()).component().inject(this);



        View view = inflater.inflate(R.layout.fragment_input, container, false);


        return view;
    }
}
