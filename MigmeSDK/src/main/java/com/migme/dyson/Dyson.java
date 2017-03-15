package com.migme.dyson;


import android.content.Context;
import android.util.Base64;

import com.migme.BuildConfig;
import com.migme.dyson.data.DysonParameter;
import com.migme.dyson.utility.DebugLog;

/**
 * Created by teddylin on 03/03/2017.
 */
public class Dyson {
    public static final String TAG = "Dyson";
    private DysonTracker mDysonTracker;

    private static class SingletonHelper {
        private static final Dyson INSTANCE = new Dyson();
    }

    public static Dyson getInstance() {
        return SingletonHelper.INSTANCE;
    }

    public void setDebugMode(boolean debugMode) {
        DebugLog.setDebugMode(debugMode);
    }

    public boolean isDebugMode() {
        return DebugLog.isDebugMode();
    }

    public DysonTracker newTracker(Context context, String projectName) {
        return newTracker(context, projectName, "", new String(Base64.decode(BuildConfig.DYSON_PARAM_B, Base64.DEFAULT)), DysonParameter.HTTP.DEFAULT_PRESENCE_PERIOD);
    }

    public DysonTracker newTracker(Context context, String projectName, String projectUID) {
        return newTracker(context, projectName, projectUID, new String(Base64.decode(BuildConfig.DYSON_PARAM_B, Base64.DEFAULT)), DysonParameter.HTTP.DEFAULT_PRESENCE_PERIOD);
    }

    private DysonTracker newTracker(Context context, String projectName, String projectUID, long presencePeriod) {
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
