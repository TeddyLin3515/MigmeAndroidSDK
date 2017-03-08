package com.migmesdk.dyson.utility;

import android.util.Log;

import com.migmesdk.dyson.Dyson;

/**
 * Created by teddylin on 07/03/2017.
 */

public class DebugLog {
    public static void d (String tag, String logMessage) {
        if (Dyson.DEBUG_MODE) {
            Log.d(tag, logMessage);
        }
    }
}
