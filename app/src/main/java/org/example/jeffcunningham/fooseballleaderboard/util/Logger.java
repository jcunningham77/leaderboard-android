package org.example.jeffcunningham.fooseballleaderboard.util;

/**
 * Created by jeffcunningham on 1/23/17.
 */
public interface Logger {
    void error(String tag, String msg);

    void error(String tag, String msg, Throwable tr);

    void debug(String tag, String msg);

    void debug(String tag, String msg, Throwable tr);

    void info(String tag, String msg);

    void info(String tag, String msg, Throwable tr);

    void verbose(String tag, String msg);

    void verbose(String tag, String msg, Throwable tr);

    void warning(String tag, String msg);

    void warning(String tag, String msg, Throwable tr);

    String getStackTraceString(Exception e);
}
