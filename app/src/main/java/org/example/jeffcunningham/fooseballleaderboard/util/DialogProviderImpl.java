package org.example.jeffcunningham.fooseballleaderboard.util;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import javax.inject.Inject;
import org.example.jeffcunningham.fooseballleaderboard.R;
import org.example.jeffcunningham.fooseballleaderboard.bo.Match;

public class DialogProviderImpl implements DialogProvider, OnItemSelectedListener {

  private final AppCompatActivity activity;
  private static final String TAG = "DialogProviderImpl";
  private Logger logger;
  private int player1Score = 0;
  private int player2Score = 0;

  @Inject
  public DialogProviderImpl(AppCompatActivity activity, Logger logger) {
    this.activity = activity;
    this.logger = logger;

  }

  public Dialog provideMatchInputDialog(Callback<Match> callback) {
    AlertDialog.Builder builder = new AlertDialog.Builder(activity,
        R.style.AppCompatAlertDialogStyle);
    builder.setTitle(R.string.input_dialog_title);
    View view = activity.getLayoutInflater().inflate(R.layout.match_input_dialog, null);



    builder.setView(view);
    builder.setOnCancelListener(DialogInterface::dismiss);
    Spinner player1ScoreSpinner = view.findViewById(R.id.player1Score);
    Spinner player2ScoreSpinner = view.findViewById(R.id.player2Score);
    ArrayAdapter<CharSequence> player1ScoreAdapter = ArrayAdapter.createFromResource(this.activity.getBaseContext(),R.array.score_array,android.R.layout.simple_spinner_item);
    ArrayAdapter<CharSequence> player2ScoreAdapter = ArrayAdapter.createFromResource(this.activity.getBaseContext(),R.array.score_array,android.R.layout.simple_spinner_item);

    player1ScoreAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

    player2ScoreAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    player1ScoreSpinner.setAdapter(player1ScoreAdapter);
    player2ScoreSpinner.setAdapter(player2ScoreAdapter);
    player1ScoreSpinner.setSelection(0);
    player2ScoreSpinner.setSelection(0);
    player1ScoreSpinner.setOnItemSelectedListener(this);
    player2ScoreSpinner.setOnItemSelectedListener(this);
    builder.setPositiveButton("OK", (dialog, which) -> {
      activity.getWindow().setSoftInputMode(
          WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN
      );
      EditText player1Name = view.findViewById(R.id.player1Name);
      EditText player2Name = view.findViewById(R.id.player2Name);


      Match match = new Match(player1Name.getText().toString(),
          player2Name.getText().toString(),
          player1Score,
          player2Score);
      logger.info(TAG, "provideMatchInputDialog: match =" + match.toString());

            callback.onEnter(match);
    });
    builder.setNegativeButton("Cancel", (dialogInterface, i) -> {
      activity.getWindow().setSoftInputMode(
          WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN
      );
      dialogInterface.dismiss();
    });

    builder.setCancelable(true);

    return builder.create();

  }

  @Override
  public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    switch (adapterView.getId()){
      case R.id.player1Score:

        player1Score = Integer.parseInt((String)adapterView.getItemAtPosition(i));
        logger.info(TAG, "onItemSelected: setting player 1 score to = " + player1Score);
        break;
      case R.id.player2Score:
        player2Score = Integer.parseInt((String)adapterView.getItemAtPosition(i));
        logger.info(TAG, "onItemSelected: setting player 1 score to = " + player2Score);
        break;
    }


  }

  @Override
  public void onNothingSelected(AdapterView<?> adapterView) {

  }
}
