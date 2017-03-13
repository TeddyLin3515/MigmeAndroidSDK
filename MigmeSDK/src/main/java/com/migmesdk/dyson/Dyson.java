package com.migmesdk.dyson;


import android.content.Context;

import com.migmesdk.dyson.data.DysonParameter;

/**
 * Created by teddylin on 03/03/2017.
 */
public class Dyson {
    public static final String TAG = "Dyson";
    public static boolean DEBUG_MODE = false;

    private static class SingletonHelper {
        private static final Dyson INSTANCE = new Dyson();
    }

    public static Dyson getInstance() {
        return SingletonHelper.INSTANCE;
    }

    public static void setDebugMode(boolean debugMode) {
        DEBUG_MODE = debugMode;
    }

    public DysonTracker newTracker(Context context, String projectName, String projectUID) {
        return newTracker(context, projectName, projectUID, DysonSession.DEFAULT_TOPIC, DysonParameter.HTTP.DEFAULT_PRESENCE_PERIOD);
    }

    private DysonTracker newTracker(Context context, String projectName, String projectUID, String topic) {
        return newTracker(context, projectName, projectUID, topic, DysonParameter.HTTP.DEFAULT_PRESENCE_PERIOD);
    }

    public DysonTracker newTracker(Context context, String projectName, String projectUID, long presencePeriod) {
        return newTracker(context, projectName, projectUID, DysonSession.DEFAULT_TOPIC, presencePeriod);
    }

    public DysonTracker newTracker(Context context, String projectName, String projectUID, String topic, long presencePeriod) {
        synchronized(this) {
            DysonTracker dysonTracker = new DysonTracker();
            dysonTracker.initialize(context, projectName, projectUID, topic, presencePeriod);
            return dysonTracker;
        }
    }
}
