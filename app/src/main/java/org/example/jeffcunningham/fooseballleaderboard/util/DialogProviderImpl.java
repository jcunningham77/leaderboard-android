package org.example.jeffcunningham.fooseballleaderboard.util;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import javax.inject.Inject;
import org.example.jeffcunningham.fooseballleaderboard.R;
import org.example.jeffcunningham.fooseballleaderboard.bo.Match;

public class DialogProviderImpl implements DialogProvider, OnItemSelectedListener {

  private final AppCompatActivity activity;
  private static final String TAG = "DialogProviderImpl";
  private Logger logger;
  private int player1Score = -1;
  private int player2Score = -1;

  @Inject
  public DialogProviderImpl(AppCompatActivity activity, Logger logger) {
    this.activity = activity;
    this.logger = logger;

  }

  public void provideMatchInputDialog(Callback<Match> callback) {
    AlertDialog.Builder builder = new AlertDialog.Builder(activity,
        R.style.AppCompatAlertDialogStyle);
    View dialogView = activity.getLayoutInflater().inflate(R.layout.match_input_dialog, null);
    builder.setView(dialogView);
    builder.setOnCancelListener(DialogInterface::dismiss);
    Spinner player1ScoreSpinner = dialogView.findViewById(R.id.player1Score);
    Spinner player2ScoreSpinner = dialogView.findViewById(R.id.player2Score);
    ArrayAdapter<CharSequence> player1ScoreAdapter = ArrayAdapter
        .createFromResource(this.activity.getBaseContext(), R.array.score_array,
            android.R.layout.simple_spinner_item);
    ArrayAdapter<CharSequence> player2ScoreAdapter = ArrayAdapter
        .createFromResource(this.activity.getBaseContext(), R.array.score_array,
            android.R.layout.simple_spinner_item);

    player1ScoreAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

    player2ScoreAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    player1ScoreSpinner.setAdapter(player1ScoreAdapter);
    player2ScoreSpinner.setAdapter(player2ScoreAdapter);
    player1ScoreSpinner.setSelection(0);
    player2ScoreSpinner.setSelection(0);
    player1ScoreSpinner.setOnItemSelectedListener(this);
    player2ScoreSpinner.setOnItemSelectedListener(this);

    builder.setPositiveButton("OK", null);
    builder.setNegativeButton("Cancel", (dialogInterface, i) -> {
      activity.getWindow().setSoftInputMode(
          WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN
      );
      dialogInterface.dismiss();
    });

    builder.setCancelable(true);

    AlertDialog dialog = builder.create();
    dialog.show();

    dialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {

      @Override
      public void onClick(View view) {

        activity.getWindow().setSoftInputMode(
            WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN
        );

        TextInputLayout player1TextInputLayout = dialogView
            .findViewById(R.id.player1NameInputLayout);
        TextInputLayout player2TextInputLayout = dialogView
            .findViewById(R.id.player2NameInputLayout);
        EditText player1Name = dialogView.findViewById(R.id.player1Name);

        EditText player2Name = dialogView.findViewById(R.id.player2Name);

        if (DialogProviderImpl.this.validateEditText(player1Name, player1TextInputLayout) &&
            DialogProviderImpl.this.validateEditText(player2Name, player2TextInputLayout) &&
            DialogProviderImpl.this.validateSpinner(player1ScoreSpinner) &&
            DialogProviderImpl.this.validateSpinner(player2ScoreSpinner)) {
          Match match = new Match(player1Name.getText().toString(),
              player2Name.getText().toString(),
              player1Score,
              player2Score);
          logger.info(TAG, "provideMatchInputDialog: match =" + match.toString());
          callback.onEnter(match);
          dialog.dismiss();
        }

      }
    });
  }


  public boolean validateEditText(EditText editText, TextInputLayout textInputLayout) {

    if (editText.getText() != null && editText.getText().toString().trim().isEmpty()) {
      textInputLayout.setError(this.activity.getString(R.string.required));
      requestFocus(editText);
      return false;
    } else {
      textInputLayout.setErrorEnabled(false);
    }

    return true;
  }

  public boolean validateSpinner(Spinner spinner) {

    TextView errorText = (TextView) spinner.getSelectedView();
    if (errorText.getText().toString().equalsIgnoreCase("Score")
        ||errorText.getText().toString().isEmpty()) {

      errorText.setError("");
      errorText.setTextColor(Color.RED);//just to highlight that this is an error
      errorText.setText("");
      requestFocus(spinner);
      return false;
    }
    return true;

  }


  private void requestFocus(View view) {
    if (view.requestFocus()) {
      this.activity.getWindow()
          .setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
    }
  }


  @Override
  public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    if (i > 0) {
      switch (adapterView.getId()) {
        case R.id.player1Score:
          player1Score = Integer.parseInt((String) adapterView.getItemAtPosition(i));
          logger.info(TAG, "onItemSelected: setting player 1 score to = " + player1Score);
          break;
        case R.id.player2Score:
          player2Score = Integer.parseInt((String) adapterView.getItemAtPosition(i));
          logger.info(TAG, "onItemSelected: setting player 1 score to = " + player2Score);
          break;
      }
    }
  }

  @Override
  public void onNothingSelected(AdapterView<?> adapterView) {

  }
}
