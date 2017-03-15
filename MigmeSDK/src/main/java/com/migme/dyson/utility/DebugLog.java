package com.migme.dyson.utility;

import android.util.Log;

/**
 * Created by teddylin on 07/03/2017.
 */

public class DebugLog {
    private static boolean DEBUG_MODE = false;

    public static void d (String tag, String logMessage) {
        if (DEBUG_MODE) {
            Log.d(tag, logMessage);
        }
    }

    public static void setDebugMode(boolean debugMode) {
        DEBUG_MODE = debugMode;
    }

    public static boolean isDebugMode() {
        return DEBUG_MODE;
    }
}
