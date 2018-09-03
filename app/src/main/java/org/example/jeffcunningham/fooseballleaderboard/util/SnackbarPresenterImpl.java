package org.example.jeffcunningham.fooseballleaderboard.util;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import javax.inject.Inject;
import org.example.jeffcunningham.fooseballleaderboard.R;

public class SnackbarPresenterImpl implements SnackbarPresenter {

  private final AppCompatActivity activity;
  private final int STANDARD_DURATION = 3500;

  @Inject
  public SnackbarPresenterImpl(AppCompatActivity activity) {
    this.activity = activity;
  }

  @Override
  public void showSnackBar(String message) {
    View view = activity.findViewById(R.id.fragment_container);
    Snackbar snackBar = Snackbar.make(view, message, STANDARD_DURATION);
    snackBar.show();

  }


}
