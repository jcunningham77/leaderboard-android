package org.example.jeffcunningham.fooseballleaderboard.util;

import android.util.Log;

import javax.inject.Inject;

/**
 * Created by jeffcunningham on 1/23/17.
 */

public class LoggerImpl implements Logger {




    @Inject
    public LoggerImpl() {

    }

    @Override
    public void error(String tag, String msg) {
        Log.e(tag, msg);
    }

    @Override
    public void error(String tag, String msg, Throwable tr) {
        Log.e(tag, msg, tr);
    }

    @Override
    public void debug(String tag, String msg) {
        Log.d(tag, msg);
    }

    @Override
    public void debug(String tag, String msg, Throwable tr) {
        Log.d(tag, msg, tr);
    }

    @Override
    public void info(String tag, String msg) {
        Log.i(tag, msg);
    }

    @Override
    public void info(String tag, String msg, Throwable tr) {
        Log.i(tag, msg, tr);
    }

    @Override
    public void verbose(String tag, String msg) {
        Log.v(tag, msg);
    }

    @Override
    public void verbose(String tag, String msg, Throwable tr) {
        Log.v(tag, msg, tr);
    }

    @Override
    public void warning(String tag, String msg) {
        Log.w(tag, msg);
    }

    @Override
    public void warning(String tag, String msg, Throwable tr) {
        Log.w(tag, msg, tr);
    }

    @Override
    public String getStackTraceString(Exception e) {
        return Log.getStackTraceString(e);
    }


}

