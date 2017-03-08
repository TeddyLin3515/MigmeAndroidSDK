package com.migmesdk.dyson.task;

import android.content.Context;

import com.migmesdk.dyson.Dyson;
import com.migmesdk.dyson.DysonEventBuilders;
import com.migmesdk.dyson.data.DysonParameter;
import com.migmesdk.dyson.data.DysonSession;
import com.migmesdk.dyson.utility.AppTools;
import com.migmesdk.dyson.utility.DebugLog;

/**
 * Created by teddylin on 08/03/2017.
 */

public class RunnablePresenceEvent extends RunnableForegroundEvent {
    private DysonEventBuilders.ActionEventBuilder mBuilder;
    private long mRunTime = DysonParameter.HTTP.DEFAULT_PRESENCE_PERIOD;
    private boolean mIsBackground = false;

    public RunnablePresenceEvent(Context context, String topic, DysonEventBuilders.ActionEventBuilder builder) {
        super(context, topic, builder);
        mBuilder = builder;
    }

    private void clearRunTime() {
        mRunTime = 0L;
    }

    @Override
    public void run() {
        mRunTime += DysonParameter.RUNNABLE.DEFAULT_PERIOD;
        DebugLog.d(Dyson.TAG, "Running time : " + mRunTime / 1000 + "s");
        if (!AppTools.isAppOnForeground(mContext)) {
            shouldClearRunTime();
            checkSession();
        } else {
            send();
        }
    }

    private void shouldClearRunTime() {
        if (isForegroundToBackground()) {
            clearRunTime();
        }
    }

    private void checkSession() {
        if (DysonSession.getInstance().isSessionExpire(mRunTime)) {
            clearRunTime();
            DysonSession.getInstance().newSessionId();
            refresh();
        }
    }

    private boolean isBackgroundToForeground() {
        if (mIsBackground) {
            mIsBackground = false;
            return true;
        }
        return false;
    }

    private boolean isForegroundToBackground() {
        if (!mIsBackground) {
            mIsBackground = true;
            return true;
        }
        return false;
    }

    private void send() {
        if (mRunTime >= DysonParameter.HTTP.DEFAULT_PRESENCE_PERIOD || isBackgroundToForeground()) {
            clearRunTime();
            refresh();
            sendRequest();
        }
    }

    private void refresh() {
        mBuilder.refresh();
        setData(mBuilder.build());
    }
}
