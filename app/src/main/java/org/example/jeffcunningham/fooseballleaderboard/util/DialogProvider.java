package org.example.jeffcunningham.fooseballleaderboard.util;

import org.example.jeffcunningham.fooseballleaderboard.bo.Match;

public interface DialogProvider {

  void provideMatchInputDialog(Callback<Match> callback);

  interface Callback<T> {
    void onEnter(T result);
  }
}
