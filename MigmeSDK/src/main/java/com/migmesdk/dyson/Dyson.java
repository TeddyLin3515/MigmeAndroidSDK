package com.migmesdk.dyson;


import android.content.Context;
import android.util.Base64;

import com.migmesdk.BuildConfig;
import com.migmesdk.dyson.data.DysonParameter;

/**
 * Created by teddylin on 03/03/2017.
 */
public class Dyson {
    public static final String TAG = "Dyson";
    public static boolean DEBUG_MODE = false;
    private DysonTracker mDysonTracker;

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
        return newTracker(context, projectName, projectUID, new String(Base64.decode(BuildConfig.DYSON_PARAM_B, Base64.DEFAULT)), DysonParameter.HTTP.DEFAULT_PRESENCE_PERIOD);
    }

    public DysonTracker newTracker(Context context, String projectName, String projectUID, long presencePeriod) {
        return newTracker(context, projectName, projectUID, new String(Base64.decode(BuildConfig.DYSON_PARAM_B, Base64.DEFAULT)), presencePeriod);
    }

    private DysonTracker newTracker(Context context, String projectName, String projectUID, String topic, long presencePeriod) {
        synchronized(this) {
            if (mDysonTracker == null) {
                mDysonTracker = new DysonTracker();
                mDysonTracker.initialize(context, projectName, projectUID, topic, presencePeriod);
            }
            return mDysonTracker;
        }
    }
}
