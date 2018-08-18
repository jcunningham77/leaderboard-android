package org.example.jeffcunningham.fooseballleaderboard.util;

import android.app.Dialog;
import org.example.jeffcunningham.fooseballleaderboard.bo.Match;

public interface DialogProvider {

  Dialog provideMatchInputDialog(Callback<Match> callback);

  interface Callback<T> {
    void onEnter(T result);
  }
}
