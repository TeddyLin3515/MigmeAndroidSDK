package com.migme.dyson.task;

import android.content.Context;

import com.migme.dyson.DysonEventBuilders;
import com.migme.dyson.data.DysonParameter;
import com.migme.dyson.DysonSession;
import com.migme.dyson.utility.AppTools;

/**
 * Created by teddylin on 08/03/2017.
 */

public class RunnablePresenceEvent extends RunnableForegroundEvent {
    private DysonEventBuilders.ActionEventBuilder mBuilder;
    private long mRunTime = DysonParameter.HTTP.DEFAULT_PRESENCE_PERIOD;
    private boolean mIsBackground = false;
    private DysonSession mDysonSession;

    public RunnablePresenceEvent(Context context, String topic, DysonEventBuilders.ActionEventBuilder builder, DysonSession dysonSession) {
        super(context, topic, builder);
        mBuilder = builder;
        mDysonSession = dysonSession;
    }

    private void clearRunTime() {
        mRunTime = 0L;
    }

    @Override
    public void run() {
        mRunTime += DysonParameter.RUNNABLE.DEFAULT_PERIOD;
//        DebugLog.d(Dyson.TAG, "Running time : " + mRunTime / 1000 + "s");
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
        if (mDysonSession.isSessionExpire(mRunTime)) {
            clearRunTime();
            mDysonSession.newSessionId();
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
        if (isBackgroundToForeground() || mRunTime >= mDysonSession.getPresencePeriod()) {
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
